import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestLCA {
	@Test
	public void testNode() 
	{
		Node tree = new Node(1); 
		tree.left= new Node(2);
		tree.right = new Node(3);
		
		
		assertEquals(2,tree.left.data);
		assertEquals(3,tree.right.data);
		assertEquals(1,tree.data);
	}
	

	@Test
	public void testForNull()
	{
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root=null;
		assertEquals("null",-1,tree.findLCA(3,2));
	}
	
	@Test
	public void TestLCA(){
		Node tree = new Node(1);
		tree.left = new Node(2);
		tree.right = new Node(3);
		tree.left.left = new Node(4);
		tree.left.right = new Node(5);
		tree.right.left= new Node(6);
		tree.right.right = new Node(7);
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.root = tree;
		assertEquals(2,lca.findLCA(4, 5));
		assertEquals(3,lca.findLCA(6, 7));
		assertEquals(1,lca.findLCA(4, 6));
		assertEquals(1,lca.findLCA(3, 4));
		assertEquals(2,lca.findLCA(2, 4));
	}
	
	@Test
	//Tests the function findLCA internal
	public void TestLCAInternal(){
		Node tree = new Node(0);
		tree.left = new Node(1);
		tree.right = new Node(2);
		tree.left.left = new Node(3);
		tree.left.right = new Node(4);
		tree.right.left= new Node(5);
		tree.right.right = new Node(6);
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();
		LowestCommonAncestor root = new LowestCommonAncestor();
		assertEquals("",-1,root.LCAInternal(tree, 9,8 ));
		assertEquals(0,root.LCAInternal(tree, 1, 2));
		
	}
}
