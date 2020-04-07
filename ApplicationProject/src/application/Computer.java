package application;


public class Computer {
	
	private double responseTime;
	private int diff;
	private double implementChaos = Math.random();
	
	public Computer(int iDiff) {
		diff = iDiff;
		
	}
	public void setDifficulty(int newDiff) {
		switch (newDiff) {
			case 1:
				responseTime = implementChaos + 1;						//set response time to random number (slow)
			case 2:
				responseTime = (implementChaos * 0.5) + 0.75;			//set response time to random number(decent)
			case 3:
				responseTime = (implementChaos * 0.33) + 0.5;			//set response time to random number (fast)
			}
																		//No need for default, only 1,2,3 are possible
	}
	public double getDifficulty() { 	return diff;}					//accessors
	
	public double getResponseTime() {	return responseTime;}			//accessors
	
	public void setResponseTime(double newTime) {	responseTime = newTime;}//mutators
	
	

}
