package psa.fitness;

import static org.junit.Assert.assertEquals;
import psa.expression.*;

import org.junit.Test;

import psa.expression.ExpressionGeneration;
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
		ExpressionGeneration exp = new ExpressionGeneration();
		exp.CalculateExpression();
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
	
	@Test
	public void TestInfinity() {
		Population p = Population.getInstance();
		p.createGeneration0();
		ExpressionGeneration exp = new ExpressionGeneration();
		exp.CalculateExpression();
		FitnessCalculation fc = new FitnessCalculation();
		fc.fitness();
		Generation g = p.getGenerationMap().get(0);
		boolean infinite = false;
		for(Candidate c:g.getCandidateList()) {
			try{
				double inv = 1/c.gettMax();
				if( 1/inv == 0.0){
					infinite = true;
				}
			}catch(Exception e) {
				
			}
		}
		assertEquals(false,infinite);	
	}
	
}
