package application;


/**
 * @author Hit Me or Hit Them Group
 *
 */
public class Computer {
	
	private double responseTime;
	private int diff;
	private double implementChaos = Math.random();
	
	public Computer(int iDiff) {
		diff = iDiff;
		
	}
	
	/**
	 * This method sets the difficulty of the SlapJack game
	 * @param newDiff
	 */
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
	
	/**
	 * this method gets the difficulty and returns it
	 * @return returns a double - difficulty
	 */
	public double getDifficulty() { 	return diff;}					//accessors
	
	/**
	 * this method returns the response time of the computer
	 * @return returns a double - response time
	 */
	public double getResponseTime() {	return responseTime;}			//accessors
	
	/**
	 * this method sets the response time of the computer
	 * @param newTime
	 */
	public void setResponseTime(double newTime) {	responseTime = newTime;}//mutators
	
	

}
