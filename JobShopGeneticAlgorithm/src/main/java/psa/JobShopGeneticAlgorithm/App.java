package psa.JobShopGeneticAlgorithm;


import java.util.Collections;
import java.util.List;

import psa.expression.ExpressionGeneration;
import psa.fitness.FitnessCalculation;
import psa.helper.Generator;
import psa.model.Generation;
import psa.system.Candidate;
import psa.system.Population;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<Candidate> candidatelist = null;
        System.out.println( "Hello World!" );
        Generator.getInstance();
       Population p = Population.getInstance();
      
       ExpressionGeneration  eg = new ExpressionGeneration();
       eg.CalculateExpression();

       Generation currentGen = p.getGenerationMap().get(Collections.max(p.getGenerationMap().keySet()));
       
       candidatelist = currentGen.getCandidateList();
   	FitnessCalculation fit = new FitnessCalculation();
   	fit.fitness(candidatelist);
    
    
    }
}
