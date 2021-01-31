package com.componentes.awt;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>CheckBox</h1>
 * El control de imagen es una superclase para todas llass clases de imágenes que representan imágenes
 * gráficas.
 *<p>
 * @author Robert Vasquez
 * @since 2020
 * 
 * */

public class ImagenAwt {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public ImagenAwt(){
		prepareGUI();
	}
	
	public static void main(String[] args){
	ImagenAwt awtControlDemo = new ImagenAwt();
	awtControlDemo.showImageDemo();
	}
	
	private void prepareGUI(){
		mainFrame = new Frame("Java AWT ImagenAwt");
		mainFrame.setSize(500,500);
		mainFrame.setLayout(new GridLayout(3, 3));
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
	
	private void showImageDemo(){
		headerLabel.setText("Control in action: Image");
		
		controlPanel.add(new ImageComponent("C:\\Users\\Robert\\Pictures\\log.png"));
			mainFrame.setVisible(true);
		}
	
		class ImageComponent extends Component {
			BufferedImage img;
			
			public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
			
		public ImageComponent(String path) {
			try {
				img = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public Dimension getPreferredSize() {
			if (img == null) {
				return new Dimension(200,200);
			} else {
			return new Dimension(img.getWidth(), img.getHeight());
			}
		}
		
	}
}
