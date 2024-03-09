package telran.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import telran.arrays.*;

class ArrayCharTest {

	@Test
	@DisplayName("compareTo(ArrayChar)")
	void compareToTest() {
		
		char[] ar1 = new char[] {'1', '2', '3'};
		char[] ar2 = {'9'};
		char[] ar3 = {'1', '2', '3'};
	
		ArrayChar arrayChar1 = new ArrayChar(ar1);
		ArrayChar arrayChar2 = new ArrayChar(ar2);
		ArrayChar arrayChar3 = new ArrayChar(ar3);
		ArrayChar arrayChar4 = new ArrayChar( new char[] {});
		
		assertEquals(3, arrayChar3.compareTo(arrayChar4));
		assertEquals(-3, arrayChar4.compareTo(arrayChar3));
		
		assertEquals(8, arrayChar2.compareTo(arrayChar1));
		assertEquals(-8, arrayChar1.compareTo(arrayChar2));
		assertEquals(1, new ArrayChar( new char[] {'a', 'a'}).
				compareTo(new ArrayChar(new char[] {'a'})));
		assertEquals(-1, new ArrayChar( new char[] {'a'}).
				compareTo(new ArrayChar(new char[] {'a', 'a'})));
		assertEquals(0, new ArrayChar( new char[] {}).
				compareTo(new ArrayChar(new char[] {})));
		assertEquals(1, new ArrayChar( new char[] {'a'}).
				compareTo(new ArrayChar(new char[] {})));
		assertEquals(-1, new ArrayChar( new char[] {}).
				compareTo(new ArrayChar(new char[] {'s'})));
		assertEquals(0, arrayChar1.compareTo(arrayChar3));
	}
	@Test
	@DisplayName("indexOf(char)")
	void indexOfTest() {
		char[] ar1 = new char[] {'1', '2', '3', '2'};
		ArrayChar arrayChar1 = new ArrayChar(ar1);
		assertEquals(1, arrayChar1.indexOf('2'));
		assertEquals(-1, arrayChar1.indexOf('0'));
		assertEquals(-1, new ArrayChar( new char[] {}).indexOf('d'));
	}
	@Test
	@DisplayName("lastIndexOf(char)")
	void lastIndexOfTest() {
		char[] ar1 = new char[] {'1', '2', '3', '2'};
		ArrayChar arrayChar1 = new ArrayChar(ar1);
		assertEquals(3, arrayChar1.lastIndexOf('2'));
		assertEquals(-1, arrayChar1.lastIndexOf('0'));
	}
	
	/* Home Work 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	@Test
	@DisplayName("compareToIgnoreCase(ArrayChar)")
	void compareToIgnoreCaseTest() {
		//comparing two identical objects
		assertEquals( 0, 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h', 'e', 'r'})
					.compareToIgnoreCase 
			   (new ArrayChar( new char[] {'a', 'a', 'G', 'g', 'H', 'e', 'r'})));
		
		//now on index 4 there is a difference (positive)
		assertEquals( 3, 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h', 'e', 'r'})
					.compareToIgnoreCase 
			   (new ArrayChar( new char[] {'a', 'a', 'G', 'g', 'e', 'e', 'r'})));
		
		//adding negative difference on index 1
		assertEquals( -2, 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h', 'e', 'r'})
					.compareToIgnoreCase 
						(new ArrayChar( new char[] {'a', 'c', 'G', 'g', 'e', 'e', 'r'})));
		
		//checking two cases where the length is a matter
		assertEquals( -2, 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h'})
					.compareToIgnoreCase 
						(new ArrayChar( new char[] {'a', 'a', 'G', 'g', 'H', 'e', 'r'})));
		
		assertEquals( 1, 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h'})
					.compareToIgnoreCase 
						(new ArrayChar( new char[] {'a', 'a', 'G', 'g'})));
		
		//checking empty arrays	
		assertEquals( -4, 
				new ArrayChar( new char[] {})
					.compareToIgnoreCase 
						(new ArrayChar( new char[] {'a', 'a', 'G', 'g'})));
		assertEquals( 5, 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h'})
					.compareToIgnoreCase 
						(new ArrayChar( new char[] {})));
		assertEquals( 0, 
				new ArrayChar( new char[] {})
					.compareToIgnoreCase 
						(new ArrayChar( new char[] {})));
	}
	
	@Test
	@DisplayName("count(char)")
	void countTest() {
		ArrayChar arrayCharToSearch = new ArrayChar( new char[] {'h', 'A', 'g', 'G', 'h', 't', 'h'}); 
		ArrayChar emptyArray = new ArrayChar( new char[] {});
		
		//find one occurrence
		assertEquals( 1, arrayCharToSearch.count('A')) ;
		
		//find three occurrences
		assertEquals( 3, arrayCharToSearch.count('h')) ;
		
		//no occurrence
		assertEquals( 0, arrayCharToSearch.count('a')) ;
		
		//empty array check
		assertEquals(0, emptyArray.count((char) 0));
	}
	@Test
	@DisplayName("contains(char)")
	void containsTest() {
		ArrayChar arrayCharToSearch = new ArrayChar( new char[] {'T', 'A', 'g', 'G', 'h', 't', 'h'}); 
		ArrayChar emptyArray = new ArrayChar( new char[] {});
		
		//contains
		assertTrue(arrayCharToSearch.contains('A')) ;
		assertTrue(arrayCharToSearch.contains('h')) ;
		
		//does not contains
		assertFalse(arrayCharToSearch.contains('a'));
		
		//empty array check
		assertFalse( emptyArray.contains('!'));
	}
	
	@Test
	@DisplayName("equals(ArrayChar)")
	void equalsTest() {
		
		//comparing two identical objects
		assertTrue( 
				new ArrayChar( new char[] {'a', 'A', 'I', 'G', 'h', 'e', 'r'})
					.equals 
			   (new ArrayChar( new char[] {'a', 'A', 'I', 'G', 'h', 'e', 'r'})));
		
		//changing length
		assertFalse( 
				new ArrayChar( new char[] {'a', 'A', 'I', 'G', 'h', 'e', 'r', 'r'})
					.equals 
			   (new ArrayChar( new char[] {'a', 'A', 'I', 'G', 'h', 'e', 'r'})));
		assertFalse( 
				new ArrayChar( new char[] {'a', 'A', 'I', 'G', 'h', 'e', 'r'})
					.equals 
			   (new ArrayChar( new char[] {'a', 'A', 'I', 'G', 'h', 'e'})));
		
		//changing I to i
		assertFalse( 
				new ArrayChar( new char[] {'a', 'A', 'i', 'G', 'h', 'e', 'r'})
					.equals 
			   (new ArrayChar( new char[] {'a', 'A', 'I', 'G', 'h', 'e', 'r'})));
		
		//check null method argument
		assertFalse( 
				new ArrayChar( new char[] {'a', 'A', 'i', 'G', 'h', 'e', 'r'}).equals(null) );
	}
	
	@Test
	@DisplayName("equalsIgnoreCase(ArrayChar)")
	void equalsIgnoreCaseTest() {
		
		//comparing two identical objects
		assertTrue( 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h', 'e', 'r'})
					.equalsIgnoreCase 
			   (new ArrayChar( new char[] {'a', 'a', 'G', 'g', 'H', 'e', 'r'})));
		
		//changing length
		assertFalse( 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h', 'e', 'r', 'r'})
					.equalsIgnoreCase 
			   (new ArrayChar( new char[] {'a', 'a', 'G', 'g', 'H', 'e', 'r'})));
		assertFalse( 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h', 'e', 'r'})
					.equalsIgnoreCase 
			   (new ArrayChar( new char[] {'a', 'a', 'G', 'g', 'H'})));
		
		//only one character difference
		assertFalse( 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h', 'e', 'r'})
					.equalsIgnoreCase 
			   (new ArrayChar( new char[] {'a', 'a', 'G', 'g', 'H', 'e', 'w'})));
		
		//check null method argument
		assertFalse( 
				new ArrayChar( new char[] {'a', 'A', 'g', 'G', 'h', 'e', 'r'})
					.equalsIgnoreCase (null) );
	}
}
