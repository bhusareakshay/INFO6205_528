package psa.JobShopGeneticAlgorithm;


import java.util.Collections;
import java.util.List;

import psa.crossover.GenerationCrosssover;
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
		/*
		 * Generator.getInstance(); Population.getInstance().createCandidate();
		 */
    	
		
		  System.out.println( "Hello World!" ); 
		  Generator.getInstance(); 
		  Population p = Population.getInstance(); 
		  for (int i = 0 ; i< 100; i++) {
		  ExpressionGeneration eg = new ExpressionGeneration();
		  eg.CalculateExpression();
		  
		  FitnessCalculation fit = new FitnessCalculation(); fit.fitness();
		  
		  GenerationCrosssover gc = new GenerationCrosssover();
		  
		  gc.doCrossover(); }
		 
    }
}
