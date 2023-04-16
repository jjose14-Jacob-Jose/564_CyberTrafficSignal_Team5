package logic;

import java.util.HashMap;
import java.util.Map;

public class CriticalFlow {

	private Integer countPrimaryRoad;
	private Integer countSecondaryRoad;
	private String direction;
	private int saturationNS;
	private int saturationEW;

	public CriticalFlow(Integer countPrimaryRoad, Integer countSecondaryRoad, String direction, int saturationNS,
			int saturationEW) {
		super();
		this.countPrimaryRoad = countPrimaryRoad;
		this.countSecondaryRoad = countSecondaryRoad;
		this.direction = direction;
		this.saturationNS = saturationNS;
		this.saturationEW = saturationEW;
	}

	public Integer getCountPrimaryRoad() {
		return countPrimaryRoad;
	}

	public void setCountPrimaryRoad(Integer countPrimaryRoad) {
		this.countPrimaryRoad = countPrimaryRoad;
	}

	public Integer getCountSecondaryRoad() {
		return countSecondaryRoad;
	}

	public void setCountSecondaryRoad(Integer countSecondaryRoad) {
		this.countSecondaryRoad = countSecondaryRoad;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getSaturationNS() {
		return saturationNS;
	}

	public void setSaturationNS(int saturationNS) {
		this.saturationNS = saturationNS;
	}

	public int getSaturationEW() {
		return saturationEW;
	}

	public void setSaturationEW(int saturationEW) {
		this.saturationEW = saturationEW;
	}

	public Map<String, Double> getCriticalFlow() {
		double criticalFlowNS = 0;
		double criticalFlowEW = 0;
		Map<String, Double> map = new HashMap<>();

		if (this.countPrimaryRoad != null && this.countSecondaryRoad != null && this.direction != null) {
			if (this.getDirection().equals(Constants.NS)) {
				criticalFlowNS = ((double) this.countPrimaryRoad * 60 / this.saturationNS * 1.000);
				criticalFlowEW = ((double) this.countSecondaryRoad * 60 / this.saturationEW * 1.000);
			} else {
				criticalFlowEW = ((double) this.countPrimaryRoad * 60 / this.saturationEW * 1.000);
				criticalFlowNS = ((double) this.countSecondaryRoad * 60 / this.saturationNS * 1.000);
			}
		}

		map.put("criticalFlowNS", criticalFlowNS);
		map.put("criticalFlowEW", criticalFlowEW);

		return map;
	}

}
