import javafx.scene.paint.Color;

/**
 * 
 * This subclass of art shows a bunch of randomly colored pastel squares with 
 * randomly colored ovals drawn in the center of each square.  
 * It is inspired by Wassily Kandinsky's grid pattern paintings.
 *
 * @author martin
 *
 */
public class PseudoKandinsky extends Art {

	protected final int RECTANGLES = 8; // The number of rectangles in the grid pattern.
	
	/**
	 * Create the canvas with a given size.  This just
	 * calls the method from the superclass, but it is
	 * required because constructors are not inherited.
	 */
	public PseudoKandinsky(int width, int height) {
		super(width, height);
	}

	/**
	 * Draws randomly colored squares in a grid pattern with
	 * randomly colored ovals on top.
	 * Note that when reset() is called, the image will
	 * be redrawn with new random colors.
	 */
	protected void draw() {
		g.setStroke(Color.BLACK);
		g.setLineWidth(1.25);
		
		double rectWidth = width / RECTANGLES;
		double rectHeight = height / RECTANGLES;
		
		double x,y;
		x = 0;
		y = 0;
		
		Color fillColor;
		/** Draw randomly colored rectangles **/
		for(int row = 0; row < RECTANGLES; row++) {			
			for(int col = 0; col < RECTANGLES; col++) {	
				/** Draw rectangles. **/
				fillColor = randomBrightColor();
				g.setFill(fillColor);
				g.fillRect(x, y, rectWidth, rectHeight);
				
				/** Draw ovals. **/
				fillColor = randomBrightColor();
				g.setFill(fillColor);
				g.fillOval(x + (rectWidth / 6), y + (rectHeight / 6) , rectWidth / 1.5, rectHeight / 1.5);
				g.setStroke(fillColor.darker());
				g.strokeOval(x + (rectWidth / 6), y + (rectHeight / 6) , rectWidth / 1.5, rectHeight / 1.5);
				x += rectWidth;		
			}
			x = 0;
			y += rectHeight;		
		}

		/** Draw the row/column lines **/
		x = rectWidth;
		y = rectHeight;
		for(int row = 0; row < RECTANGLES; row++) {	
			g.strokeLine(0, y, width, y);
			y += rectHeight;
		}
		for(int col = 0; col < RECTANGLES; col++) {
			g.strokeLine(x, 0, x, height);
			x += rectWidth;
		}
		
		/** Draw black border **/
		g.setLineWidth(5);
		g.strokeRect(0, 0, width, height);
	}

}
