package psa.system;

import java.util.ArrayList;
import java.util.List;

public class Candidate {

	
	private List<String> chromosomesList;
	private int fitness;
	private int tMax;
	
	public Candidate() {
		chromosomesList = new ArrayList<String>();
	}
	
	
	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	public int gettMax() {
		return tMax;
	}

	public void settMax(int tMax) {
		this.tMax = tMax;
	}

	public List<String> getChromosomesList() {
		return chromosomesList;
	}

	public void setChromosomesList(List<String> chromosomesList) {
		this.chromosomesList = chromosomesList;
	}

	
	
}
