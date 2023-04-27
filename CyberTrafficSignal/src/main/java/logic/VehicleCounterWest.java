package logic;

public class VehicleCounterWest implements VehicleCounterIfc {

	private int incomingVehicle;
	private int outgoingVehicle;

	public VehicleCounterWest(int incomingVehicle, int outgoingVehicle) {
		super();
		this.incomingVehicle = incomingVehicle;
		this.outgoingVehicle = outgoingVehicle;
	}

	public int getIncomingVehicle() {
		return incomingVehicle;
	}

	public void setIncomingVehicle(int incomingVehicle) {
		this.incomingVehicle = incomingVehicle;
	}

	public int getOutgoingVehicle() {
		return outgoingVehicle;
	}

	public void setOutgoingVehicle(int outgoingVehicle) {
		this.outgoingVehicle = outgoingVehicle;
	}

	public int getCount() {

		return (this.incomingVehicle - this.outgoingVehicle);

	}

}
