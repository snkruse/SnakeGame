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
	
	// create a Snake object in SnakeGame, instantiate the object aand 
	// call the draw method passing the gfx graphics within the snake game
	public void draw(Graphics g){
		g.setColor(Color.yellow);
		
		// snake made up several tiny rectangles
		for(Point p : snakePoints){
			g.fillRect(p.getX(), p.getY(), 4, 4);
		}
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
