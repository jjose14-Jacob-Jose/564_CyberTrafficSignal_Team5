package logic;

import java.util.List;
import java.util.Map;

public class Application {

	private static int lastNorthVehicleCount;
	private static int lastSouthVehicleCount;
	private static int lastEastVehicleCount;
	private static int lastWestVehicleCount;
	private static String lastExecution;
	private static boolean changeSignal;
	private static int roundCount;
	private static VehicleCounterIfc vehicleCounterNorth;
	private static List<InputData> listOfRounds;
	private static EmergencyVehiclePolling evp;
	private static VehicleCounterIfc vehicleCounterSouth;
	private static VehicleCounterIfc vehicleCounterEast;
	private static VehicleCounterIfc vehicleCounterWest;
	private static DetermineDirection determineDirection;
	private static Node result;
	private static CriticalFlow criticalFlow;
	private static Webster webster;
	private static DataProcessingController dataProcessingController;
	private static ParseData parseData;

	public static void main(String[] args) {

		lastNorthVehicleCount = 0;
		lastSouthVehicleCount = 0;
		lastEastVehicleCount = 0;
		lastWestVehicleCount = 0;
		lastExecution = Constants.NS;
		changeSignal = true;
		roundCount = 0;
		parseData = new ParseData();

		try {

			listOfRounds = parseData.parseFile(".\\resources\\inputData.txt");

			for (InputData inputData : listOfRounds) {
				roundCount++;
				System.out.println(
						"                      ****** Round: " + roundCount + " started ******                      ");
				System.out.println(" ");

				evp = new EmergencyVehiclePolling(inputData);

				String isAnyEmergency = evp.isAnyEmergency();

				// North Counter
				vehicleCounterNorth = new VehicleCounterNorth(inputData.getNorthIncomingVehicle(),
						inputData.getNorthOutgoingVehicle());
				lastNorthVehicleCount += vehicleCounterNorth.getCount();

				// South Counter
				vehicleCounterSouth = new VehicleCounterSouth(inputData.getSouthIncomingVehicle(),
						inputData.getSouthOutgoingVehicle());
				lastSouthVehicleCount += vehicleCounterSouth.getCount();

				// East Counter
				vehicleCounterEast = new VehicleCounterEast(inputData.getEastIncomingVehicle(),
						inputData.getEastOutgoingVehicle());
				lastEastVehicleCount += vehicleCounterEast.getCount();

				// West Counter
				vehicleCounterWest = new VehicleCounterWest(inputData.getWestIncomingVehicle(),
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
				determineDirection = new DetermineDirection(lastNorthVehicleCount, lastSouthVehicleCount,
						lastEastVehicleCount, lastWestVehicleCount, lastExecution, changeSignal);

				result = determineDirection.determineCountAndDirection();
				// lastExecution = result.getLastExecution();

				// Critical Flow

				criticalFlow = new CriticalFlow(result.getCountPrimary(), result.getCountSecondary(),
						result.getDirection(), inputData.getSaturationNS(), inputData.getSaturationEW());
				Map<String, Double> cfMap = criticalFlow.getCriticalFlow();

				// Webster Module

				webster = new Webster(cfMap.get("criticalFlowNS"), cfMap.get("criticalFlowEW"), result.getDirection());

				int greenTime = webster.findGreenTime();

				System.out.println(isAnyEmergency == null ? "Calculated Green Time: " + greenTime + " seconds"
						: "Calculated Green Time: 20 seconds");
				System.out.println(" ");

				// Data Processing Controller
				dataProcessingController = new DataProcessingController(greenTime, result.getDirection(),
						isAnyEmergency);
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
