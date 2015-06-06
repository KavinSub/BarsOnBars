import javax.swing.*;
import java.awt.*;
import java.io.*;

class MainDisplay{

	static Bar[] bars;
	static BarPanel mainPanel;
	public static void main(String[]args){
		JFrame frame = new JFrame();

		if(args.length == 1) LoadBars(args[0]); 
	    else LoadBars("bars.txt");

		mainPanel = new BarPanel(800, 800, Color.BLACK, bars);
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.setSize(mainPanel.width, mainPanel.height);
		frame.setTitle("Bars on Bars");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Loads in bars from a text file
	public static void LoadBars(String filename){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(filename));
		}catch(FileNotFoundException e){
			System.out.println("File could not be found.");
		}

		if(reader != null){
			try{
				// Gets the number of bars
				int numBars = Integer.parseInt(reader.readLine());
				bars = new Bar[numBars];
				// The array for the line tokens
				String[] line;
				// The Color reference
				Color tempColor = Color.BLACK;
				// For each bar in the text file
				for(int i = 0; i < numBars; i++){
					line = reader.readLine().split(" ");

					// Determines the color of the bar
					String color = line[line.length - 1].toUpperCase();
					if(color.equals("RED")) tempColor = Color.RED;
					if(color.equals("BLUE")) tempColor = Color.BLUE;
					if(color.equals("BLACK")) tempColor = Color.BLACK;
					if(color.equals("CYAN")) tempColor = Color.CYAN;
					if(color.equals("GREEN")) tempColor = Color.GREEN;
					if(color.equals("ORANGE")) tempColor = Color.ORANGE;
					if(color.equals("MAGENTA")) tempColor = Color.MAGENTA;
					if(color.equals("YELLOW")) tempColor = Color.YELLOW;
					// Sets the attributes in temp variables
					int xpos = Integer.parseInt(line[0]);
					int ypos = Integer.parseInt(line[1]);
					int width = Integer.parseInt(line[2]);
					int maxHeight = Integer.parseInt(line[3]);
					double period = Double.parseDouble(line[4]);
					double delay = Double.parseDouble(line[5]);

					// Initializes the bar object
					bars[i] = new Bar(xpos, ypos, width, maxHeight, period, delay, tempColor);
				}
		 	reader.close();
			}catch(IOException ioe){
				System.out.println("IO error occured! Please try again.");
			}
		}
	}


}