package com.componentes.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * <h1>CheckBox</h1>
 * El control de elección se utiliza para mostrar el menú emergente de opciones. La opción seleccionada se
 * muestra en la parte superior del menú.
 *<p>
 * @author Robert Vasquez
 * @since 2020
 * 
 * */

public class ChoiseAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public ChoiseAwt(){
		prepareGUI();
	}
	
	public static void main(String[] args){
	ChoiseAwt awtControlDemo = new ChoiseAwt();
	awtControlDemo.showChoiceDemo();
	}
	
	private void prepareGUI(){
		mainFrame = new Frame("Java AWT Choise");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
			});
		
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350,100);
		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}
	
	private void showChoiceDemo(){
		headerLabel.setText("Control in action: Choice");
		
		final Choice fruitChoice = new Choice();
		fruitChoice.add("Apple");
		fruitChoice.add("Grapes");
		fruitChoice.add("Mango");
		fruitChoice.add("Peer");
		
		Button showButton = new Button("Show");
		
		showButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String data = "Fruit Selected: "
			+ fruitChoice.getItem(fruitChoice.getSelectedIndex());
			statusLabel.setText(data);
		}
		});
		
		controlPanel.add(fruitChoice);
		controlPanel.add(showButton);
		mainFrame.setVisible(true);
	}
	
}
