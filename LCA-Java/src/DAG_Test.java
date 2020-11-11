import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class DAG_Test extends TestCase {
	
	 /*Tests constructor of lowest common ancestor class*/
	 @Test
	    public void testConstructor() 
	    {
		 new DAG_Test();
	    
	    }
	 
	 /*Tests the graph is correctly constructed as a binary tree*/
	 
	 
	 
		 //tests to check if returns correct number of vertices in the DAG
		 @Test
		 public void testV()
		 {
			 	DAG dag = new DAG(5);
				assertEquals("Test V() failed", 5, dag.V());
		 }
		 
		 //tests to check if returns correct vertices pointing from v
		 @Test
		 public void testAdj()
		 {
			 	DAG dag = new DAG(5);
				assertEquals("Test V() failed", 5, dag.V());
				ArrayList<Integer> expectedResult = new ArrayList<Integer>();
				
				//Test for empty DAG before adding vertexes
				assertTrue(dag.adj(0).size() == expectedResult.size()); 						 //make sure array list sizes are same
				assertEquals("Test for empty DAG failed", true, dag.adj(0).isEmpty());
				
				//populate the DAG
				dag.addEdge(0,1);
				dag.addEdge(1,2);
				
				//test for when only one node is adjacent
				expectedResult.add(2);
				assertEquals("Test for one adjacent node failed", expectedResult, dag.adj(1));
				
				//test for when numerous nodes are adjacent 
				dag.addEdge(1, 3);
				dag.addEdge(1,4);
				expectedResult.add(3);
				expectedResult.add(4);
				assertTrue(dag.adj(1).size() == expectedResult.size());  							//make sure array list sizes are same
				assertEquals("Test for one adjacent node failed", expectedResult, dag.adj(1));
		 }
		 

		 	@Test
			public void testDagLowestCommonAncestor(){
				DAG dag = new DAG(5);
				
				dag.addEdge(0, 1);
				dag.addEdge(0, 2);
				dag.addEdge(2, 3);
				dag.addEdge(3, 4);
				
				ArrayList<Integer> expectedResult = new ArrayList<Integer>();
				expectedResult.add(0);
						
				assertTrue("Size of lca is different to the size of the expected result", dag.lowestCommonAncestor(4,1).size() == expectedResult.size());
				for(int i : expectedResult)
				{
					assertTrue("Testing single lca return", dag.lowestCommonAncestor(4,1).contains(i));
				}
				
				//testing a dag that returns multiple lca's
				DAG dag2 = new DAG(7);

				dag2.addEdge(0, 3);			
				dag2.addEdge(1, 3);
				dag2.addEdge(1, 4);
				dag2.addEdge(2, 5);
				dag2.addEdge(2, 6);
				dag2.addEdge(3, 5);
				dag2.addEdge(3, 6);
				dag2.addEdge(4, 6);
				
				expectedResult.clear();
				expectedResult.add(2);
				expectedResult.add(3);
						
				assertTrue("lcas size different from expected results size", dag2.lowestCommonAncestor(5,6).size() == expectedResult.size());
				for(int i : expectedResult)
				{
					assertTrue("Testing mutliple lca return", dag2.lowestCommonAncestor(5,6).contains(i));
				}
					
				
				//Testing input above or below the range of dag
				assertTrue("Testing out of range inputs", dag2.lowestCommonAncestor(1000, 257).isEmpty());
				
				//Testing non present vertices input to the dag
				assertTrue("Testing negative inputs", dag2.lowestCommonAncestor(-2, -1).isEmpty());		
		 	}	
		 
		 
}