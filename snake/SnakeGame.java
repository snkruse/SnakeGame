package snake;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* Controls size of applet and background
 * Runnable - runnable applet, add unimplimented methods - 1: run()
 * 
 */
public class SnakeGame extends Applet implements Runnable, KeyListener{

	//Double Buffering
	Graphics gfx;
	Image img;
	//Since it is runnable must create a thread
	Thread thread;
	Snake snake;
	
	// When Applet starts automatically calls init()
	public void init(){
		this.resize(400,400);
		//Represents our offscreen image
		img = createImage(400,400);
		gfx = img.getGraphics();
		snake = new Snake();
		// pass SnakeGame (a runnable object)
		thread = new Thread(this);
		thread.start();

	}
	
	// Applet will call paint() right after init() is called
	public void paint(Graphics g){
		// will become offscreen graphics
		gfx.setColor(Color.black);
		gfx.fillRect(0,0, 400,400);
		// paint entire image 
		snake.draw(gfx);
		g.drawImage(img,0,0, null);
		// passing in the offscreen graphic

	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void repaint(Graphics g){
		paint(g);
	}

	/*
	 * infinite loop runs the game
	 * draws over and over 
	 */
	@Override
	public void run() {
		for(;;){
			
			this.repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Controls our user input (up, down, left, right)
		if(e.getKeyCode()== KeyEvent.VK_UP){
			
		}
		else if(e.getKeyCode()== KeyEvent.VK_LEFT){
					
				}
		else if(e.getKeyCode()== KeyEvent.VK_RIGHT){
			
		}
		else if(e.getKeyCode()== KeyEvent.VK_DOWN){
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
