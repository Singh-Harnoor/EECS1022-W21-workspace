package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Utilities;

public class TestUtilities {

	@Test
	public void test_01() {
		
		int[][] input1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		String output1 = Utilities.getPrintOutRowbyRow(input1);	
		String expected1 = "{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}";
		assertEquals(expected1, output1);
 		
		int[][] input2 = {{1, 2, 3, 4}, {5, 6, 7}, {8}};
		String output2 = Utilities.getPrintOutRowbyRow(input2);	
		String expected2 = "{{1, 2, 3, 4}, {5, 6, 7}, {8}}";
		assertEquals(expected2, output2);
		
	}

	@Test
	public void test_02() {
		
		int[][] input1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		String output1 = Utilities.getPrintOutColbyCol(input1);	
		String expected1 = "{{1, 5, 9}, {2, 6, 10}, {3, 7, 11}, {4, 8, 12}";
		assertEquals(expected1, output1);
	}
	
	@Test
	public void test_03() {
		
		int[][] input1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		double output1 = Utilities.getAverage(input1);	
		double expected1 = 6.5;
		assertEquals(expected1, output1, 0.01);
		
		int[][] input2 = {{1, 2, 3, 4}, {5, 6, 7}, {8}};
		double output2 = Utilities.getAverage(input2);
		double expected2 = 4.5;
		assertEquals(expected2, output2, 0.01);
	}
	
	@Test
	public void test_04() {
		
		int[][] input1 = {{1, 2, 3, 4}, {5, 8, 7, 6}, {9, 10, 11, 12}};
		double[] output1 = Utilities.getRowAverages(input1);	
		double[] expected1 = {2.5, 6.5, 10.5};
		assertTrue(output1.length == expected1.length);
		for(int i =0; i < expected1.length; i++) {
			assertEquals(expected1[i], output1[i], 0.01);
		}
		
		
		int[][] input2 = {{1, 2, 3, 4}, {5, 8, 7}, {6}};
		double[] output2 = Utilities.getRowAverages(input2);	
		double[] expected2 = {2.5, 6.6, 6.0};
		assertTrue(output2.length == expected2.length);
		for(int i =0; i < expected2.length; i++) {
			assertEquals(expected2[i], output2[i], 0.1);
		}
	}

	@Test
	public void test_05() {
		
		int[][] input1 = {{1, 10, 5, 7}, {6, 2, 12, 9}, {3, 8, 4, 11}};
		int[] output1 = Utilities.getMAxMin(input1);	
		int[] expected1 = {12, 1};
		assertArrayEquals(expected1, output1);
		
		
		int[][] input2 = {{6, 2, 5, 3}, {4, 8, 1}, {7}};
		int[] output2 = Utilities.getMAxMin(input2);	
		int[] expected2 = {8, 1};
		assertArrayEquals(expected1, output1);
	}
	
	@Test
	public void test_06() {
		
		int[][] input1 = {{1, 10, 5, 7}, {6, 2, 12, 9}, {3, 8, 4, 11}};
		boolean output1 = Utilities.allPositive(input1);	
		boolean expected1 = true;
		assertEquals(expected1, output1);
		
		int[][] input2 = {{10, 10, 10, 10}, {41}, {-4, 29, 13}};
		boolean output2 = Utilities.allPositive(input2);	
		boolean expected2 = false;
		assertEquals(expected1, output1);
		
	}
	
	@Test
	public void test_07() {
		
		int[][] input1 = {{10, 10, 10, 10}, {41}, {-4, 29, 13}};
		int[] output1 = Utilities.getRowMaxSum(input1);	
		int[] expected1 = {41};
		assertArrayEquals(expected1, output1);
		
	}
	
	@Test
	public void test_08() {
		
		int[][] input1 = {{1, 10, 5, 7}, {6, 2, 12, 9}, {3, 8, 4, 11}};
		boolean output1 = Utilities.isRectangle(input1);	
		boolean expected1 = true;
		assertEquals(expected1, output1);
		
		int[][] input2 = {{10, 10, 10, 10}, {41, 23, 46}, {-4, 29, 13, -100}};
		boolean output2 = Utilities.isRectangle(input2);	
		boolean expected2 = false;
		assertEquals(expected1, output1);
		
	}
	
}
