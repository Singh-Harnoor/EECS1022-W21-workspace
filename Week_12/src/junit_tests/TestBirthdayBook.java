package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Birthday;
import model.BirthdayBookV1;
import model.BirthdayBookV2;

public class TestBirthdayBook {

	@Test
	public void test_01() {
			
			// Create an empty birthday book
			BirthdayBookV1 bb = new BirthdayBookV1();
			assertEquals(0, bb.getSize());
			
			// add four entries in the birthday book
			bb.addBirthday("Alan", new Birthday(5, 21));
			bb.addBirthday("Mark", new Birthday(8, 11));
			bb.addBirthday("Tom" , new Birthday(8, 11));
			bb.addBirthday("Jim" , new Birthday(10, 15));
			
			assertEquals(4, bb.getSize());
			// inquire about the birthdays
			Birthday jimBirthday = bb.getBirthday("Jim");
			assertTrue(jimBirthday.getMonth() == 10 && jimBirthday.getDay() == 15);
			assertNull(bb.getBirthday("Jeremy"));
			
			// add another entry into the birthday book
			bb.addBirthday("Suyeon", new Birthday(5, 21));
			assertEquals(5, bb.getSize());
			
			// remove an entry associated with the input name
			bb.removeBirthday("Alan");
			assertEquals(4, bb.getSize());
			assertNull(bb.getBirthday("Alan"));
			
			// get reminders of names of people whose birthdays are the given birthday
			String[] reminders1 = bb.reming(new Birthday(8, 11));
			String[] expectedReminders1 = {"Mark", "Tom"};
			assertArrayEquals(expectedReminders1, reminders1);
			
			String[] reminders2 = bb.reming(new Birthday(11, 13));
			String[] expectedReminders2 = {};
			assertArrayEquals(expectedReminders1, reminders1);
	}
	
	
	@Test
	public void test_02() {
			
			// Create an empty birthday book
			BirthdayBookV2 bb = new BirthdayBookV2();
			assertEquals(0, bb.getSize());
			
			// add four entries in the birthday book
			bb.addBirthday("Alan", new Birthday(5, 21));
			bb.addBirthday("Mark", new Birthday(8, 11));
			bb.addBirthday("Tom" , new Birthday(8, 11));
			bb.addBirthday("Jim" , new Birthday(10, 15));
			
			assertEquals(4, bb.getSize());
			// inquire about the birthdays
			Birthday jimBirthday = bb.getBirthday("Jim");
			assertTrue(jimBirthday.getMonth() == 10 && jimBirthday.getDay() == 15);
			assertNull(bb.getBirthday("Jeremy"));
			
			// add another entry into the birthday book
			bb.addBirthday("Suyeon", new Birthday(5, 21));
			assertEquals(5, bb.getSize());
			
			// remove an entry associated with the input name
			bb.removeBirthday("Alan");
			assertEquals(4, bb.getSize());
			assertNull(bb.getBirthday("Alan"));
			
			// get reminders of names of people whose birthdays are the given birthday
			String[] reminders1 = bb.reming(new Birthday(8, 11));
			String[] expectedReminders1 = {"Tom", "Mark"}; /* In the case of Hashtable, the order in which the String values are returned is unpredictable.*/
			assertArrayEquals(expectedReminders1, reminders1);
			
			String[] reminders2 = bb.reming(new Birthday(11, 13));
			String[] expectedReminders2 = {};
			assertArrayEquals(expectedReminders1, reminders1);
	}

}
