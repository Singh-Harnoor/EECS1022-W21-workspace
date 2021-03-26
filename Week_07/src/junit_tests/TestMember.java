package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Member;
import model.Trainer;

public class TestMember {
	
	// Reference aliasing: copying the address
	@Test
	public void test_aliasing_01a() {
		Member alan = new Member(85, 175);
		Member mark = new Member(101, 181);
		
		// Initial measures 
		assertEquals(85, alan.getWeight(), 0.1);
		assertEquals(101, mark.getWeight(), 0.1);
		assertEquals("Overweight (27.8)", alan.getBMIreport());
		assertEquals("Obese (30.8)", mark.getBMIreport());
		
		// Change measures
		alan.changeWeightBy(-13); // Only Alan changes the weight
		assertEquals("Normal (23.5)", alan.getBMIreport());
		assertEquals("Obese (30.8)", mark.getBMIreport()); // Mark's BMI remains the same 
	}
	
	@Test
	public void test_aliasing_01b() {
		Member alan = new Member(85, 175);
		Member mark = new Member(101, 181);
		
		// Initial measures 
		assertEquals(85, alan.getWeight(), 0.1);
		assertEquals(101, mark.getWeight(), 0.1);
		assertEquals("Overweight (27.8)", alan.getBMIreport());
		assertEquals("Obese (30.8)", mark.getBMIreport());
		
		assertFalse(mark == alan);
		mark = alan;
		assertTrue(mark == alan);
		
		// Change measures
		alan.changeWeightBy(-13); // Only Alan changes the weight
		assertEquals("Normal (23.5)", alan.getBMIreport());
		assertEquals("Normal (23.5)", mark.getBMIreport()); 
	}
	
	// Reference aliasing: Swap the address
	@Test
	public void test_aliasing_02() {
		Member alan = new Member();
		Member mark = new Member();
		
		Member oldAlan = alan;
		Member oldMark = mark;
		
		// Swap 
		Member tom = alan;
		alan = mark;
		mark = tom;
		
		assertTrue(alan == oldMark);
		assertTrue(mark == oldAlan);
	}
	
	@Test
	public void test_MemberTrainer_01() {
		Member alan = new Member("Alan");
		Member mark = new Member("Mark");	
		Member tom = new Member("Tom");
		
		assertTrue(alan.getTrainer() == null);
		assertNull(mark.getTrainer()); // equivalent to: mark.getTrainer() == null
		assertFalse(tom.getTrainer() != null);
		
		Trainer jared = new Trainer("Jared");
		Trainer jon = new Trainer("Jon");

		alan.registerTrainer(jared);
		mark.registerTrainer(jon);
		
		assertTrue(alan.getTrainer() != null && alan.getTrainer() == jared);
		assertTrue(mark.getTrainer() != null && mark.getTrainer() == jon); // equivalent to: mark.getTrainer() == null
		assertFalse(tom.getTrainer() != null);
		
		tom.referTrainer(mark);
		assertTrue(tom.getTrainer() != null && tom.getTrainer() == jon);
		
		tom.referTrainer(alan);
		assertTrue(tom.getTrainer() != null && tom.getTrainer() == jared);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}








