package telran.arrays;
import static java.lang.Character.*;

public class ArrayChar {
	
	private char[] array;
	
	public ArrayChar (char[] array) {
		this.array = array;
	}
	
	public int compareTo( ArrayChar another) {
		int length = Math.min(array.length, another.array.length);
		int index = 0;
		while( index < length && array[ index ] == another.array[ index ] ) {
			index++;
		}
		return  index == length ? this.array.length - another.array.length : this.array[index] - another.array[index];
	}
	
	public int indexOf(char character ) {
		int index = 0;
		while( index < array.length && array[ index ] != character) {
			index++;
		}
		return  index == array.length ? -1 : index;
	}
	
	public int lastIndexOf(char character ) {
		int index = array.length - 1;
		while( index > -1 && array[ index ] != character) {
			index--;
		}
		return index;
	}
	
	public int compareToIgnoreCase( ArrayChar another) {
		int length = Math.min(array.length, another.array.length);
		int index = 0;
		int diff = 0;
		while( index < length && 
				( diff = toLowerCase(array[index]) - toLowerCase(another.array[ index ])) == 0 ) {
			index++;
		}
		return  index == length ? this.array.length - another.array.length : diff;
	}
	
	public int count(char character ) {
		int appearCount = 0;
		for ( int i = 0; i < array.length; i++ )
			if ( array[ i ] == character )
				appearCount++;
		return appearCount;
	}
	
	public boolean contains( char character) {
		int length = array.length;
		int index = 0;
		while( index < length && array[ index ] != character ) {
			index++;
		}
		return  index == length ? false : true;
	}
	
	public boolean equals( ArrayChar another ) {
		return another == null ? false : this.compareTo(another) == 0 ? true : false;
	}
	
	public boolean equalsIgnoreCase( ArrayChar another) {
		return another == null ? false : this.compareToIgnoreCase(another) == 0 ? true : false;
	}

}
