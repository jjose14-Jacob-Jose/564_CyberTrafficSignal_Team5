package logic;

import java.util.HashMap;
import java.util.Map;

public interface Constants {

	public static final String NORTH = "NORTH";
	public static final String SOUTH = "SOUTH";
	public static final String EAST = "EAST";
	public static final String WEST = "WEST";
	public static final String NS = "NORTH-SOUTH";
	public static final String EW = "EAST-WEST";

	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static final Map<String, String> trafficSignal = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("EWgsLatch", "EAST-WEST-GREEN");
			put("EWysLatch", "EAST-WEST-YELLOW");
			put("EWrsLatch", "EAST-WEST-RED");
			put("NSgsLatch", "NORTH-SOUTH-GREEN");
			put("NSysLatch", "NORTH-SOUTH-YELLOW");
			put("NSrsLatch", "NORTH-SOUTH-RED");
		}
	};
}
