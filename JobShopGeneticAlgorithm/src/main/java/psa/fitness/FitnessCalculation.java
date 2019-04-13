package psa.fitness;
import java.util.Collections;
import java.util.List;

import psa.system.Candidate;


public class FitnessCalculation {

	public void fitness(List<Candidate> candidateList) {
		
		for(int i=0;i<candidateList.size();i++) {
			double inv = 1.0/candidateList.get(i).gettMax();
			System.out.println(i+"......"+ candidateList.get(i).gettMax() + ".........."+inv);
			candidateList.get(i).setFitness(inv);
		}
		
		Collections.sort(candidateList,Candidate.CanComparator);
		System.out.println("--AFTER--");
		for(int i=0;i<candidateList.size();i++) {
			System.out.println("Sorted Array....." + candidateList.get(i).gettMax());
		}
	}	
	
}
