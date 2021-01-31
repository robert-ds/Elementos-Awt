package com.componentes.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * <h1>Button</h1>
 * El control del cuadro de diálogo representa una ventana de nivel superior con un título 
 *  y un borde que seutiliza para tomar alguna forma de entrada del usuario.
 *<p>
 * @author Robert Vasquez
 * @since 2020
 * 
 * */

public class DialogAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public DialogAwt() {
		prepareGUI();
	}
	
	public static void main(String[] args) {
		DialogAwt dialogAwt = new DialogAwt();
		dialogAwt.showDialogAwt();
	}
	
	private void prepareGUI() {
		mainFrame = new Frame("Java Awt Dialg");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3, 1));
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
	
	private void showDialogAwt() {
		headerLabel.setText("Control in Action: Dialog");
		Button showAboutDialogButton = new Button("Show About Dialog");
		showAboutDialogButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AboutDialog aboutDialog = new AboutDialog(mainFrame);
				aboutDialog.setVisible(true);
			}
		});
		
		controlPanel.add(showAboutDialogButton);
		mainFrame.setVisible(true);
	}
	
	class AboutDialog extends Dialog{
		
		public AboutDialog(Frame parent) {
			super(parent, true);
			setBackground(Color.gray);
			setLayout(new BorderLayout());
			Panel panel = new Panel();
			panel.add(new Button("Close"));
			add("South", panel);
			setSize(300,300);
			
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent windowEvent) {
					dispose();
				}
			});
		}
		
		public boolean action(Event evt, Object arg) {
			if(arg.equals("Close")) {
				dispose();
				return true;
			}
			return false;
		}
		
		public void paint(Graphics g) {
			g.setColor(Color.white);
			g.drawString("Esta es una Ventana de Dialogo", 50, 100);
			g.drawString("Version 1.0", 100, 130);
		}
		
	}
	
	
}
