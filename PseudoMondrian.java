import javafx.scene.paint.Color;

/**
 * 
 * This subclass of art shows a bunch of randomly colored vertical and horizontal
 * bars of varying width and height.  
 * It is inspired by Piet Mondrian's paintings.
 *
 * @author martin
 *
 */
public class PseudoMondrian extends Art {

	/**
	 * Create the canvas with a given size.  This just
	 * calls the method from the superclass, but it is
	 * required because constructors are not inherited.
	 */
	public PseudoMondrian(int width, int height) {
		super(width, height);
	}

	/**
	 * Draws randomly colored vertical and horizontal bars.
	 */
	protected void draw() {
		g.setFill(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		Color fillColor;
		
		/** Determines the number of horizontal/vertical bars(8 to 20). **/
		int bars = (int) (12 * Math.random() + 8);	

		for(int bar = 0; bar < bars; bar++) {
			
			fillColor = randomBrightColor();
			
			/** Draw horizontal bar. **/
			if(isHorizontal()) {
				drawHorizontalBar(getRandomHeight(height/100, height/15), getRandomYCoord(), fillColor);		
			}
			/** Draw vertical bar. **/
			else {
				drawVerticalBar(getRandomWidth(width/100, width/15), getRandomXCoord(), fillColor);
			}
		}		
		
		/** Draw black border. **/
		g.setLineWidth(10);
		g.setStroke(Color.BLACK);
		g.strokeRect(0, 0, width, height);
	}
	
	/**
	 * Draws a bar spanning the entire width of the canvas.
	 * @param barHeight the height of the bar.
	 * @param ycoord the top left y-coordinate of the bar.
	 * @param barColor the color of the bar.
	 */
	protected void drawHorizontalBar(double barHeight, double ycoord, Color barColor) {
		g.setFill(barColor);
		g.fillRect(0, ycoord, width, barHeight);
		/* 
		 * Adds a slight 3D effect by drawing a brighter line along 
		 * one edge of each bar and a darker line along the other edge.
		 */
		g.setLineWidth(2);
		g.setStroke(barColor.brighter());
		g.strokeLine(0, ycoord, width, ycoord);
		g.setStroke(barColor.darker());
		g.strokeLine(0, ycoord + barHeight, width, ycoord + barHeight);
	}
	
	/**
	 * Draws a bar spanning the entire height of the canvas.
	 * @param barWidth the width of the bar.
	 * @param xcoord the top left x-coordinate of the bar.
	 * @param barColor the color of the bar.
	 */
	protected void drawVerticalBar(double barWidth, double xcoord,  Color barColor) {
		g.setFill(barColor);
		g.fillRect(xcoord, 0, barWidth, height);		
		/* 
		 * Adds a slight 3D effect by drawing a brighter line along 
		 * one edge of each bar and a darker line along the other edge.
		 */
		g.setLineWidth(2);
		g.setStroke(barColor.brighter());
		g.strokeLine(xcoord, 0, xcoord, height);
		g.setStroke(barColor.darker());
		g.strokeLine(xcoord + barWidth, 0, xcoord + barWidth, height);
	}
	
	/**
	 * A function that returns a random(50/50) boolean value to determine if the next bar
	 * to be drawn will be horizontal.
	 * @return the randomized boolean value.
	 */
	protected boolean isHorizontal() {
		boolean isHorizontal;
		if(Math.random() > 0.5)
			isHorizontal = true;
		else
			isHorizontal = false;
		
		return isHorizontal;
	}
	
	/**
	 * Returns a random double value within the specified range.
	 * @param minWidth the minimum width range.
	 * @param maxWidth the maximum width range.
	 * @return the random number.
	 */
	protected double getRandomWidth(double minWidth, double maxWidth) {
		if(minWidth <= 0 || maxWidth > width)
			throw new IllegalArgumentException("Width range must be greater than zero and less than the canvas width.");
		else
			return ( (maxWidth - minWidth) * Math.random() + minWidth);
	}
	
	/**
	 * Returns a random double value within the specified range.
	 * @param minHeight the minimum height range.
	 * @param maxHeight the maximum height range.
	 * @return the random number.
	 */
	protected double getRandomHeight(double minHeight, double maxHeight) {
		if(minHeight <= 0 || maxHeight > height)
			throw new IllegalArgumentException("Height range must be greater than zero and less than the canvas height.");
		else
			return ( (maxHeight - minHeight) * Math.random() + minHeight);
	}
	
	/**
	 * Returns a random x-coordinate based on width of the canvas.
	 * @return random x-coordinate.
	 */
	protected double getRandomXCoord() {
		return Math.random() * width;
	}
	
	/**
	 * Returns a random y-coordinate based on height of canvas.
	 * @return random y-coordinate.
	 */
	protected double getRandomYCoord() {
		return Math.random() * height;
	}

}
