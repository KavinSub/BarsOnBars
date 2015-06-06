import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BarPanel extends JPanel implements ActionListener{
	private static final int DELAY = 5;

	// Panel height and width
	int height;
	int width;

	// Background panel color
	Color background;

	// Time stuff
	Timer timer;
	int currentTime;

	// Array of bar objects
	Bar[] bars;

	// Bar object for testing purposes
	Bar testBar;

	// Constructor made for testing purposes; DO NOT USE
	public BarPanel(int width, int height){
		this.width = width;
		this.height = height;
		currentTime = 0;
		timer = new Timer(DELAY, this);
		timer.start();
		testBar = new Bar(10, 300, 20, 200, 2000, Color.BLACK);
	}

	// Constructor made for use with the bar array
	public BarPanel(int width, int height, Color background, Bar[] bars){
		this.width = width;
		this.height = height;
		this.background = background;
		this.bars = bars;
		currentTime = 0;
		timer = new Timer(DELAY, this);
		timer.start();		
	}

	// The graphics context for the panel
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		drawBars(g2);

		return;
	}

	// Updates the rectangle shape for each bar
	public void drawBars(Graphics2D g2){
		for(int i = 0; i < bars.length; i++){
			g2.setColor(bars[i].color);
			g2.fill(bars[i].bar);
		}
	}

	//Updates the height of each bar
	public void updateBars(int currentTime){
		for(int i = 0; i < bars.length; i++){
			bars[i].updateHeight((double) currentTime);
		}
	}

	// Runs at each timer fire
	public void actionPerformed(ActionEvent e){
		// Increment timer by defined timer delay
		currentTime += DELAY;

		// Updates the bars
		updateBars(currentTime);
		repaint();
		return;
	}



}