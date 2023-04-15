package logic;

import java.util.HashMap;
import java.util.Map;

public class LightSignalController {

	private String direction;
	private String emergency;
	private boolean isEmergency;
	private int counter;
	private String dir;
	private boolean NSgsLatch;
	private boolean EWgsLatch;
	private boolean NSrsLatch;
	private boolean EWrsLatch;
	private boolean NSysLatch;
	private boolean EWysLatch;

	public LightSignalController(String direction, String emergency) {
		super();

		this.direction = direction;
		this.emergency = emergency;
		this.isEmergency = false;
		this.counter = 0;
		this.dir = "";
		this.NSgsLatch = false;
		this.EWgsLatch = false;
		this.NSrsLatch = false;
		this.EWrsLatch = false;
		this.NSysLatch = false;
		this.EWysLatch = false;

	}

	public Map<String, Boolean> determineSignal() {

		Map<String, Boolean> map = new HashMap<>();

		if (emergency != null) {
			counter = 20;
			dir = emergency;
			isEmergency = true;
			emergency = null;
		}

		if (isEmergency) {
			while (counter-- > 0) {
				if (dir.equals(Constants.NORTH) || dir.equals(Constants.SOUTH)) {
					NSgsLatch = true;
					EWrsLatch = true;
				} else {
					EWgsLatch = true;
					NSrsLatch = true;
				}
			}

			isEmergency = false;
		} else {
			if (direction.equals(Constants.NS)) {
				NSgsLatch = true;
				EWrsLatch = true;

			} else {
				EWgsLatch = true;
				NSrsLatch = true;
			}
		}

		map.put("NSgsLatch", NSgsLatch);
		map.put("EWgsLatch", EWgsLatch);
		map.put("NSrsLatch", NSrsLatch);
		map.put("EWrsLatch", EWrsLatch);
		map.put("NSysLatch", NSysLatch);
		map.put("EWysLatch", EWysLatch);

		return map;
	}

}
