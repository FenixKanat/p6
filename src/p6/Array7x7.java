package p6;

public class Array7x7 {
	
	private int[][] elements;
	
	public Array7x7() {
		elements = new int[7][7];
	}
	
	
	public void setElement(int row, int col, int value) {
		this.elements[row][col] = value;
	}
	
	public int getElement(int row, int col) {
		return this.elements[row][col];
	}
	
	public void setRow(int row, Array7 theRow) {
		this.elements[row] = theRow.toIntArray(); 
	}
	
	public Array7 getRow(int row) {
		return new Array7(this.elements[row]);
	}
	
	public void setCol(int col, Array7 theCol) {
		for(int i = 0; i < theCol.toIntArray().length; i++) {
			this.elements[col][i] = theCol.getElement(i);
		}
	}
	
	public Array7 getCol(int col) {
		Array7 arr = new Array7();
		for(int i = 0; i < this.elements[0].length; i++) {
			arr.setElement(this.elements[col][i], i);
		}
		return arr;
	}
	
	public void setArray(Array7x7 array7x7) {
		this.elements = array7x7.toIntArray();
	}
	public void setArray(int[][] array) {
		this.elements = array;
	}
	
	public Array7x7 getArray() {
		return this;
	}
	
	public int[][] toIntArray(){
		return this.elements;
	}
	
}
