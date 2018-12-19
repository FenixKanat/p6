
public class Controller {
	
	private Array7x7 array = new Array7x7();
	private Viewer viewer = new Viewer();

	public Controller() {
		Array7x7 a = new Array7x7();
		viewer.setArray7x7(a.getArray());
	}
	
	public void readRow( int row ) {	
		viewer.setRow(array.getRow(row));
	}
	public void readColumn ( int column) {
		viewer.setColumn(array.getCol(column));
	}
	public void writeRow (int row, Array7 arr7) {
		array.setRow(row, arr7);
		viewer.setArray7x7(array);
	}
	public void writeColumn ( int column, Array7 arr7) {
		array.setCol(column, arr7);
		viewer.setArray7x7(array);
	}
}
