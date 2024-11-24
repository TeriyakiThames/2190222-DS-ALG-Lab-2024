import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestHeap {
	Heap h;
	
	@BeforeEach
	void setup() throws Exception {
		h = new Heap();
	}
	
	@Test
	void testOneNode() {
		h.add(5);
		h.replace(0, 2);
		
		assertEquals(1, h.size());
		assertEquals(2, h.mData[0]);
	}
	
	@Test
	void testNoFix1() {
		h.add(6);
		h.add(7);
		h.add(9);
		h.add(8);
		h.add(11);
		
		h.replace(0, 1);
		assertEquals(5, h.size());
		assertEquals(1, h.mData[0]);
		assertEquals(7, h.mData[1]);
		assertEquals(9, h.mData[2]);
		assertEquals(8, h.mData[3]);
		assertEquals(11, h.mData[4]);
	}
	
	@Test
	void testNoFix2() {
		h.add(6);
		h.add(7);
		h.add(9);
		h.add(11);
		h.add(10);
		
		h.replace(1, 8);
		assertEquals(5, h.size());
		assertEquals(6, h.mData[0]);
		assertEquals(8, h.mData[1]);
		assertEquals(9, h.mData[2]);
		assertEquals(11, h.mData[3]);
		assertEquals(10, h.mData[4]);
	}
	
	@Test
	void testWithFix1() {
		h.add(6);
		h.add(7);
		h.add(9);
		h.add(11);
		h.add(8);
		
		h.replace(0, 20);
		assertEquals(5, h.size());
		assertEquals(7, h.mData[0]);
		assertEquals(8, h.mData[1]);
		assertEquals(9, h.mData[2]);
		assertEquals(11, h.mData[3]);
		assertEquals(20, h.mData[4]);
	}
	
	@Test
	void testWithFix2() {
		h.add(6);
		h.add(7);
		h.add(9);
		h.add(10);
		h.add(11);
		h.add(40);
		h.add(41);
		h.add(30);
		
		h.replace(1, 25);
		assertEquals(8, h.size());
		assertEquals(6, h.mData[0]);
		assertEquals(10, h.mData[1]);
		assertEquals(9, h.mData[2]);
		assertEquals(25, h.mData[3]);
		assertEquals(11, h.mData[4]);
		assertEquals(40, h.mData[5]);
		assertEquals(41, h.mData[6]);
		assertEquals(30, h.mData[7]);
	}
	
	@Test
	void testWithFix3() {
		h.add(5);
		h.add(7);
		h.add(9);
		h.add(10);
		h.add(11);
		h.add(40);
		h.add(41);
		h.add(30);
		
		h.replace(7, 6);
		assertEquals(8, h.size());
		assertEquals(5, h.mData[0]);
		assertEquals(6, h.mData[1]);
		assertEquals(9, h.mData[2]);
		assertEquals(7, h.mData[3]);
		assertEquals(11, h.mData[4]);
		assertEquals(40, h.mData[5]);
		assertEquals(41, h.mData[6]);
		assertEquals(10, h.mData[7]);
	}
	
	
}
