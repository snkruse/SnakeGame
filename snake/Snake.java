package snake;

import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * Snake represented  by list of Point class
 */

public class Snake {

	List<Point> snakePoints;
	int xDir, yDir;
	boolean isMoving, elongate;
	//Specify where snake is going to start and be
	final int STARTSIZE = 20, STARTX = 150, STARTY = 150; 
	
	Snake(){
		snakePoints = new ArrayList<Point>();
		xDir     = 0;
		yDir     = 0;
		isMoving = false;
		elongate = false;
		snakePoints.add(new Point(STARTX,STARTY));
		for(int i = 1; i < STARTSIZE; i++){
			snakePoints.add(new Point(STARTX - i * 4, STARTY));
		}
	}
	
	// create a Snake object in SnakeGame, instantiate the object and 
	// call the draw method passing the gfx graphics within the snake game
	public void draw(Graphics g){
		g.setColor(Color.yellow);
		
		// snake made up several tiny rectangles
		for(Point p : snakePoints){
			System.out.println(snakePoints.size());
			g.fillRect(p.getX(), p.getY(), 4, 4);
		}
	}
	
	// move  gets called in our infinit loop, moves the snake, 
	// briefly pauses so we can see the movement.
	public void move(){

		if(isMoving){
			Point temp = snakePoints.get(0);
			Point last = snakePoints.get(snakePoints.size() -1);
			// represents the new starting point of our snake
			Point newStart = new Point(temp.getX() + xDir *4, temp.getY() + yDir *4);
			// updates the entire bod
			// iterate backwards through the snake
			// every snake points becomes the point that was before it
			for(int i = snakePoints.size() - 1; i >= i; i--){
				snakePoints.set(i, snakePoints.get(i - 1));
			}
			//update the orginal head
			snakePoints.set(0, newStart);
		}

	}
	
	public boolean isMoving(){
		return isMoving;
	}
	
	public void setIsMoving(boolean b){
		isMoving = b;
	}
	
	public int getXDir(){
		return xDir;
	}
	
	public int getYDir(){
		return yDir;
	}
	
	public void setXDir(int x){
		xDir = x;
	}
	
	public void setYDir(int y){
		yDir = y;
	}
	
	// X is the head position of the snake
	public int getX(){
		return snakePoints.get(0).getX();
	}
	
	public int getY(){
		return snakePoints.get(0).getY();
	}
	
}
