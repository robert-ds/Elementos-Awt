package com.componentes.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * <h1>Button</h1>
 * El botón es un componente de contrrol que tiene una etiqueta y genera un evento cuando se pressiona.
 * Cuando se presiona y suelta un botón, AWT envía una insstancia de ActionEvent al botón,, llamando a
 * proccessEvent en el botón.
 *<p>
 * @author Robert Vasquez
 * @since 2020
 * 
 * */

public class ButtonAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public ButtonAwt(){
	prepareGUI();
	}
	
	public static void main(String[] args){
	ButtonAwt awtControlDemo = new ButtonAwt();
	awtControlDemo.showButtonDemo();
	}
	
	private void prepareGUI(){
		mainFrame = new Frame("Java AWT Button Examples");
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
	
	private void showButtonDemo(){
		headerLabel.setText("Control in action: Button");
		Button okButton = new Button("OK");
		Button submitButton = new Button("Submit");
		Button cancelButton = new Button("Cancel");
		okButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		statusLabel.setText("Ok Button clicked.");
		}
		});
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			statusLabel.setText("Submit Button clicked.");
			}
			});
			cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			statusLabel.setText("Cancel Button clicked.");
			}
			});
			
			controlPanel.add(okButton);
			controlPanel.add(submitButton);
			controlPanel.add(cancelButton);
			mainFrame.setVisible(true);
	}
	
	
}
