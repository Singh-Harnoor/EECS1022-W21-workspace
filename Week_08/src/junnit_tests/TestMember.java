package junnit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Facility;
import model.Member;

public class TestMember {

	@Test
	public void test_01a() {
		Facility f1 = new Facility("Spinning class", 2.5, 1);
		Facility f2 = new Facility("Gym", 2.0, 2);
		Facility f3 = new Facility("Locker", 1.5, 3);
		
		Member heeyeon = new Member("Heeyeon");
		assertEquals(0, heeyeon.getNumberOfFacilities());
		heeyeon.addFacility(f1);
		assertEquals(1, heeyeon.getNumberOfFacilities());
		heeyeon.addFacility(f2);
		assertEquals(2, heeyeon.getNumberOfFacilities());
		heeyeon.addFacility(f3);
		assertEquals(3, heeyeon.getNumberOfFacilities());
		
	}
	
	@Test
	public void test_01b() { // anonymous objects
//		Facility f1 = new Facility("Spinning class", 2.5, 1);
//		Facility f2 = new Facility("Gym", 2.0, 2);
//		Facility f3 = new Facility("Locker", 1.5, 3);
		
		Member heeyeon = new Member("Heeyeon");
		assertEquals(0, heeyeon.getNumberOfFacilities());
		/*passing the address of an object being created on the fly
		 * (without first storing its address in a variable) 
		 */
		heeyeon.addFacility(new Facility("Spinning class", 2.5, 1)); // Anonymous object
		assertEquals(1, heeyeon.getNumberOfFacilities());
		heeyeon.addFacility(new Facility("Gym", 2.0, 2));
		assertEquals(2, heeyeon.getNumberOfFacilities());
		heeyeon.addFacility(new Facility("Locker", 1.5, 3));
		assertEquals(3, heeyeon.getNumberOfFacilities());
		// cons of anonymous objects: we cannot use variables such as 'f1', 'f2', and 'f3' to refer to the objects.
		// Instead, we need to get access to the underlying private 'facilities' array.
		// heeyon.facilities (this is invalid because facilities is private and thus invisible)
		
		
	}
	
	@Test
	public void test_01c() { // overloaded methods
//		Facility f1 = new Facility("Spinning class", 2.5, 1);
//		Facility f2 = new Facility("Gym", 2.0, 2);
//		Facility f3 = new Facility("Locker", 1.5, 3);
		
		Member heeyeon = new Member("Heeyeon");
		assertEquals(0, heeyeon.getNumberOfFacilities());
		heeyeon.addFacility("Spinning class", 2.5, 1); /* overloaded version */
		assertEquals(1, heeyeon.getNumberOfFacilities());
		heeyeon.addFacility("Gym", 2.0, 2);
		assertEquals(2, heeyeon.getNumberOfFacilities());
		heeyeon.addFacility("Locker", 1.5, 3);
		assertEquals(3, heeyeon.getNumberOfFacilities());
		
	}
	
	@Test
	public void test_02() {
		Facility f1 = new Facility("Spinning class", 2.5, 1);
		Facility f2 = new Facility("Gym", 2.0, 2);
		Facility f3 = new Facility("Locker", 1.5, 3);
		
		Member heeyeon = new Member("Heeyeon");
		heeyeon.addFacility(f1);
		heeyeon.addFacility(f2);
		heeyeon.addFacility(f3);
		
		assertEquals(2.5*1+2.0*2+1.5*3, heeyeon.getPaymentDue(), 0.01);
		
	}
	
	@Test
	public void test_03() {
		Facility f1 = new Facility("Spinning class", 2.5, 1);
		Facility f2 = new Facility("Gym", 2.0, 2);
		Facility f3 = new Facility("Locker", 1.5, 3);
		
		Member heeyeon = new Member("Heeyeon");
		heeyeon.addFacility(f1);
		heeyeon.addFacility(f2);
		heeyeon.addFacility(f3);
		
		int units = heeyeon.getFacilityUnits("Gym");
		assertEquals(2, units);
		
		heeyeon.extendFacilityUnits("Gym", 2);
		assertEquals(4, heeyeon.getFacilityUnits("Gym"));
		
		assertEquals(2.5*1+2.0*4+1.5*3, heeyeon.getPaymentDue(), 0.01);
		
	}
	
}
