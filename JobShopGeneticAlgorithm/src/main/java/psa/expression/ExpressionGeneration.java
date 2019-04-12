package psa.expression;

import psa.system.Candidate;
import psa.model.Constants;

import java.util.Collections;
import java.util.List;

import psa.system.Population;
import psa.model.Generation;
import psa.helper.Generator;
import psa.model.Job;
import psa.model.Machine;

public class ExpressionGeneration {
	private int job;
	private int machine;
	private int executionTime;

	Generator g = Generator.getInstance();

	public ExpressionGeneration() {

	}

	public void CalculateExpression() {
		Population p = Population.getInstance();
		// OOJJMM
		// String[] candi = { "010101", "010102", "020103" };

		Generation currentGen = p.getGenerationMap().get(Collections.max(p.getGenerationMap().keySet()));

		List<Candidate> generation = currentGen.getCandidateList();
		for (int c = 0; c < 5; c++) {
			Candidate candidate = generation.get(c);

			List candi = candidate.getChromosomesList();
			for (int i = 0; i < candi.size(); i++) {
				String chromozome = (String) candi.get(i);

				int operation = Integer.parseInt(chromozome.substring(0, 2));
				job = Integer.parseInt(chromozome.substring(2, 4));
				machine = Integer.parseInt(chromozome.substring(4));

				System.out.println("J::"+job);
				
				Machine m = g.getMachineMap().get(machine);
//m.setCurrentTime(0);
System.out.println("jobsize:::"+g.getJobMap().size());
				Job j = g.getJobMap().get(job);
	//				j.setEndTime(0);
		//			j.setStartTime(0);
				
				calculateDuration(m, j);
			
System.out.println("machine::::"+machine+"time:::::"+m.getCurrentTime());
System.out.println("JOb  ::::::"+job+" end time:::: "+j.getEndTime());
System.out.println("JOb ::::::"+job+"start time:::"+j.getStartTime());
//System.out.println("gene::::::");
			}
			System.out.println("Candidiate:::::::::::::::::::::::::----------------------------------"+c);
			g.resetJobs();
			g.resetMachines();
		}
	}

	public void calculateDuration(Machine m, Job j) {
		executionTime = Constants.JMEXECUTIONTIME[job][machine];
		System.out.println("in calculate:::");
		
		int jobEndTime = j.getEndTime();
		System.out.println("jobEndTime::::"+jobEndTime);
		
	
		int prevMcTime = m.getCurrentTime();
		System.out.println("machine time::"+prevMcTime);
		
		if (jobEndTime == 0) {

			m.setCurrentTime(prevMcTime + executionTime);
			j.setStartTime(prevMcTime);
			j.setEndTime(prevMcTime + executionTime);
		} else {
			if (jobEndTime > prevMcTime) {
				m.setCurrentTime(jobEndTime + executionTime);
				j.setStartTime(jobEndTime);
				j.setEndTime(jobEndTime + executionTime);

			} else {
				m.setCurrentTime(prevMcTime + executionTime);
				j.setStartTime(prevMcTime);
				j.setEndTime(prevMcTime + executionTime);
			}
		}

	}

}
