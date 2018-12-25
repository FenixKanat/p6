package p6;

import javax.swing.JOptionPane;

public class Controller {

	private Test2UI ui;
	private Array7x7 array;
//	private Viewer viewer;


	public Controller() {
		array = new Array7x7();
		ui = new Test2UI(this);
//		viewer = new Viewer();
	}
	
	
	public void readRow( int row ) {
//		ui.setRow(array.getRow(row));
	//	viewer.setRow(array.getRow(row));
	}
	public void readColumn ( int column) {
		ui.setColumn(array.getCol(column));
	//	viewer.setColumn(array.getCol(column));
	}
	public void writeRow (int row, Array7 arr7) {
		array.setRow(row, arr7);
		ui.setArray7x7(array);
	//	viewer.setArray7x7(array);
	}
	public void writeColumn ( int column, Array7 arr7) {
		array.setCol(column, arr7);
		ui.setArray7x7(array);
	//	viewer.setArray7x7(array);
	}
	
	public Array7x7 getArray() {
		return array;
	}
	
	public void updateColLeft() {
		for(int i = 0; i < 7; i++) {
			this.ui.colLeft[i].setText(this.ui.label[i][0].getText().trim());
		}
		
		// set temporary array
		int[] tmp = new int[7];
		Array7 tmpArr = new Array7();
		for(int i = 0; i < 7; i++) {
			tmp[i] = Integer.parseInt(this.ui.colRight[i].getText().trim());
		}
		tmpArr.setArray(tmp);
		// .....
		
		this.array.setCol(6, tmpArr);
		
		for(int i = 0; i < 7; i++) {
			// reset column after shifting?
			this.ui.colRight[i].setText("0");
		}
		
	}
	
	public void updateColRight() {
		for(int i = 0; i < 7; i++) {
			this.ui.colRight[i].setText(this.ui.label[i][6].getText().trim());
		}
		
		// set temporary array
		int[] tmp = new int[7];
		Array7 tmpArr = new Array7();
		for(int i = 0; i < 7; i++) {
			tmp[i] = Integer.parseInt(this.ui.colLeft[i].getText().trim());
		}
		tmpArr.setArray(tmp);
		// .....
		
		this.array.setCol(0, tmpArr);
		
		for(int i = 0; i < 7; i++) {
			// reset column after shifting?
			this.ui.colLeft[i].setText("0");
		}
		
	}
	
	public static void main(String[] args) {
		Controller c = new Controller();
	}
}