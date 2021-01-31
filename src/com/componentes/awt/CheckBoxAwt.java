package com.componentes.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * <h1>CheckBox</h1>
 * El control de casilla de verificación se utiliza para actiivar (verdadero) o desactivar (falso) una opción.. Hay
 * una etiqueta para cada casilla de verificación que representa lo que hace la casilla de verificación..
 *<p>
 * @author Robert Vasquez
 * @since 2020
 * 
 * */

public class CheckBoxAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public CheckBoxAwt(){
		prepareGUI();
	}
	
	public static void main(String[] args){
	CheckBoxAwt awtControlDemo = new CheckBoxAwt();
	awtControlDemo.showCheckBoxDemo();
	}
	
	private void prepareGUI(){
		mainFrame = new Frame("Java AWT Examples");
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
	
	private void showCheckBoxDemo(){
		headerLabel.setText("Control in action: CheckBox");
		
		Checkbox chkApple = new Checkbox("Apple");
		Checkbox chkMango = new Checkbox("Mango");
		Checkbox chkPeer = new Checkbox("Peer");
		
		chkApple.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
		statusLabel.setText("Apple Checkbox: "
				+ (e.getStateChange()==1?"checked":"unchecked"));
		}
		});
		
		chkMango.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
		statusLabel.setText("Mango Checkbox: "
		+ (e.getStateChange()==1?"checked":"unchecked"));
			}
		});
		
		chkPeer.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
		statusLabel.setText("Peer Checkbox: "
		+ (e.getStateChange()==1?"checked":"unchecked"));
		}
		});
		
		
		controlPanel.add(chkApple);
		controlPanel.add(chkMango);
		controlPanel.add(chkPeer);
		mainFrame.setVisible(true);
	}
}
