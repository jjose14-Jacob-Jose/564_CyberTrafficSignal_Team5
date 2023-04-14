package logic;

public class InputData {

	private boolean isNorthEmergency;
	private boolean isSouthEmergency;
	private boolean isEastEmergency;
	private boolean isWestEmergency;

	private int northIncomingVehicle;
	private int northOutgoingVehicle;

	private int southIncomingVehicle;
	private int southOutgoingVehicle;

	private int eastIncomingVehicle;
	private int eastOutgoingVehicle;

	private int westIncomingVehicle;
	private int westOutgoingVehicle;

	private int saturationNS;
	private int saturationEW;

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

	public boolean isNorthEmergency() {
		return isNorthEmergency;
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

	public int getNorthIncomingVehicle() {
		return northIncomingVehicle;
	}

	public void setNorthIncomingVehicle(int northIncomingVehicle) {
		this.northIncomingVehicle = northIncomingVehicle;
	}

	public int getNorthOutgoingVehicle() {
		return northOutgoingVehicle;
	}

	public void setNorthOutgoingVehicle(int northOutgoingVehicle) {
		this.northOutgoingVehicle = northOutgoingVehicle;
	}

	public int getSouthIncomingVehicle() {
		return southIncomingVehicle;
	}

	public void setSouthIncomingVehicle(int southIncomingVehicle) {
		this.southIncomingVehicle = southIncomingVehicle;
	}

	public int getSouthOutgoingVehicle() {
		return southOutgoingVehicle;
	}

	public void setSouthOutgoingVehicle(int southOutgoingVehicle) {
		this.southOutgoingVehicle = southOutgoingVehicle;
	}

	public int getEastIncomingVehicle() {
		return eastIncomingVehicle;
	}

	public void setEastIncomingVehicle(int eastIncomingVehicle) {
		this.eastIncomingVehicle = eastIncomingVehicle;
	}

	public int getEastOutgoingVehicle() {
		return eastOutgoingVehicle;
	}

	public void setEastOutgoingVehicle(int eastOutgoingVehicle) {
		this.eastOutgoingVehicle = eastOutgoingVehicle;
	}

	public int getWestIncomingVehicle() {
		return westIncomingVehicle;
	}

	public void setWestIncomingVehicle(int westIncomingVehicle) {
		this.westIncomingVehicle = westIncomingVehicle;
	}

	public int getWestOutgoingVehicle() {
		return westOutgoingVehicle;
	}

	public void setWestOutgoingVehicle(int westOutgoingVehicle) {
		this.westOutgoingVehicle = westOutgoingVehicle;
	}

}
