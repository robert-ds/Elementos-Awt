package com.componentes.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * <h1>CheckBox</h1>
 * La clase CheckboxGroup se usa para agrupar el conjunto de cassillas de verificacción
 *<p>
 * @author Robert Vasquez
 * @since 2020
 * 
 * */

public class CheckBoxGroupAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public CheckBoxGroupAwt(){
		prepareGUI();
	}
	
	public static void main(String[] args){
	CheckBoxGroupAwt awtControlDemo = new CheckBoxGroupAwt();
	awtControlDemo.showCheckBoxGroupDemo();
	}
	
	private void prepareGUI(){
		mainFrame = new Frame("Java AWT CheckBoxGroupAwt");
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
	
	private void showCheckBoxGroupDemo(){
		headerLabel.setText("Control in action: CheckBoxGroup");
		
		CheckboxGroup fruitGroup = new CheckboxGroup();
		Checkbox chkApple = new Checkbox("Apple",fruitGroup,true);
		Checkbox chkMango = new Checkbox("Mango",fruitGroup,false);
		Checkbox chkPeer = new Checkbox("Peer",fruitGroup,false);
		
		statusLabel.setText("Apple Checkbox: checked");
		
		chkApple.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			statusLabel.setText("Apple Checkbox: checked");
		}
		});
		
		chkMango.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
		statusLabel.setText("Mango Checkbox: checked");
		}
		});
		
		chkPeer.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
		statusLabel.setText("Peer Checkbox: checked");
		}
		});
		
		controlPanel.add(chkApple);
		controlPanel.add(chkMango);
		controlPanel.add(chkPeer);
		mainFrame.setVisible(true);
		
		}
}
