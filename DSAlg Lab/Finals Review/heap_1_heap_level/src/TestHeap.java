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
	void testEmpty() {
		int[] ans;
		
		ans = h.atLevel(0);
		assertEquals(0, ans.length);
		ans = h.atLevel(1);
		assertEquals(0, ans.length);
		ans = h.atLevel(2);
		assertEquals(0, ans.length);
		ans = h.atLevel(3);
		assertEquals(0, ans.length);
		ans = h.atLevel(4);
		assertEquals(0, ans.length);
		ans = h.atLevel(5);
		assertEquals(0, ans.length);
		ans = h.atLevel(6);
		assertEquals(0, ans.length);
		ans = h.atLevel(7);
		assertEquals(0, ans.length);
		ans = h.atLevel(10);
		assertEquals(0, ans.length);
		ans = h.atLevel(20);
		assertEquals(0, ans.length);
		ans = h.atLevel(100);
		assertEquals(0, ans.length);
	}
	
	@Test
	void testSimple1() {
		h.add(1);
		h.add(2);
		
		int[] ans;
		
		ans = h.atLevel(0);
		assertEquals(1, ans.length);
		assertEquals(1, ans[0]);
		
		ans = h.atLevel(1);
		assertEquals(1, ans.length);
		assertEquals(2, ans[0]);
		
		ans = h.atLevel(2);
		assertEquals(0, ans.length);
		ans = h.atLevel(3);
		assertEquals(0, ans.length);
		ans = h.atLevel(4);
		assertEquals(0, ans.length);
		ans = h.atLevel(5);
		assertEquals(0, ans.length);
		ans = h.atLevel(6);
		assertEquals(0, ans.length);
		ans = h.atLevel(7);
		assertEquals(0, ans.length);
		ans = h.atLevel(10);
		assertEquals(0, ans.length);
		ans = h.atLevel(20);
		assertEquals(0, ans.length);
		ans = h.atLevel(100);
		assertEquals(0, ans.length);
	}
	
	@Test
	void testSimple2() {
		h.add(4);
		h.add(7);
		h.add(9);
		h.add(5);
		h.add(8);
		
		int[] ans;
		
		ans = h.atLevel(0);
		assertEquals(1, ans.length);
		assertEquals(4, ans[0]);
		
		ans = h.atLevel(1);
		assertEquals(2, ans.length);
		assertEquals(5, ans[0]);
		assertEquals(9, ans[1]);
		
		ans = h.atLevel(2);
		assertEquals(2, ans.length);
		assertEquals(7, ans[0]);
		assertEquals(8, ans[1]);
		
		ans = h.atLevel(3);
		assertEquals(0, ans.length);
		ans = h.atLevel(4);
		assertEquals(0, ans.length);
		ans = h.atLevel(5);
		assertEquals(0, ans.length);
		ans = h.atLevel(6);
		assertEquals(0, ans.length);
		ans = h.atLevel(7);
		assertEquals(0, ans.length);
		ans = h.atLevel(10);
		assertEquals(0, ans.length);
		ans = h.atLevel(20);
		assertEquals(0, ans.length);
		ans = h.atLevel(100);
		assertEquals(0, ans.length);
	}
	
	@Test
	void testComplex() {
		h.add(1);
		h.add(9);
		h.add(8);
		h.add(7);
		h.add(10);
		h.add(0);
		h.add(-5);
		h.add(15);
		h.add(-1);
		h.add(11);
		h.add(2);
		h.add(-2);
		
		int[] ans;
		
		ans = h.atLevel(0);
		assertEquals(1, ans.length);
		assertEquals(-5, ans[0]);
		
		ans = h.atLevel(1);
		assertEquals(2, ans.length);
		assertEquals(-1, ans[0]);
		assertEquals(-2, ans[1]);
		
		ans = h.atLevel(2);
		assertEquals(4, ans.length);
		assertEquals(7, ans[0]);
		assertEquals(2, ans[1]);
		assertEquals(0, ans[2]);
		assertEquals(1, ans[3]);
		
		ans = h.atLevel(3);
		assertEquals(5, ans.length);
		assertEquals(15, ans[0]);
		assertEquals(9, ans[1]);
		assertEquals(11, ans[2]);
		assertEquals(10, ans[3]);
		assertEquals(8, ans[4]);
		
		ans = h.atLevel(4);
		assertEquals(0, ans.length);
		ans = h.atLevel(5);
		assertEquals(0, ans.length);
		ans = h.atLevel(6);
		assertEquals(0, ans.length);
		ans = h.atLevel(7);
		assertEquals(0, ans.length);
		ans = h.atLevel(10);
		assertEquals(0, ans.length);
		ans = h.atLevel(20);
		assertEquals(0, ans.length);
		ans = h.atLevel(75);
		assertEquals(0, ans.length);
		ans = h.atLevel(100);
		assertEquals(0, ans.length);
	}
}
