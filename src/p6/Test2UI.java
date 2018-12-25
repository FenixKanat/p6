package p6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Test2UI extends JPanel {
	private Font fontlbl; 
	private GridLayout gl;
	private GridLayout co;

	private JLabel [] col;
	
	//public JLabel[] colLeft;
	//public JLabel[] colRight;
	public JTextField[] colLeft;
	public JTextField[] colRight;
	
	public JLabel[][] label;
	
	private JFrame window;
	private JPanel mainPanel;
	private JPanel colPanelRight;
	private JPanel colPanelLeft;
	private JPanel panelU;
	private JButton clickleft;
	private JButton clickright;
	private Controller controller;
		
	
	public void updateLabels() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				this.label[i][j].setText(" "+this.controller.getArray().getElement(i, j));
			}	
		}
	}
	

	
	public Test2UI(Controller c) {
		controller = c;
		fontlbl = new Font("SanSerif", Font.PLAIN, 12); 
		gl = new GridLayout(7, 7, 0, 0);
		co = new GridLayout (7, 0);
		 
		label = new JLabel[7][7];
		col = new JLabel[7];
		
		colLeft = new JTextField[7];
		colRight = new JTextField[7];
		
		
		window = new JFrame("Test 2");
		mainPanel = new JPanel();
		colPanelRight = new JPanel();
		colPanelLeft = new JPanel();
		panelU = new JPanel();
		clickleft = new JButton("  <- Move left <-  ");
		clickright = new JButton("-> Move right ->");
		
    	panelU.setBackground(Color.WHITE);
    	panelU.add(clickleft);
    	panelU.add(clickright);
    	
    	mainPanel.setBackground(Color.LIGHT_GRAY);
    	colPanelRight.setBackground(Color.LIGHT_GRAY);
    	colPanelLeft.setBackground(Color.LIGHT_GRAY);
    	
    	window.add(panelU, BorderLayout.SOUTH);
    	window.add(colPanelLeft, BorderLayout.WEST);
    	window.add(mainPanel, BorderLayout.CENTER);
    	window.add(colPanelRight, BorderLayout.EAST);
    	window.setSize(400, 400);
		window.setBackground(Color.WHITE);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		mainPanel.setLayout(gl);
		colPanelRight.setLayout(co);
		colPanelLeft.setLayout(co);
		colPanelRight.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0,5,0,5), null));
		colPanelLeft.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0,5,0,5), null));
		
		mainPanel();
		colPanelL();
		colPanelR();
		
		clickleft.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		    	controller.getArray().shiftLeft();
		    	controller.updateColLeft();
		    	updateLabels();
		    	//controller.updateColRight();
		    }
		});
		
		clickright.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	controller.getArray().shiftRight();
		    
		    	controller.updateColRight();
		    	updateLabels();
		    }
		});
		
		for(int i = 0; i < 7; i++) {
			System.out.print(Integer.parseInt(colLeft[i].getText()));
		}
    	
	}
	public void mainPanel() {
		for(int i=0; i < this.label.length; i++) {
			for(int j=0; j < this.label[i].length; j++) {
				this.label[i][j] = new JLabel("0");
				this.label[i][j].setFont(fontlbl);
				this.label[i][j].setPreferredSize(new Dimension(5,5));
				this.label[i][j].setOpaque(true);
				this.label[i][j].setBackground(Color.WHITE);
				this.label[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				this.label[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				
				mainPanel.add(this.label[i][j]);
			}
		}		
	}
	public void colPanelL() {
		for(int i = 0; i < this.colLeft.length; i++) {
			this.colLeft[i] = new JTextField("0");
			this.colLeft[i].setPreferredSize(new Dimension(30,30));
			this.colLeft[i].setOpaque(true);
			this.colLeft[i].setBackground(Color.WHITE);
			this.colLeft[i].setHorizontalAlignment(SwingConstants.CENTER);
			this.colLeft[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			this.colPanelLeft.add(this.colLeft[i]);
		}
		System.out.println("created L");
	}
	public void colPanelR() {
		for(int i = 0; i < this.colRight.length; i++) {
			this.colRight[i]= new JTextField("0");
			this.colRight[i].setPreferredSize(new Dimension(30,30));
			this.colRight[i].setOpaque(true);
			this.colRight[i].setBackground(Color.WHITE);
			this.colRight[i].setHorizontalAlignment(SwingConstants.CENTER);
			this.colRight[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			this.colPanelRight.add(this.colRight[i]);	
		}
		System.out.println("created R");
	}

	public void setColumn(Array7 arr7) {
		for(int i=0; i < this.col.length; i++) {	
			this.col[i].setText(""+arr7.getElement(i));
		}
	}

	public void setArray7x7(Array7x7 array) {
		for(int i=0; i < this.label.length; i++) {
			for(int j=0; j < this.label.length; j++) {
				this.label[i][j].setText(""+array.getElement(i, j));
			}
		}
	}

}
