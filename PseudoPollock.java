import javafx.scene.paint.Color;

/**
 * This subclass of art shows a bunch of random colored lined on
 * a gray background.  It is inspired by Jackson Pollock's drip
 * paintings.
 */
public class PseudoPollock extends Art {

	/**
	 * Create the canvas with a given size.  This just
	 * calls the method from the superclass, but it is
	 * required because constructors are not inherited.
	 */
	public PseudoPollock(int width, int height) {
		super(width, height);
	}

	/**
	 * Fills the canvas with a random gray, then draws
	 * a random number of random lines with random colors.
	 * Note that when reset() is called, the image will
	 * be redrawn with new random colors and lines.
	 */
	protected void draw() {
		g.setFill( Color.gray(Math.random()) );
		g.fillRect(0,0,width,height);
		g.setLineWidth(2.5);
		int lineCt = 100 + (int)(500*Math.random());
		for (int ct = 0; ct < lineCt; ct++) {
			double x1 = width*Math.random();
			double y1 = height*Math.random();
			double x2 = width*Math.random();
			double y2 = height*Math.random();
			g.setStroke(Color.hsb( 360*Math.random(), 1, 1));
			g.strokeLine(x1, y1, x2, y2);
		}
		
		/** Draw black border **/
		g.setLineWidth(10);
		g.setStroke(Color.DARKBLUE);
		g.strokeRect(0, 0, width, height);
	}
	
}