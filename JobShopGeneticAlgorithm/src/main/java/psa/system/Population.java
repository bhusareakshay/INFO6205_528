package psa.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import psa.helper.Generator;
import psa.model.*;

import psa.model.Constants;

public class Population {
	
	private static Population population;
	private int[][] operationJob;
	private Map<Integer, Generation> generationMap;

	private Population() {
		operationJob = new int[Constants.TOTAL_JOBS][Constants.TOTAL_OPERATIONS];
		generationMap = new HashMap<Integer, Generation>();
		createGeneration0();
		//Generator.getInstance().timeArray();
		
	}
	
	public static Population getInstance() {
		if(population == null) {
			population = new Population();
		}
		return population;
	}

	public int[][] getOperationJob() {
		return operationJob;
	}

	public void setOperationJob(int[][] operationJob) {
		this.operationJob = operationJob;
	}	
	
	public Map<Integer, Generation> getGenerationMap() {
		return generationMap;
	}

	public void setGenerationMap(Map<Integer, Generation> generationMap) {
		this.generationMap = generationMap;
	}

	/*
	 * Method to create the initial generation i.e. generation0
	 */
	public void createGeneration0() {
		Generation gen = new Generation();
		List<Candidate> candidateList = null;
		for(int i = 0; i<Constants.POPULATION_SIZE/10; i++) {
			candidateList = gen.getCandidateList();
			candidateList.add(createCandidate());
		}
		gen.setCandidateList(candidateList);
		generationMap.put(0, gen);
	}
	
	
	/*
	 * Method to create Candidates/Individuals of a generation/population
	 */
	public Candidate createCandidate() {
		Candidate candidate = new Candidate();
		List<String> chromosomeList = candidate.getChromosomesList();
		List<Integer> machineList = new ArrayList<Integer>(Generator.getMachineMap().keySet());
		
		/*
		 * for(int k = 0; k<Constants.TOTAL_MACHINES; k++) { machineList.add(k); }
		 */
		Collections.shuffle(machineList);
			for(int i = 0; i<Constants.TOTAL_OPERATIONS; i++) {
				Collections.shuffle(machineList);
				for(int j = 0; j<Constants.TOTAL_JOBS; j++) {
					operationJob[i][j] = machineList.get(j);
					String chromosome = String.format("%02d", i)+String.format("%02d", j)+String.format("%02d", operationJob[i][j]);
					
					chromosomeList.add(chromosome);
				}
			}
			
			candidate.setChromosomesList(chromosomeList);
			//System.out.println(chromosomeList);
			return candidate;
	}
}
