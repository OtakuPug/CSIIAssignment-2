

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the ArrayBag class
 * from our text book. You will need to
 * write additional tests. Note that
 * several of these tests depend on specific
 * underlying implementation details of
 * the ArrayBag (certain tests would not
 * apply for other bag implementations).
 * 
 * @author Jacob Schrum
 * Last modified 5/28/18
 */
public class ArrayBagTest {

    private static final int ARRAYBAG_DEFAULT_CAPACITY = 25;

	public ArrayBag<Integer> bag;
	public ArrayBag<Integer> smallBag;
	public ArrayBag<Integer> emptyBag;
	public ArrayBag<String> stringBag;
	
	/**
	 * 1 point for adding to stringBag
	 * 
	 * Reinitialize bag contents before each test.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		bag = new ArrayBag<Integer>();
		bag.add(4);
		bag.add(2);
		bag.add(2);
		bag.add(4);
		bag.add(5);
		bag.add(100);
		bag.add(-30);
		bag.add(-10);
		bag.add(-10);
	
		
		emptyBag = new ArrayBag<Integer>();
		
		smallBag = new ArrayBag<Integer>(3);
		smallBag.add(4);
		smallBag.add(4);
		smallBag.add(400);
		
		

		//TODO: Add initialization for stringBag.
		//      Fill it with interesting data.
		
		stringBag = new ArrayBag<String>();
		stringBag.add("hello");
		stringBag.add("hello");
		stringBag.add("Computer Science");
		stringBag.add("words ");
		stringBag.add("!@#@#%^ ");
		stringBag.add("*(*(");
		stringBag.add("1+2+3+4.0");
		stringBag.add("worlds 0 !@ $$");
		stringBag.add("hello \r hi \n tab \t");
		stringBag.add("hello \r hi \n tab \t");
		stringBag.add("hello \r hi \n tab \t");
		
		
	}

	/**
	 * 1 point
	 */
	@Test
	public void testGetCurrentSize() {
		assertEquals(9, bag.getCurrentSize());
		assertEquals(0, emptyBag.getCurrentSize());
		assertEquals(3, smallBag.getCurrentSize());
		assertEquals(11, stringBag.getCurrentSize());
		// TODO: Test for smallBag
		// TODO: Test for stringBag
	}

	/**
	 * 1 point
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(emptyBag.isEmpty());
		assertFalse(bag.isEmpty());
		assertFalse(stringBag.isEmpty());
		assertFalse(smallBag.isEmpty());
		// TODO: Test for smallBag
		// TODO: Test for stringBag
	}

	/**
	 * 1 point
	 */
	@Test
	public void testAdd() {
		assertTrue(bag.add(77));
		assertTrue(bag.contains(77));
		assertFalse(smallBag.add(77));
		assertFalse(smallBag.contains(77));
		assertTrue(stringBag.add("5 gs ggggg"));
		assertTrue(stringBag.contains("5 gs ggggg"));
		// TODO: Test for smallBag
		// TODO: Test for stringBag

		// Fill bag to capacity: 25 is the private DEFAULT_CAPACITY in ArrayBag
		
		
		
		for(int i = 0; i < ARRAYBAG_DEFAULT_CAPACITY; i++) {
			assertTrue(emptyBag.add(9));
		}
		
		assertTrue(emptyBag.contains(9));
		// No more additions allowed
		assertFalse(emptyBag.add(9));
	}

	/**
	 * 4 points
	 */
	@Test
	public void testRemove() {
		assertEquals(new Integer(-10), bag.remove());
		assertEquals(new Integer(-10), bag.remove());
		assertEquals(new Integer(-30), bag.remove());
		assertEquals(new Integer(100), bag.remove());
		assertEquals(new Integer(5), bag.remove());
		assertEquals(new Integer(4), bag.remove());
		assertEquals(new Integer(2), bag.remove());
		assertEquals(new Integer(2), bag.remove());
		assertEquals(new Integer(4), bag.remove());
		assertEquals(null, bag.remove());
		assertEquals(null, emptyBag.remove());
		
		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
		assertEquals(new Integer(400), smallBag.remove());
		assertEquals(new Integer(4), smallBag.remove());
		assertEquals(new Integer(4), smallBag.remove());
		assertEquals(null, smallBag.remove());
		
		assertEquals(new String("hello \r hi \n tab \t"), stringBag.remove());
		assertEquals(new String("hello \r hi \n tab \t"), stringBag.remove());
		assertEquals(new String("hello \r hi \n tab \t"), stringBag.remove());
		assertEquals(new String("worlds 0 !@ $$"), stringBag.remove());
		assertEquals(new String("1+2+3+4.0"), stringBag.remove());
		assertEquals(new String("*(*("), stringBag.remove());
		assertEquals(new String("!@#@#%^ "), stringBag.remove());
		assertEquals(new String("words "), stringBag.remove());
		assertEquals(new String("Computer Science"), stringBag.remove());
		assertEquals(new String("hello"), stringBag.remove());
		assertEquals(new String("hello"), stringBag.remove());
		assertEquals(null, stringBag.remove());
	}

	/**
	 * 4 points
	 */
	@Test
	public void testRemoveT() {
		assertTrue(bag.remove(2));
		assertTrue(bag.remove(2));
		assertFalse(bag.remove(2));
		assertTrue(bag.remove(-10));
		assertTrue(bag.remove(-10));
		assertFalse(bag.remove(-10));
		assertTrue(bag.remove(-30));
		assertFalse(bag.remove(-30));
		assertFalse(bag.remove(34));
		assertTrue(bag.remove(100));
		assertFalse(bag.remove(100));
		assertTrue(bag.remove(5));
		assertFalse(bag.remove(5));
		assertTrue(bag.remove(4));
		assertTrue(bag.remove(4));
		assertFalse(bag.remove(4));
		assertFalse(bag.remove(345));

		assertFalse(emptyBag.remove(32));

		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
		assertTrue(smallBag.remove(4));
		assertFalse(smallBag.remove(99));
		assertTrue(smallBag.remove(4));
		assertFalse(smallBag.remove(-66));
		assertTrue(smallBag.remove(400));
		
		assertTrue(stringBag.remove("hello"));
		assertTrue(stringBag.remove("hello"));
		assertFalse(stringBag.remove("helo"));
		assertTrue(stringBag.remove("Computer Science"));
		assertFalse(stringBag.remove("CompSci"));
		assertTrue(stringBag.remove("words "));
		assertTrue(stringBag.remove("!@#@#%^ "));
		assertFalse(stringBag.remove("OwO"));
		assertTrue(stringBag.remove("*(*("));
		assertTrue(stringBag.remove("1+2+3+4.0"));
		assertTrue(stringBag.remove("worlds 0 !@ $$"));
		assertFalse(stringBag.remove("-66-100+50"));
		assertTrue(stringBag.remove("hello \r hi \n tab \t"));
		assertTrue(stringBag.remove("hello \r hi \n tab \t"));
		assertTrue(stringBag.remove("hello \r hi \n tab \t"));
		
	}

	/**
	 * 1 point
	 */
	@Test
	public void testClear() {
		assertFalse(bag.isEmpty());
		bag.clear();
		assertTrue(bag.isEmpty());
	
		assertTrue(emptyBag.isEmpty());
		emptyBag.clear();
		assertTrue(emptyBag.isEmpty());
		
		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
		assertFalse(stringBag.isEmpty());
		stringBag.clear();
		assertTrue(stringBag.isEmpty());
		
		assertFalse(smallBag.isEmpty());
		smallBag.clear();
		assertTrue(smallBag.isEmpty());
	}

	/**
	 * 4 points
	 */
	@Test
	public void testGetFrequencyOf() {
		assertEquals(2, bag.getFrequencyOf(-10));
		assertEquals(2, bag.getFrequencyOf(2));
		assertEquals(1, bag.getFrequencyOf(100));
		assertEquals(1, bag.getFrequencyOf(-30));
		assertEquals(1, bag.getFrequencyOf(5));
		assertEquals(2, bag.getFrequencyOf(4));
		assertEquals(0, bag.getFrequencyOf(534));
		
		assertEquals(0, emptyBag.getFrequencyOf(4));
		
		assertEquals(2, smallBag.getFrequencyOf(4));
		assertEquals(0, emptyBag.getFrequencyOf(2000));
		assertEquals(0, emptyBag.getFrequencyOf(-4));
		
		assertEquals(2, stringBag.getFrequencyOf("hello"));
		assertEquals(1, stringBag.getFrequencyOf("worlds 0 !@ $$"));
		assertEquals(3, stringBag.getFrequencyOf("hello \r hi \n tab \t"));
		
		
		

		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
	}

	/**
	 * 4 points
	 */
	@Test
	public void testContains() {
		assertTrue(bag.contains(-10));
		assertTrue(bag.contains(2));
		assertTrue(bag.contains(100));
		assertTrue(bag.contains(-30));
		assertTrue(bag.contains(5));
		assertTrue(bag.contains(4));
		assertFalse(bag.contains(46));
		assertFalse(bag.contains(4345));

		assertFalse(emptyBag.contains(46));
		
		assertFalse(smallBag.contains(-69696));
		assertFalse(smallBag.contains(1));
		assertFalse(smallBag.contains(1111));
		assertFalse(smallBag.contains(-302));
		assertFalse(smallBag.contains(544));
		assertTrue(smallBag.contains(4));
		assertFalse(smallBag.contains(44));
		assertFalse(smallBag.contains(-409));
		assertTrue(smallBag.contains(4));
		
		
		assertFalse(stringBag.contains("b5^ 7 ))\t \\y)"));
		assertFalse(stringBag.contains("re7ev4nt * re4l7ty"));
		assertTrue(stringBag.contains("!@#@#%^ "));
		assertFalse(stringBag.contains("Computer Scienc3"));
		assertFalse(stringBag.contains("asset"));
		assertTrue(stringBag.contains("hello \r hi \n tab \t"));
		assertFalse(stringBag.contains("hello \r hii \n tab \t"));
		assertFalse(stringBag.contains("\t\t\r\t\n"));
		assertTrue(stringBag.contains("1+2+3+4.0"));

		
		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
	}

	/**
	 * 4 points
	 */
	@Test
	public void testToArray() {		
		Object[] result1 = bag.toArray();
		assertArrayEquals(new Integer[] {4,2,2,4,5,100,-30,-10,-10}, result1);

		Object[] result2 = emptyBag.toArray();
		assertArrayEquals(new Integer[0], result2);
		
		Object[] result3 = smallBag.toArray();
		assertArrayEquals(new Integer[] {4,4,400}, result3);
		
		Object[] result4 = stringBag.toArray();
		assertArrayEquals(new String[] {"hello","hello","Computer Science","words ","!@#@#%^ ","*(*(","1+2+3+4.0","worlds 0 !@ $$","hello \r hi \n tab \t","hello \r hi \n tab \t","hello \r hi \n tab \t"}, result4);
	
		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
	
		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
		
	}

}
