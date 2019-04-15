package psa.crossover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import psa.expression.ExpressionGeneration;
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
	System.out.println("in crossover::::::::::::::::::::::::::::::::::::::");
	
	Random rand = new Random();
	
	Generation currentGen = p.getGenerationMap().get(Collections.max(p.getGenerationMap().keySet()));

	 prevGenerationCandiList = currentGen.getCandidateList();
	
	candidateList = new ArrayList<Candidate>();
	
	addFittestCandidates(); 
	//int size = prevGenerationCandiList.size()/0.9;
	for(int i = 0 ; i < prevGenerationCandiList.size()*0.9; i++) {
		parent1= rand.nextInt(prevGenerationCandiList.size()); 
		parent2 =rand.nextInt(prevGenerationCandiList.size());
	//	System.out.println("P1:::::::::"+parent1+"P2:::::::"+parent2);
		
		List<String> parent1Chromozome = prevGenerationCandiList.get(parent1).getChromosomesList();
		List<String> parent2Chromozome = prevGenerationCandiList.get(parent2).getChromosomesList();
	
	 childChromozome = new ArrayList<String>();
	
	childChromozome.addAll(parent1Chromozome.subList(0,(parent1Chromozome.size())/2 ));
	childChromozome.addAll(parent2Chromozome.subList(((parent2Chromozome.size())/2 ), parent2Chromozome.size()));
	Candidate childC = createChildCandidate();
	candidateList.add(childC);
	
	}
	
	
	
	
	createNewGeneration();
	//Boolean isExit = calculateExit();
	
//	if(!isExit) {
//		createNewGeneration();
//		 ExpressionGeneration  eg = new ExpressionGeneration();
//	       eg.CalculateExpression();
//	}
//	
	
	
	
	
}
//create new candidate with newly created chromozome
public Candidate createChildCandidate() {
	
	Candidate childCandidate = new Candidate();
//	System.out.println("childChromozome:::::::::"+childChromozome.size());
	childCandidate.setChromosomesList(childChromozome);
	childCandidate.setFitness(0);
	childCandidate.settMax(0);
	return childCandidate;
	
}


// method to create new generation
public void createNewGeneration() {
	Generation newGen = new Generation();
	//System.out.println("Generationnum:::::::::::::"+p.getGenerationMap().keySet()+1);
	for(int i = 0 ; i < candidateList.size() ; i++) {
	//	System.out.println("candi::::"+candidateList.get(i));
  List<String> chr = candidateList.get(i).getChromosomesList();
//  for (String s : chr) {
////	  System.out.print(s+"-");
//	  
//  }
 // System.out.println();
 // System.out.println("---------------------------------------------------------------------------------");
		
	}
	newGen.setCandidateList(candidateList);
	newGen.setFittest(0);	
int maxkey =Collections.max(p.getGenerationMap().keySet());
p.getGenerationMap().put(maxkey+1, newGen);
System.out.println("MKey ::::"+(maxkey+1));
if(maxkey+1 == 80) {
	for(int i = 0 ; i < p.getGenerationMap().get(maxkey+1).getCandidateList().size() ; i ++) {
		System.out.println("a:::::::::::"+p.getGenerationMap().get(maxkey+1).getCandidateList().get(i).getChromosomesList());
	}
}
}

public void addFittestCandidates() {
	candidateList.addAll(prevGenerationCandiList.subList(0, (prevGenerationCandiList.size())/10));
	System.out.println(candidateList.size());	
}


public Boolean calculateExit() {
	int generationCount= 1;
	System.out.println("in exit:::::");
	double maxKey = p.getGenerationMap().get(Collections.max(p.getGenerationMap().keySet())).getFittest();
	 generationCount = Collections.max(p.getGenerationMap().keySet());
	if(generationCount >= 10) {
		
		for(int i = 0  ; i< 5 ; i++) {
			
			if(maxKey == p.getGenerationMap().get(generationCount).getFittest()) {
				generationCount--;
				System.out.println("in for:: if::");
			}
			else {
				System.out.println("in first Else");
				return false;
			}		
		}
		System.out.println("in returing true::::");
		return true;
	}else {
		System.out.println("in second Else  false::");
		return false;
	}
	}


}
