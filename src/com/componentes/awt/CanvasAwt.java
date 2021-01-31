package com.componentes.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * <h1>CheckBox</h1>
 * El control de lienzo representa un área rectangular donde la aplicación puede dibujarr algo o puede recibir
 * entradas creadas por el usuario.
 *<p>
 * @author Robert Vasquez
 * @since 2020
 * 
 * */

public class CanvasAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public CanvasAwt(){
		prepareGUI();
	}
	public static void main(String[] args){
	CanvasAwt awtControlDemo = new CanvasAwt();
	awtControlDemo.showCanvasDemo();
	}
	
	private void prepareGUI(){
		mainFrame = new Frame("Java AWT Canva");
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
	
	private void showCanvasDemo(){
		headerLabel.setText("Control in action: Canvas");
		controlPanel.add(new MyCanvas());
		mainFrame.setVisible(true);
	}
	
	class MyCanvas extends Canvas {
		
		public MyCanvas () {
		setBackground (Color.GRAY);
		setSize(300, 300);
	}
		
	public void paint (Graphics g) {
		Graphics2D g2;
		g2 = (Graphics2D) g;
		g2.drawString ("It is a custom canvas area", 70, 70);
	}
		
	}
	
}
