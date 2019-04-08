package mainPkg;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

@SuppressWarnings("serial")
public class View extends JPanel{
	final int stdFrameCnt = 10;
	final int fireFrameCnt = 4;
	final int jumpFrameCnt = 8;
    int picNum = 0;
    BufferedImage[][] pics;
    EOrc currentOrc;
    int xLoc;
    int yLoc;
    static JFrame frame;
    JButton b;
    final static int xIncr = 8; 
    final static int yIncr = 2; 
    final static int frameWidth = 500;
    final static int frameHeight = 325;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    String buttonText = "Stop Movement";

	//Constructor: get image, segment and store in array
	public View() { 
		//load imgs
		pics = new BufferedImage[EOrc.values().length][];
		for (EOrc orc : EOrc.values()) {
			pics[orc.ordinal()] = new BufferedImage[orc.getframeCount()];
			BufferedImage img = createImage(orc);
			for (int frameNum = 0; frameNum < orc.getframeCount(); frameNum++)
				pics[orc.ordinal()][frameNum] = img.getSubimage(imgWidth * frameNum, 0, imgWidth, imgHeight);
		}
		//make frame
		frame = new JFrame();
		b = new JButton(buttonText);
		b.setFocusable(false);
    	frame.add(b);
    	frame.getContentPane().add(this);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	frame.setFocusable(true);
    	frame.requestFocus();
	}
	public JButton getButton() {
		return b;
	}
	public JFrame getFrame() {
		return frame;
	}
	public int getWidth(){
		return frameWidth;
	}
	public int getHeight(){
		return frameHeight;
	}
	public int getImageWidth(){
		return imgWidth;
	}
	public int getImageHeight(){
		return imgHeight;
	}
	public String getButtonText() {
		return buttonText;
	}
	public void setButtonText(String s) {
		buttonText = s;
	}

	public void update(int x, int y, Direction dir, boolean stoppedMovement, boolean firing, boolean jumping){
		
		xLoc = x;
		yLoc = y;
		
		if (firing) {
			switch (dir) {
			case NORTH: currentOrc = EOrc.fireNorth; break;
			case NORTHEAST: currentOrc = EOrc.fireNorthEast; break;
			case EAST: currentOrc = EOrc.fireEast; break;
			case SOUTHEAST: currentOrc = EOrc.fireSouthEast; break;
			case SOUTH: currentOrc = EOrc.fireSouth; break;
			case SOUTHWEST: currentOrc = EOrc.fireSouthWest; break;
			case WEST: currentOrc = EOrc.fireWest; break;
			case NORTHWEST: currentOrc = EOrc.fireNorthWest; break;
			}
			if(!stoppedMovement) {
				picNum = (picNum + 1) % fireFrameCnt;
			}		
		}
		else if(jumping) {
			switch (dir) {
			case NORTH: currentOrc = EOrc.jumpNorth; break;
			case NORTHEAST: currentOrc = EOrc.jumpNorthEast; break;
			case EAST: currentOrc = EOrc.jumpEast; break;
			case SOUTHEAST: currentOrc = EOrc.jumpSouthEast; break;
			case SOUTH: currentOrc = EOrc.jumpSouth; break;
			case SOUTHWEST: currentOrc = EOrc.jumpSouthWest; break;
			case WEST: currentOrc = EOrc.jumpWest; break;
			case NORTHWEST: currentOrc = EOrc.jumpNorthWest; break;
			}
			if(!stoppedMovement) {
				picNum = (picNum + 1) % jumpFrameCnt;
			}		
		}
		else {
			//Direction -> EOrc
			//I would rather this be inside one the the enums or just have a single enum, but apparently the code for it has to be 
			//here so let's go with this for now
			switch(dir) {
			case NORTH: currentOrc = EOrc.north; break;
			case NORTHEAST: currentOrc = EOrc.northEast; break;
			case EAST: currentOrc = EOrc.east; break;
			case SOUTHEAST: currentOrc = EOrc.southEast; break;
			case SOUTH: currentOrc = EOrc.south; break;
			case SOUTHWEST: currentOrc = EOrc.southWest; break;
			case WEST: currentOrc = EOrc.west; break;
			case NORTHWEST: currentOrc = EOrc.northWest; break;
			}	
			if(!stoppedMovement) {
				picNum = (picNum + 1) % stdFrameCnt;
			}		
		}
		try {
			frame.repaint();
			Thread.sleep(100);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Read image from file and return
	private BufferedImage createImage(EOrc orc){
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(orc.getFile()));
			return bufferedImage;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void paint(Graphics g) {
		g.drawImage(pics[currentOrc.ordinal()][picNum], xLoc, yLoc, Color.gray, this);
    }
}
