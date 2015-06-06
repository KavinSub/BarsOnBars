import java.awt.geom.*;
import java.awt.Color;


public class Bar{
	// The initial x position, initial y position,bar width, current height,and max height of bar in pixels(amplitude)
	int xPos;
	int yPos;
	int width;
	double currentHeight = 0;
	double maxHeight;

	// The period for a full bar oscillation in milliseconds
	double period;
	// The specified delay in milliseconds: default 0
	double delay = 0;

	// The rectangle object, and color of the bar: default black
	Rectangle2D bar;
	Color color = Color.BLACK;

	// A constructor for the following attributes
	public Bar(int xPos, int yPos, int width, int maxHeight, double period, Color color){
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.maxHeight = maxHeight;
		this.period = period;
		this.color = color;

		bar = new Rectangle2D.Double(xPos, yPos, width, 0);
	}

	// Constructor with delay attribute
	public Bar(int xPos, int yPos, int width, int maxHeight, double period, double delay, Color color){
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.maxHeight = maxHeight;
		this.period = period;
		this.delay = delay;
		this.color = color;

		bar = new Rectangle2D.Double(xPos, yPos, width, 0);
	}	

	// Constructor w/out color attribute
	public Bar(int xPos, int yPos, int width, int maxHeight, double period){
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.maxHeight = maxHeight;
		this.period = period;

		bar = new Rectangle2D.Double(xPos, yPos, width, 0);
	}

	// Updates the height of the bar based on the given formula
	void updateHeight(double time){
		//currentHeight = maxHeight * Math.sin((2 * Math.PI)/period * time);
		time -= delay;
		if(time > 0){
			currentHeight = maxHeight * Math.sin((2 * Math.PI)/period * time);
			if(currentHeight > 0){
				bar.setRect(xPos, yPos, width, currentHeight);
			}else{
				bar.setRect(xPos, yPos + currentHeight, width, -1 * currentHeight);
			}
		}
		return;
	}


}