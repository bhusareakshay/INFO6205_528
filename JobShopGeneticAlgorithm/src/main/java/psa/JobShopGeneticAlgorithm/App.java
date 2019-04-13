package psa.JobShopGeneticAlgorithm;

import psa.expression.ExpressionGeneration;
import psa.helper.Generator;
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
        System.out.println( "Hello World!" );
        Generator.getInstance();
       Population p = Population.getInstance();
      
       ExpressionGeneration  eg = new ExpressionGeneration();
       eg.CalculateExpression();
    
    
    
    }
}
