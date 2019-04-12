package psa.model;

import java.util.ArrayList;
import java.util.List;

import psa.system.Candidate;

public class Generation {

	private int fittest;
	private List<Candidate> candidateList;
	
	public Generation() {
		candidateList = new ArrayList<Candidate>();
	}

	public int getFittest() {
		return fittest;
	}

	public void setFittest(int fittest) {
		this.fittest = fittest;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
	
}
