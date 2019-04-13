package psa.fitness;
import java.util.Collections;
import java.util.List;

import psa.model.Generation;
import psa.system.Candidate;
import psa.system.Population;


public class FitnessCalculation {

	public void fitness() {
		Population p = Population.getInstance();
		Generation currentGen = p.getGenerationMap().get(Collections.max(p.getGenerationMap().keySet()));
		List<Candidate>candidateList = currentGen.getCandidateList();
		
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
		currentGen.setFittest(candidateList.get(0).getFitness());
		System.out.println("Fittest........."+currentGen.getFittest());
	}	
	
}
