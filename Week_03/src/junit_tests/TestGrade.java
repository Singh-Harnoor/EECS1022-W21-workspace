package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Grade;

public class TestGrade {

	@Test
	public void test1() {
		String grade = Grade.getLetterGrade1(63);
		assertEquals("C", grade);
	}
	
	@Test
	public void test2() {
		String grade = Grade.getLetterGrade2(63);
		assertEquals("C", grade);
	}
	
	@Test
	public void test3() {
		String grade = Grade.getLetterGrade2(91);
		assertEquals("A+", grade);
	}
	@Test
	public void test4() {
		String grade = Grade.getLetterGrade3(63);
		assertEquals("C", grade);
	}
	
	@Test
	public void test5() {
		String grade = Grade.getLetterGrade3(91);
		assertEquals("A+", grade);
	}
	
	@Test
	public void test6() {
		String grade = Grade.getLetterGrade3(67);
		assertEquals("C+", grade);
	}
	
	@Test
	public void test7() {
		String result = Grade.getGradeReport(61);
		assertEquals("Grade C: Well Done!", result);
	}
	
	@Test
	public void test8() {
		String result = Grade.getGradeReport(59);
		assertEquals("Grade D+: You Can Do Better Next Time!", result);
	}
	
	
	
}
