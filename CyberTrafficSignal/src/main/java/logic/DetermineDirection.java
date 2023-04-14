package logic;

public class DetermineDirection {

	int northCount;
	int southCount;
	int eastCount;
	int westCount;
	String lastExecution;
	boolean changeSignal;

	public int getNorthCount() {
		return northCount;
	}

	public DetermineDirection(int northCount, int southCount, int eastCount, int westCount, String lastExecution,
			boolean changeSignal) {
		super();
		this.northCount = northCount;
		this.southCount = southCount;
		this.eastCount = eastCount;
		this.westCount = westCount;
		this.lastExecution = lastExecution;
		this.changeSignal = changeSignal;
	}

	public void setNorthCount(int northCount) {
		this.northCount = northCount;
	}

	public int getSouthCount() {
		return southCount;
	}

	public void setSouthCount(int southCount) {
		this.southCount = southCount;
	}

	public int getEastCount() {
		return eastCount;
	}

	public void setEastCount(int eastCount) {
		this.eastCount = eastCount;
	}

	public int getWestCount() {
		return westCount;
	}

	public void setWestCount(int westCount) {
		this.westCount = westCount;
	}

	public String getLastExecution() {
		return lastExecution;
	}

	public void setLastExecution(String lastExecution) {
		this.lastExecution = lastExecution;
	}

	public boolean isChangeSignal() {
		return changeSignal;
	}

	public void setChangeSignal(boolean changeSignal) {
		this.changeSignal = changeSignal;
	}

	public Node determineCountAndDirection() {

		int northSouth = this.northCount + this.southCount;
		int eastWest = this.eastCount + this.westCount;
		Node node = new Node();

		if (this.changeSignal) {
			if (this.lastExecution.equals("NS")) {
				if (eastWest > 0) {
					node.setCountPrimary(eastWest);
					node.setCountSecondary(northSouth);
					node.setDirection("EW");
					node.setLastExecution("EW");
				} else {
					node.setCountPrimary(northSouth);
					node.setCountSecondary(eastWest);
					node.setDirection("NS");
					node.setLastExecution("NS");
				}
			} else {
				if (northSouth > 0) {
					node.setCountPrimary(northSouth);
					node.setCountSecondary(eastWest);
					node.setDirection("NS");
					node.setLastExecution("NS");
				} else {
					node.setCountPrimary(eastWest);
					node.setCountSecondary(northSouth);
					node.setDirection("EW");
					node.setLastExecution("EW");
				}
			}
		}

		return node;
	}

}
