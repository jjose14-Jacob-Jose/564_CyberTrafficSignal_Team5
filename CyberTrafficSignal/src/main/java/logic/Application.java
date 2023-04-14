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

	public static void main(String[] args) {

		lastNorthVehicleCount = 0;
		lastSouthVehicleCount = 0;
		lastEastVehicleCount = 0;
		lastWestVehicleCount = 0;
		lastExecution = "NS";
		changeSignal = true;

		try {

			List<InputData> listOfRounds = ParseData.parseFile(".\\resources\\inputData.txt");

			for (InputData inputData : listOfRounds) {
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

				// Determine Direction and Count
				DetermineDirection determineDirection = new DetermineDirection(lastNorthVehicleCount,
						lastSouthVehicleCount, lastEastVehicleCount, lastWestVehicleCount, lastExecution, changeSignal);

				Node result = determineDirection.determineCountAndDirection();
				lastExecution = result.getLastExecution();

				// Critical Flow

				CriticalFlow criticalFlow = new CriticalFlow(result.getCountPrimary(), result.getCountSecondary(),
						result.getDirection(), inputData.getSaturationNS(), inputData.getSaturationEW());
				Map<String, Double> cfMap = criticalFlow.getCriticalFlow();

				// Webster Module

				Webster webster = new Webster(cfMap.get("criticalFlowNS"), cfMap.get("criticalFlowEW"),
						result.getDirection());

				int greenTime = webster.findGreenTime();

				// Data Processing Controller
				DataProcessingController dataProcessingController = new DataProcessingController(greenTime,
						result.getDirection(), isAnyEmergency);
				dataProcessingController.calculateChangeSignal();

			}
		} catch (Exception e) {
			System.err.println("Exception Occured: ");
			e.printStackTrace();
		}

	}

}
