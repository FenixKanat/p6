package p6;

public class Array7x7 {

	private int[][] elements;

	/**
		Array7x7 constructor defines a 2D, 7x7 array (by default).
	**/
	public Array7x7() {
		elements = new int[7][7];
	}

	/**
		Takes the value of given <code>value</code> and sets it to given position in array

		@param row - Array row
		@param col - Array column
	**/
	public void setElement(int row, int col, int value) {
		this.elements[row][col] = value;
	}

	/**

		@return - specific element at given position (<code>row</code>,<code>column</code>)
		@param row - takes a row index
		@param col - takes a col index
	**/
	public int getElement(int row, int col) {
		return this.elements[row][col];
	}

	/**
		Exchanges a row in current array with a given array at a specific position (<code>row</code>)
		@param row - array position which will be modified
		@param theRow - an array which will replace the current row
	**/
	public void setRow(int row, Array7 theRow) {
		this.elements[row] = theRow.toIntArray();
	}

	/**
		@return row at specific position from Array7x7
		@param row takes the position of a row which will be returned
	**/
	public Array7 getRow(int row) {
		return new Array7(this.elements[row]);
	}

	/**
		Modifies column(s) in Array7x7
		@param col takes a column index
	**/
	public void setCol(int col, Array7 theCol) {
		for(int i = 0; i < theCol.toIntArray().length; i++) {
			this.elements[col][i] = theCol.getElement(i);
		}
	}

	/**
		@return returns a column in array7x7
	**/
	public Array7 getCol(int col) {
		Array7 arr = new Array7();
		for(int i = 0; i < this.elements[0].length; i++) {
			arr.setElement(this.elements[col][i], i);
		}
		return arr;
	}

	/**
		sets given 2D array to the current array
		@param array7x7 takes a 2 dimensional 7x7 array
	**/
	public void setArray(Array7x7 array7x7) {
		this.elements = array7x7.toIntArray();
	}

	/**
		takes a 2D int array and modifies current array
		@param array - takes an int[][]
	**/
	public void setArray(int[][] array) {
		this.elements = array;
	}

	/**
		@return a copy of itself
	**/
	public Array7x7 getArray() {
		return this;
	}

	/**
		@return the original 2D int[][] (int array)
	**/
	public int[][] toIntArray(){
		return this.elements;
	}

}
