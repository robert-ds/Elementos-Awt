package com.componentes.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * <h1>CheckBox</h1>
 * El control TextArea en AWT nos proporciona un área de editor multilínea. El usuario puede escribir aquí
 * tanto como quiera.
 *<p>
 * @author Robert Vasquez
 * @since 2020
 * 
 * */

public class TextAreaAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public TextAreaAwt(){
		prepareGUI();
	}
	
	public static void main(String[] args){
	TextAreaAwt awtControlDemo = new TextAreaAwt();
	awtControlDemo.showTextAreaDemo();
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
	
	private void showTextAreaDemo(){
		headerLabel.setText("Control in action: TextArea");
		
		Label commentlabel= new Label("Comments: ", Label.RIGHT);
		final TextArea commentTextArea = new TextArea("This is a AWT"
		+"to make GUI application in Java.",5,30);
		
		Button showButton = new Button("Show");
		
		showButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		statusLabel.setText( commentTextArea.getText());
		}
		});
		
		controlPanel.add(commentlabel);
		controlPanel.add(commentTextArea);
		controlPanel.add(showButton);
		mainFrame.setVisible(true);
		
	}
	
}
