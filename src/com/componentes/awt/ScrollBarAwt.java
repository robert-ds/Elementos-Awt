package com.componentes.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * <h1>Button</h1>
 * El control de la barra de desplazamiento representa un componente de la barra de desplazamiento para
 * permitir al usuario selecccionar del rango de valores.
 *<p>
 * @author Robert Vasquez
 * @since 2020
 * 
 * */

public class ScrollBarAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public ScrollBarAwt() {
		prepareGUI();
	}
	
	public static void main(String[] args) {
		ScrollBarAwt scrollBarAwt = new ScrollBarAwt();
		scrollBarAwt.showScrollBar();
	}
	
	private void prepareGUI() {
		mainFrame = new Frame("Java Awt ScrollBar");
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
	
	private void showScrollBar() {
		headerLabel.setText("Control in action: ScrollBar");
		
		final Scrollbar horizontalScroller = new Scrollbar(Scrollbar.HORIZONTAL);
		final Scrollbar verticalScroller = new Scrollbar();
		verticalScroller.setOrientation(Scrollbar.VERTICAL);
		horizontalScroller.setMaximum(100);
		horizontalScroller.setMinimum(1);
		verticalScroller.setMaximum(100);
		verticalScroller.setMinimum(1);
		
		horizontalScroller.addAdjustmentListener( new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				statusLabel.setText("Horinzontal: "
				+ horizontalScroller.getValue()
				+ " ,Vertical: "
				+ verticalScroller.getValue());
			}
			
		});
		
		verticalScroller.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				statusLabel.setText("Horizontal: "
				+ horizontalScroller.getValue()
				+ " ,Vertical: " + verticalScroller.getValue());
			}
		});
		
		controlPanel.add(horizontalScroller);
		controlPanel.add(verticalScroller);
		
		mainFrame.setVisible(true);
		
	}
	
	
	
}
