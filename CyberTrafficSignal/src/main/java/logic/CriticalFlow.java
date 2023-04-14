package logic;

import java.util.HashMap;
import java.util.Map;

public class CriticalFlow {

	Integer countPrimaryRoad;
	Integer countSecondaryRoad;
	String direction;
	int saturationNS;
	int saturationEW;

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
			if (this.getDirection().equals("NS")) {
				criticalFlowNS = ((double) this.saturationNS / this.countPrimaryRoad);
				criticalFlowEW = ((double) this.saturationEW / this.countSecondaryRoad);
			} else {
				criticalFlowEW = ((double) this.saturationEW / this.countPrimaryRoad);
				criticalFlowNS = ((double) this.saturationNS / this.countSecondaryRoad);
			}
		}

		map.put("criticalFlowNS", criticalFlowNS);
		map.put("criticalFlowEW", criticalFlowEW);

		return map;
	}

}
