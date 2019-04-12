package psa.crossover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import psa.model.Generation;
import psa.system.Candidate;
import psa.system.Population;

public class GenerationCrosssover {
private	int parent1;
private int parent2;
List<String> childChromozome;
List<Candidate> candidateList;
List<Candidate> prevGenerationCandiList;
Population p ;
public  GenerationCrosssover() {
p =Population.getInstance();

}


public void doCrossover() {
	System.out.println("in crossover:::");
	
	Random rand = new Random();
	
	Generation currentGen = p.getGenerationMap().get(Collections.max(p.getGenerationMap().keySet()));

	 prevGenerationCandiList = currentGen.getCandidateList();
	
	candidateList = new ArrayList<Candidate>();
	
	addFittestCandidates(); 
	
	for(int i = 0 ; i < prevGenerationCandiList.size()/2; i++) {
		parent1= rand.nextInt(prevGenerationCandiList.size()); 
		parent2 =rand.nextInt(prevGenerationCandiList.size());
		
		List<String> parent1Chromozome = prevGenerationCandiList.get(parent1).getChromosomesList();
		List<String> parent2Chromozome = prevGenerationCandiList.get(parent2).getChromosomesList();
	
	 childChromozome = new ArrayList<String>();
	
	childChromozome.addAll(parent1Chromozome.subList(0,(parent1Chromozome.size())/2 ));
	childChromozome.addAll(parent2Chromozome.subList(((parent2Chromozome.size())/2 ), parent2Chromozome.size()));
	Candidate childC = createChildCandidate();
	candidateList.add(childC);
	
	}
	createNewGeneration();
	
	
}
//create new candidate with newly created chromozome
public Candidate createChildCandidate() {
	
	Candidate childCandidate = new Candidate();
	childCandidate.setChromosomesList(childChromozome);
	childCandidate.setFitness(0);
	childCandidate.settMax(0);
	return childCandidate;
	
}


// method to create new generation
public void createNewGeneration() {
	Generation newGen = new Generation();
	newGen.setCandidateList(candidateList);
	newGen.setFittest(0);
	
int maxkey =Collections.max(p.getGenerationMap().keySet());
p.getGenerationMap().put(maxkey, newGen);

}

public void addFittestCandidates() {
	candidateList.addAll(prevGenerationCandiList.subList(0, (prevGenerationCandiList.size())/2));
	System.out.println(candidateList.size());
	
	
}


}
