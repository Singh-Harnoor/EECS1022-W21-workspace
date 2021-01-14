import static org.junit.Assert.*;

import org.junit.Test;

public class TestCircle {
	
	/*
	 * Each test method corresponds to a ***manual***
	 * launch and interaction with the CircleApp2
	 */
	@Test
	public void test1() {
		assertEquals(314.0, Circle.getArea(10), 0.01);
	}
	
	@Test
	public void test2() {
		assertEquals(3.14*25.0*25.0, Circle.getArea(25.0), 0.01);
	}
	

}
