package logic;

import java.util.List;
import java.util.Map;

public class Application {

	static int lastNorthVehicleCount;
	static int lastSouthVehicleCount;
	static int lastEastVehicleCount;
	static int lastWestVehicleCount;
	static String lastExecution;
	static boolean changeSignal;
	static int roundCount;

	public static void main(String[] args) {

		lastNorthVehicleCount = 0;
		lastSouthVehicleCount = 0;
		lastEastVehicleCount = 0;
		lastWestVehicleCount = 0;
		lastExecution = Constants.NS;
		changeSignal = true;
		roundCount = 0;

		try {

			List<InputData> listOfRounds = ParseData.parseFile(".\\resources\\inputData.txt");

			for (InputData inputData : listOfRounds) {
				roundCount++;
				System.out.println(
						"                      ****** Round: " + roundCount + " started ******                      ");
				System.out.println(" ");

				EmergencyVehiclePolling evp = new EmergencyVehiclePolling(inputData);

				String isAnyEmergency = evp.isAnyEmergency();

				// North Counter
				VehicleCounter vehicleCounterNorth = new VehicleCounter(inputData.getNorthIncomingVehicle(),
						inputData.getNorthOutgoingVehicle());
				lastNorthVehicleCount += vehicleCounterNorth.getCount();

				// South Counter
				VehicleCounter vehicleCounterSouth = new VehicleCounter(inputData.getSouthIncomingVehicle(),
						inputData.getSouthOutgoingVehicle());
				lastSouthVehicleCount += vehicleCounterSouth.getCount();

				// East Counter
				VehicleCounter vehicleCounterEast = new VehicleCounter(inputData.getEastIncomingVehicle(),
						inputData.getEastOutgoingVehicle());
				lastEastVehicleCount += vehicleCounterEast.getCount();

				// West Counter
				VehicleCounter vehicleCounterWest = new VehicleCounter(inputData.getWestIncomingVehicle(),
						inputData.getWestOutgoingVehicle());
				lastWestVehicleCount += vehicleCounterWest.getCount();

				System.out.println("Current green direction: " + lastExecution);
				System.out.println(" ");

				System.out.println(
						"North vehicle Count         South vehicle Count          West vehicle Count          East vehicle Count");
				System.out.println("       " + lastNorthVehicleCount + "     " + "                    "
						+ lastSouthVehicleCount + "     " + "                            " + lastWestVehicleCount
						+ "     " + "               " + lastEastVehicleCount + "     ");

				System.out.println(" ");

				System.out.println(
						isAnyEmergency != null ? "Emergency Vehicle detected for " + isAnyEmergency + " direction."
								: "No Emergency Vehicle detected in this round.");

				System.out.println(" ");

				// Determine Direction and Count
				DetermineDirection determineDirection = new DetermineDirection(lastNorthVehicleCount,
						lastSouthVehicleCount, lastEastVehicleCount, lastWestVehicleCount, lastExecution, changeSignal);

				Node result = determineDirection.determineCountAndDirection();
				// lastExecution = result.getLastExecution();

				// Critical Flow

				CriticalFlow criticalFlow = new CriticalFlow(result.getCountPrimary(), result.getCountSecondary(),
						result.getDirection(), inputData.getSaturationNS(), inputData.getSaturationEW());
				Map<String, Double> cfMap = criticalFlow.getCriticalFlow();

				// Webster Module

				Webster webster = new Webster(cfMap.get("criticalFlowNS"), cfMap.get("criticalFlowEW"),
						result.getDirection());

				int greenTime = webster.findGreenTime();

				System.out.println(isAnyEmergency == null ? "Calculated Green Time: " + greenTime + " seconds"
						: "Calculated Green Time: 20 seconds");
				System.out.println(" ");

				// Data Processing Controller
				DataProcessingController dataProcessingController = new DataProcessingController(greenTime,
						result.getDirection(), isAnyEmergency);
				Map<String, Boolean> lightSignalResponse = dataProcessingController.calculateChangeSignal();

				if (lightSignalResponse.get("EWgsLatch")) {
					lastExecution = Constants.EW;
				} else if (lightSignalResponse.get("NSgsLatch")) {
					lastExecution = Constants.NS;
				}

			}
		} catch (Exception e) {
			System.err.println("Exception Occured: ");
			e.printStackTrace();
		}

	}

}
