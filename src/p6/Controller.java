package p6;

import javax.swing.JOptionPane;

public class Controller {

	private Test2UI ui;
	private Array7x7 array;
	//private ui ui = new ui();

	public Controller() {
		array = new Array7x7();
		ui = new Test2UI(this);
	}
	
	
	public void readRow( int row ) {
//		ui.setRow(array.getRow(row));
	}
	public void readColumn ( int column) {
		ui.setColumn(array.getCol(column));
	}
	public void writeRow (int row, Array7 arr7) {
		array.setRow(row, arr7);
		ui.setArray7x7(array);
	}
	public void writeColumn ( int column, Array7 arr7) {
		array.setCol(column, arr7);
		ui.setArray7x7(array);
	}
	
	public Array7x7 getArray() {
		return array;
	}
	
	public void updateColLeft() {
		for(int i = 0; i < 7; i++) {
			this.ui.colLeft[i].setText(this.ui.label[i][0].getText());
		}
	}
	
	public void updateColRight() {
		for(int i = 0; i < 7; i++) {
			this.ui.colRight[i].setText(this.ui.label[i][6].getText());
		}
	}
	
	public static void main(String[] args) {
		Input in = new Input();		
		JOptionPane.showMessageDialog(null, in);
	}
}