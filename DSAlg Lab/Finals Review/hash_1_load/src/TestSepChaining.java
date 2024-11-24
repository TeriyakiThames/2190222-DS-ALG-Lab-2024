import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSepChaining {
	SepChaining s;
	
	@BeforeEach
	void setup() {
		s = new SepChaining();
	}
	
	@Test
	void testLoadFactorEmpty() {
		assertEquals(0.0, s.loadFactor());
	}
	
	@Test
	void testMaxLengthEmpty() {
		assertEquals(0,s.maxLength());
	}
	
	@Test
	void testLoadFactorBasic1() {
		try {
			s.add(2);
			s.add(5);
			s.add(6);
			s.add(10);
			
			assertEquals(0.8, s.loadFactor());
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	void testMaxLengthBasic1() {
		try {
			s.add(2);
			s.add(5);
			s.add(6);
			s.add(10);
			
			assertEquals(2, s.maxLength());
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	void testLoadFactorBasic2() {
		try {
			s.add(0);
			s.add(1);
			s.add(2);
			s.add(3);
			s.add(4);
			s.add(5);
			s.add(6);
			s.add(7);
			s.add(8);
			s.add(9);
			s.add(10);
			s.add(15);
			
			assertEquals(2.4, s.loadFactor());
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	void testMaxLengthBasic2() {
		try {
			s.add(0);
			s.add(1);
			s.add(2);
			s.add(3);
			s.add(4);
			s.add(5);
			s.add(6);
			s.add(7);
			s.add(8);
			s.add(9);
			s.add(10);
			s.add(15);
			
			assertEquals(4, s.maxLength());
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	void testLoadFactorRehash() {
		try {
			s.add(0);
			s.add(1);
			s.add(2);
			s.add(3);
			s.add(4);
			s.add(5);
			s.add(6);
			s.add(7);
			s.add(8);
			s.add(9);
			s.add(10);
			s.add(20);
			s.add(21);
			s.add(28);
			s.add(30);
			s.add(31);
			s.add(35);
			
			assertEquals(17.0/11.0, s.loadFactor());
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	void testMaxLengthRehash() {
		try {
			s.add(0);
			s.add(1);
			s.add(2);
			s.add(3);
			s.add(4);
			s.add(5);
			s.add(6);
			s.add(7);
			s.add(8);
			s.add(9);
			s.add(10);
			s.add(20);
			s.add(21);
			s.add(28);
			s.add(30);
			s.add(31);
			s.add(35);
			
			assertEquals(3, s.maxLength());
		} catch (Exception e) {
			assertTrue(false);
		}
	}
}
