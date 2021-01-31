package com.componentes.awt;

import java.awt.*;
import java.awt.event.*;

public class FileDialogAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public FileDialogAwt(){
		prepareGUI();
	}
	
	public static void main(String[] args) {
		FileDialogAwt fileDialogAwt = new FileDialogAwt();
		fileDialogAwt.showFileDialog();
	}
	
	
	private void prepareGUI() {
		mainFrame = new Frame("Java Awt FileDialog");
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
	
	private void showFileDialog() {
		headerLabel.setText("Control in Action: FileDialog");
		
		final FileDialog fileDialog = new FileDialog(mainFrame, "Select File: ");
		Button showFileDialogButton = new Button("open File");
		showFileDialogButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fileDialog.setVisible(true);
				statusLabel.setText("File Selected: " + fileDialog.getDirectory() + fileDialog.getFile());
			}
		});
		
		controlPanel.add(showFileDialogButton);
		mainFrame.setVisible(true);
	}
}
