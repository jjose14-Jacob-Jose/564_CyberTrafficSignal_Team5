package logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DataProcessingController {

	Integer greenTime;
	Integer counter;
	String direction;
	String emergency;

	public DataProcessingController(Integer greenTime, String direction, String emergency) {
		super();
		this.greenTime = greenTime;
		this.direction = direction;
		this.emergency = emergency;
	}

	public boolean calculateChangeSignal() {
		if (greenTime != null) {
			this.counter = this.greenTime;
		}

		Map<String, Boolean> map = new HashMap<>();

		while (this.counter > 0) {

			LightSignalController lightSignalController = new LightSignalController(this.direction, this.emergency);
			map = lightSignalController.determineSignal();

			this.counter--;
		}

		for (Entry<String, Boolean> eachEntry : map.entrySet()) {
			System.out.println(eachEntry.getKey() + " - " + eachEntry.getValue());
		}

		System.out.println("NSysLatch" + " - " + true);
		System.out.println("EWysLatch" + " - " + true);

		return true;
	}

}
