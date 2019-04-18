package psa.fitness;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import psa.helper.Generator;
import psa.model.Generation;
import psa.system.Candidate;
import psa.system.Population;

public class fitnessTest {

	@Test
	public void TestFittest() {
		Generator.getInstance();
		Population p = Population.getInstance();
		p.createGeneration0();
		FitnessCalculation fc = new FitnessCalculation();
		fc.fitness();
		Generation g = p.getGenerationMap().get(0);
		boolean max = false;
		for(Candidate c:g.getCandidateList()) {
			if(c.getFitness() <= g.getFittest()) {
				max = true;
			}
		}
		assertEquals(true,max);	
	}
	
}
