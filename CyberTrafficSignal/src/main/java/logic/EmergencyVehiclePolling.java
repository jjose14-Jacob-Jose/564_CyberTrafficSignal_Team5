package logic;

public class EmergencyVehiclePolling {

	private boolean isNorthEmergency;
	private boolean isSouthEmergency;
	private boolean isEastEmergency;
	private boolean isWestEmergency;

	public boolean isNorthEmergency() {
		return isNorthEmergency;
	}

	public EmergencyVehiclePolling(InputData inputData) {
		super();
		this.isNorthEmergency = inputData.isNorthEmergency();
		this.isSouthEmergency = inputData.isSouthEmergency();
		this.isEastEmergency = inputData.isEastEmergency();
		this.isWestEmergency = inputData.isWestEmergency();
	}

	public void setNorthEmergency(boolean isNorthEmergency) {
		this.isNorthEmergency = isNorthEmergency;
	}

	public boolean isSouthEmergency() {
		return isSouthEmergency;
	}

	public void setSouthEmergency(boolean isSouthEmergency) {
		this.isSouthEmergency = isSouthEmergency;
	}

	public boolean isEastEmergency() {
		return isEastEmergency;
	}

	public void setEastEmergency(boolean isEastEmergency) {
		this.isEastEmergency = isEastEmergency;
	}

	public boolean isWestEmergency() {
		return isWestEmergency;
	}

	public void setWestEmergency(boolean isWestEmergency) {
		this.isWestEmergency = isWestEmergency;
	}

	public String isAnyEmergency() {

		if (isNorthEmergency) {
			return Constants.NORTH;
		} else if (isEastEmergency) {
			return Constants.EAST;
		} else if (isSouthEmergency) {
			return Constants.SOUTH;
		} else if (isWestEmergency) {
			return Constants.WEST;
		}

		else {
			return null;
		}
	}

}
