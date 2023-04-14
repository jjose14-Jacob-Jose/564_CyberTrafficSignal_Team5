package logic;

public class Node {

	private String direction;
	private Integer countPrimary;
	private Integer countSecondary;
	private String lastExecution;
	private Boolean changeSignal;

	public Node() {

	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLastExecution() {
		return lastExecution;
	}

	public void setLastExecution(String lastExecution) {
		this.lastExecution = lastExecution;
	}

	public int getCountPrimary() {
		return countPrimary;
	}

	public void setCountPrimary(int countPrimary) {
		this.countPrimary = countPrimary;
	}

	public int getCountSecondary() {
		return countSecondary;
	}

	public void setCountSecondary(int countSecondary) {
		this.countSecondary = countSecondary;
	}

	public boolean isChangeSignal() {
		return changeSignal;
	}

	public void setChangeSignal(boolean changeSignal) {
		this.changeSignal = changeSignal;
	}

}
