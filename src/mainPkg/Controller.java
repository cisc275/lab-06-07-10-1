package mainPkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

/**
 * Do not modify this file without permission from your TA.
 **/

public class Controller implements KeyListener{

	private Model model;
	private View view;
	
	public Controller(){
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
	}
	
        //run the simulation
	public void start(){
		JButton b = view.getButton();
		b.setBounds(0, 225, 150, 50);
    	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (view.getButtonText().equals("Stop Movement")) {
				b.setText("Start Movement");
				view.setButtonText("Start Movement");
			}
			else {
				b.setText("Stop Movement");
				view.setButtonText("Stop Movement");
			}
			
			Model.changeMoving();
		}
    		
    	});
		for(int i = 0; i < 5000; i++)
		{
			//increment the x and y coordinates, alter direction if necessary
			model.updateLocationAndDirection();
			//update the view
			view.update(model.getX(), model.getY(), model.getDirect(),model.getStopMoving());
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
}
