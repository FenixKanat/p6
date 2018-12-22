package p6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Input extends JPanel implements ActionListener {
	
	private Controller controller = new Controller ();
	private JTextField rowNbr = new JTextField();
	private JTextField colNbr = new JTextField();
	private JTextField [] row = new JTextField [ 7 ];
	private JTextField [] col = new JTextField [ 7 ];
	private JLabel jlbCol = new JLabel("Column Nbr:");
	private JLabel jlbRow = new JLabel("Row Nbr:");

	private JButton btnReadCol = new JButton("Read Column");
	private JButton btnWriteCol =new JButton ("Write Column");

	private JButton btnReadRow = new JButton("Read Row");
	private JButton btnWriteRow =new JButton ("Write Row");

	Input() {
		
		setPreferredSize( new Dimension (370, 330));
		setLayout(null);
		
		jlbCol.setBounds(65, 5, 90, 30);
		jlbRow.setBounds(80, 150, 90, 30);
		
		colNbr.setBounds(150, 5, 50, 30);
		rowNbr.setBounds(150, 150, 50, 30);

		btnReadCol.setBounds(0, 50, 270, 35);
		btnReadRow.setBounds(0, 190, 270, 35);
		btnWriteCol.setBounds(0, 90, 270, 35);
		btnWriteRow.setBounds(0, 230, 270, 35);
		
		btnReadCol.addActionListener(this);
		btnReadRow.addActionListener(this);
		btnWriteCol.addActionListener(this);
		btnWriteRow.addActionListener(this);

		add(jlbCol);
		add (colNbr);
		add (btnReadCol);
		add (btnWriteCol);
		add(jlbRow);
		add (rowNbr);
		add (btnReadRow);
		add (btnWriteRow);	

		drawCol();
		drawRow();
	}
	public void drawRow() {
		int y= 0;
		for(int i = 0; i<row.length; i++) {
			row[i]= new JTextField("");
			row[i].setBounds(0+y, 285, 40, 40);
			row[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			add(row[i]);
			y+=40;
		}
	}
	public void drawCol() {
		int x = 0;
		for ( int i=0 ; i<col.length; i++) {
			col[i] = new JTextField("");
			col[i].setBounds(290, 0+x, 40, 40);
			col[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			add(col[i]);
			x+=40;
		}
	}
	public void actionPerformed(ActionEvent e) {
		Array7 arr = new Array7();
		int [] arr1 = new int [7];
		if (e.getSource() == btnReadCol){
			controller.readColumn(Integer.parseInt(colNbr.getText()));
		}
		else if (e.getSource() == btnReadRow) {
			controller.readRow(Integer.parseInt(rowNbr.getText()));
		}
		else if (e.getSource() == btnWriteCol) {
			for ( int i = 0 ; i < col.length ; i++) {
				arr1[i] = Integer.parseInt(col[i].getText());
			}
			arr.setArray(arr1);
			controller.writeColumn(Integer.parseInt(colNbr.getText()), arr);
			controller.updateColLeft();
			controller.updateColRight();
		}
		else if (e.getSource() == btnWriteRow) {

			for ( int i = 0 ; i < row.length ; i++) {
				arr1[i] = Integer.parseInt(row[i].getText());
			}
			arr.setArray(arr1);
			controller.writeRow(Integer.parseInt(rowNbr.getText()), arr);
			
		}
	}
}
