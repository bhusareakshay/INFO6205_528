package psa.model;

import java.util.ArrayList;
import java.util.List;

import psa.system.Candidate;

public class Generation {

	private double fittest;
	private List<Candidate> candidateList;
	
	public Generation() {
		candidateList = new ArrayList<Candidate>();
	}

	public double getFittest() {
		return fittest;
	}

	public void setFittest(double fittest) {
		this.fittest = fittest;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
	
}
