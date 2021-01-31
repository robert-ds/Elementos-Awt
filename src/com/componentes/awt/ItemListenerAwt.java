package com.componentes.awt;

import java.awt.*;
import java.awt.event.*;


public class ItemListenerAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public ItemListenerAwt() {
		prepareGUI();
	}
	
	public static void main(String[] args) {
		
		ItemListenerAwt itemListenerAwt = new ItemListenerAwt();
		itemListenerAwt.showItemListenerAwt();
		
	}
	
	private void prepareGUI() {
		mainFrame = new Frame("Java Awt ItemListener");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3,1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
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
	
	private void showItemListenerAwt() {
		headerLabel.setText("Listener in Action: ItemListener");
		Checkbox chkApple = new Checkbox("Apple");
		Checkbox chkMango = new Checkbox("Mango");
		Checkbox chkPeer = new Checkbox("Peer");
		
		
		chkApple.addItemListener(new CustomItemListener());
		chkMango.addItemListener(new CustomItemListener());
		chkPeer.addItemListener(new CustomItemListener());
		
		controlPanel.add(chkApple);
		controlPanel.add(chkMango);
		controlPanel.add(chkPeer);
		
		mainFrame.setVisible(true);
	}
	
	class CustomItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			statusLabel.setText(e.getItem() + " CheckBox " + (e.getStateChange() == 1 ? "Checked": "unchecked"));
		}
	}	
	
}
