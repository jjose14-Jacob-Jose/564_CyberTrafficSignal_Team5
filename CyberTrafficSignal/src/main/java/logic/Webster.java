package logic;

public class Webster {

	Double criticalFlowNS;
	Double criticalFlowEW;
	String direction;
	final int lostTime = 2;
	final int allRed = 12;
	final int countPhase = 2;
	Double OCL;
	Double ya;
	Double L;

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
		Integer greenTime=null;
		if (this.criticalFlowNS != null && this.criticalFlowEW != null && this.direction != null) {
			L=(double) ((countPhase*lostTime)+allRed);
			OCL=(1.5*L+5)/(1-criticalFlowNS+criticalFlowEW);
			
			if(direction.equals("NS")) {
				ya=criticalFlowNS;
			}else {
				ya=criticalFlowEW;
				
			}
			
			greenTime=(int) Math.round((ya/(criticalFlowNS+criticalFlowEW))*(OCL-L));
		}
		return greenTime;
	}

}
