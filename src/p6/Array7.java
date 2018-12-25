package p6;

public class Array7 {

	private int[] elements;
	
	public Array7() {
		// give this.element an array with 7 0s
		this.elements = new int[7];
	}
	
	/** 
	 	@param array - an array including 7 elements.<br>
	 */
	public Array7(int[] array) {
		setArray(array);
	}
	
	/**
	 	Create an array using given Array7 object.
	 	
	 	@param array - an Array7 object whose elements will be used.
	 */
	public Array7(Array7 array) {
		setArray(array);
	}
	
	/**
	 
	 	@param pos - array element position
	 	@param value - what value should be used at given position in array
	  
	 **/
	public void setElement(int pos, int value) {
		this.elements[pos] = value;
	}
	
	/**
	 	replace current <code>array</code> with given new <code>array</code>
 		@param array - a collection of elements.<br> E.g: new int[]{ 1,2,3,4,5,6,7 }
	 */
	public void setArray(int[] array) {
		
		this.elements = array;
	}
	
	/**
		@param array - An Array7 object whose elements will be used
	 */
	public void setArray(Array7 array) {
		
		// Replace elements from given Array7 Object with the elements of Current Objects.
		for(int i = 0; i < array.elements.length; i++) 
		{
			this.elements[i] = array.elements[i];
		}
	}
	
	/**
	 	@returns Array7 object
	 **/
	public Array7 getArray() {
		return new Array7(this.elements);
	}
	
	
	/**
	  	@returns Array7 object as int[]
	 **/
	public int[] toIntArray() {
		return this.elements;
	}
	
	
	/**
	  	@param pos - position of an element
	 **/
	public int getElement(int pos) {
		return this.elements[pos];
	}
}
