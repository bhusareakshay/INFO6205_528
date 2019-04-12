package psa.model;

import java.util.Random;

public class Constants {
	
	public static final int TOTAL_JOBS = 10;
	public static final int TOTAL_MACHINES = 10;
	public static final int TOTAL_OPERATIONS = 10;
	public static final int POPULATION_SIZE = 1000;
	
	public static final int[][] JMEXECUTIONTIME = new int[TOTAL_JOBS][TOTAL_MACHINES];
	
	public void timeArray() {
		for(int i = 0; i<TOTAL_JOBS; i++) {
			for(int j = 0; j<TOTAL_MACHINES; j++) {
				JMEXECUTIONTIME[i][j] = (new Random().nextInt(10)+1)*10;
			}
		}
	}
	
	
}
