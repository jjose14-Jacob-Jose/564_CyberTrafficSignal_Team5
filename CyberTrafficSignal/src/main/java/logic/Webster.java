package logic;

public class Webster {

	private Double criticalFlowNS;
	private Double criticalFlowEW;
	private String direction;
	private final int lostTime = 2;
	private final int allRed = 0;
	private final int countPhase = 2;
	private Double OCL;
	private Double ya;
	private Double L;

	public Webster(Double criticalFlowNS, Double criticalFlowEW, String direction) {
		super();
		this.criticalFlowNS = criticalFlowNS;
		this.criticalFlowEW = criticalFlowEW;
		this.direction = direction;
		this.OCL = 0.0;
		this.ya = 0.0;
		L = 0.0;
	}

	public Integer findGreenTime() {
		Integer greenTime = null;
		if (this.criticalFlowNS != null && this.criticalFlowEW != null && this.direction != null) {
			L = (double) ((countPhase * lostTime) + allRed);

			if (direction.equals(Constants.NS)) {
				ya = criticalFlowNS;
			} else {
				ya = criticalFlowEW;

			}
			double y = (ya / (criticalFlowNS + criticalFlowEW));

			double temp;
			if (y >= 1) {
				temp = 1;
			} else {
				temp = (1 - y);
			}

			OCL = (1.5 * L + 5) / temp;
			greenTime = (int) Math.round((ya / y) * (OCL - L));
		}
		return greenTime <= 0 ? 30 : greenTime <= 180 ? greenTime : 180;
	}

}
