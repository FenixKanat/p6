package p6;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Viewer extends JPanel{
	private Font fontlbl = new Font("SanSerif", Font.PLAIN, 12); 
	private GridLayout gl = new GridLayout(7, 7, 0, 0);
	private GridLayout colGl = new GridLayout (7, 0);
	private GridLayout rowGl = new GridLayout (0, 7);

	JFrame frame = new JFrame("Array 7x7 viewer");
	JPanel mainPanel = new JPanel();
	JPanel colPanel = new JPanel();
	JPanel rowPanel = new JPanel ();

	JLabel label[][] = new JLabel[7][7];
	JLabel colLabel[] = new JLabel[7];
	JLabel rowLabel[] = new JLabel[7];
	Array7x7 a7x7 = new Array7x7();

	/*
	 * Skapar ruta för array7x7 och paneler för kolumner och rader
	 */
	public Viewer() {
		mainPanel.setBackground(Color.LIGHT_GRAY);
		colPanel.setBackground(Color.LIGHT_GRAY);
		rowPanel.setBackground(Color.LIGHT_GRAY);
				
		frame.add(mainPanel, BorderLayout.CENTER);	
		frame.add(rowPanel, BorderLayout.SOUTH);
		frame.add(colPanel, BorderLayout.WEST);
		
		frame.setSize(350, 350);
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		mainPanel.setLayout(gl);
		colPanel.setLayout(colGl);
		rowPanel.setLayout(rowGl);
		
		rowPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5,30,5,0), null));
		colPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0,5,0,5), null));

		drawMainPanel();
		drawColPanel();
		drawRowPanel();
	}

	/*
	 * Skapar JLablar via en for-loop och ritar upp de i stora panelen
	 */
	public void drawMainPanel() {
		for(int i=0; i<label.length; i++) {
			for(int j=0; j<label[i].length ; j++) {
				label[i][j] = new JLabel("0");
				label[i][j].setFont(fontlbl);
				label[i][j].setPreferredSize(new Dimension(10,10));
				label[i][j].setOpaque(true);
				label[i][j].setBackground(Color.WHITE);
				mainPanel.add(label[i][j]);
				label[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		}		
	}
	
	/*
	 * Skapar JLablar via for-loop och ritar upp de i kolumn panelen
	 */
	public void drawColPanel() {
		for ( int i=0 ; i<colLabel.length; i++) {
			colLabel[i] = new JLabel();
			colLabel[i].setPreferredSize(new Dimension(20,20));
			colLabel[i].setOpaque(true);
			colLabel[i].setBackground(Color.WHITE);
			colPanel.add(colLabel[i]);
			colLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	/*
	 * Skapar JLablar via for-loop och ritar upp de i rad panelen
	 */
	public void drawRowPanel() {
		for ( int i=0 ; i<rowLabel.length; i++) {
			rowLabel[i] = new JLabel();
			rowLabel[i].setPreferredSize(new Dimension(20,20));
			rowLabel[i].setOpaque(true);
			rowLabel[i].setBackground(Color.WHITE);
			rowPanel.add(rowLabel[i]);
			rowLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	
	/*
	 * Ändrar texten i JLablarna som visas i radpanelen med for-loop
	 */
	public void setRow(Array7 arr7) {
		for ( int i=0 ; i<rowLabel.length; i++) {
			rowLabel[i].setText("" + arr7.getElement(i));
		}
	}
	/*
	 * Ändrar texten i JLablarna som visas i kolumnpanelen med for-loop
	 */
	public void setColumn(Array7 arr7) {
		for(int i=0 ; i<colLabel.length; i++) {	
			colLabel[i].setText("" + arr7.getElement(i));
		}
	}
	/*
	 * Ändrar texten i JLablarna som visas i stora panelen med for-loop
	 */
	public void setArray7x7(Array7x7 array) {
		for(int i=0 ; i<label.length ; i++) {
			for(int j=0 ; j<label[i].length ; j++) {
				label[i][j].setText("" + array.getElement(i, j));
			}
		}
	}
}
