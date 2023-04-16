package logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DataProcessingController {

	private Integer greenTime;
	private Integer counter;
	private String direction;
	private String emergency;
	private LightSignalController lightSignalController;

	public DataProcessingController(Integer greenTime, String direction, String emergency) {
		super();
		this.greenTime = greenTime;
		this.direction = direction;
		this.emergency = emergency;
	}

	public Map<String, Boolean> calculateChangeSignal() {
		if (greenTime != null) {
			this.counter = this.greenTime;
		}

		Map<String, Boolean> map = new HashMap<>();

		while (this.counter > 0) {

			lightSignalController = new LightSignalController(this.direction, this.emergency);
			map = lightSignalController.determineSignal();

			this.counter--;
		}

		for (Entry<String, Boolean> eachEntry : map.entrySet()) {
			if (eachEntry.getValue() == true) {
				String val = Constants.trafficSignal.get(eachEntry.getKey());
				if (val.contains("GREEN")) {
					System.out.println(Constants.ANSI_GREEN + val + Constants.ANSI_RESET);
				} else if (val.contains("RED")) {
					System.out.println(Constants.ANSI_RED + val + Constants.ANSI_RESET);
				}

			}

		}

		System.out.println(" ");
		System.out.println("                    ********* Round Over *********                      ");

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(" ");

		return map;
	}

}
