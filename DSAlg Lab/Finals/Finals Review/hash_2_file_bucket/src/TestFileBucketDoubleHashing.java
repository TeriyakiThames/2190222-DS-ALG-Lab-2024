import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFileBucketDoubleHashing {
	FileBucketDoubleHashing h;
	
	@BeforeEach
	void setup() {
		h = new FileBucketDoubleHashing();
	}
	
	@Test
	void testEmpty() {
		assertEquals(0, h.currentSize);
		assertEquals(11, h.array.length);
		for (int i = 0; i < 11; i++) {
			assertEquals(null, h.array[i]);
		}
	
	}
	
	@Test
	void testSimple() {
		File file1 = new File(1, "AAA", "BBB", 20);
		File file2 = new File(19, "AAB", "BBB", 30);
		try {
			h.add(file1);
			h.add(file2);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		assertEquals(2, h.currentSize);
		assertEquals(11, h.array.length);
		for (int i = 0; i < 11; i++) {
			if (i == 1) {
				assertEquals(file1, h.array[i]);
			} else if (i == 8) {
				assertEquals(file2, h.array[i]);
			} else {
				assertEquals(null, h.array[i]);
			}
		}
	
	}
	
	@Test
	void testCollide() {
		File file1 = new File(1, "AAA", "BBB", 20);
		File file2 = new File(19, "AAB", "BBB", 30);
		File file3 = new File(12, "Collide", "GGG", 800);
		File file4 = new File(23, "Collide Again Bro", "Ajarn Toe", 7000);
		try {
			h.add(file1);
			h.add(file2);
			h.add(file3);
			h.add(file4);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		assertEquals(4, h.currentSize);
		assertEquals(11, h.array.length);
		for (int i = 0; i < 11; i++) {
			if (i == 1) {
				assertEquals(file1, h.array[i]);
			} else if (i == 3) {
				assertEquals(file3, h.array[i]);
			} else if (i == 4) {
				assertEquals(file4, h.array[i]);
			} else if (i == 8) {
				assertEquals(file2, h.array[i]);
			} else {
				assertEquals(null, h.array[i]);
			}
		}
	
	}
	
	@Test
	void testDelete() {
		File file1 = new File(1, "AAA", "BBB", 20);
		File file2 = new File(19, "AAB", "BBB", 30);
		File file3 = new File(12, "Collide", "GGG", 800);
		File file4 = new File(23, "Collide Again Bro", "Ajarn Toe", 7000);
		try {
			h.add(file1);
			h.add(file2);
			h.add(file3);
			h.add(file4);
			h.remove(1);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		assertEquals(3, h.currentSize);
		assertEquals(11, h.array.length);
		for (int i = 0; i < 11; i++) {
			if (i == 1) {
				assertEquals(h.DELETED, h.array[i]);
			} else if (i == 3) {
				assertEquals(file3, h.array[i]);
			} else if (i == 4) {
				assertEquals(file4, h.array[i]);
			} else if (i == 8) {
				assertEquals(file2, h.array[i]);
			} else {
				assertEquals(null, h.array[i]);
			}
		}
	
	}
	
	@Test
	void testRehash() {
		File[] files = new File[11];
		File fileA = new File(24, "AA", "BB", 1);
		
		for (int i = 0; i < 11; i++) {
			files[i] = new File(i, "ABC", "GGWP", 90);
		}
		
		try {
			for (int i = 0; i < 11; i++) {
				h.add(files[i]);
			}
			h.add(fileA);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		assertEquals(12, h.currentSize);
		assertEquals(23, h.array.length);
		
		for (int i = 0; i < 11; i++) {
			assertEquals(files[i], h.array[i]);
		}
		
		for (int i = 11; i < 23; i++) {
			if (i == 13) {
				assertEquals(fileA, h.array[i]);
			} else {
				assertEquals(null, h.array[i]);
			}
		}
	
		
	}
}
