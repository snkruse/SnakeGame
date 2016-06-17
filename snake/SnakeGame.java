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

		this.resize(800,400);
		//Represents our offscreen image
		img = createImage(800,400);
		gfx = img.getGraphics();
		this.addKeyListener(this);
		snake = new Snake();
		// pass SnakeGame (a runnable object)
		thread = new Thread(this);
		thread.start();

	}
	
	// Applet will call paint() right after init() is called
	public void paint(Graphics g){
		// will become offscreen graphics
		gfx.setColor(Color.black);
		gfx.fillRect(0,0, 800,400);
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
			
			// move our snake, which is updating our point class to where we are
			// on the screen. 
			snake.move();
			//repaint this snake game over and over
			this.repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				System.out.println("thread exception thrown");
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!snake.isMoving()){
			if(e.getKeyCode() == KeyEvent.VK_UP ||e.getKeyCode() == KeyEvent.VK_RIGHT||
					e.getKeyCode() == KeyEvent.VK_DOWN){
				snake.setIsMoving(true);
			}
		}
		
		//Controls our user input (up, down, left, right)
		if(e.getKeyCode()== KeyEvent.VK_UP){
			System.out.println("up");
			// if the snake is not going down, we will allow the snake to go up
			// Then set x direction having no direction
			if(snake.getYDir()  != 1){
				snake.setYDir(-1);
				snake.setXDir(0);
			}
		}
		if(e.getKeyCode()== KeyEvent.VK_LEFT){
			System.out.println("left");
			if(snake.getYDir()  != -1){
				snake.setYDir(1);
				snake.setXDir(0);
			}	
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT){
			System.out.println("right");
			if(snake.getXDir()  != 1){
				snake.setXDir(-1);
				snake.setXDir(0);
			}	
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN){
			System.out.println("down");
			if(snake.getXDir()  != -1){
				snake.setXDir(1);
				snake.setXDir(0);
			}	
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
	
	
}
