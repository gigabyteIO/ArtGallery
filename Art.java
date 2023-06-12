import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * An Art object represents a rectangular "canvas" on which
 * art is drawn.  An Art object can be added to a window and
 * is in particular able to be added to a Gallery.  This
 * class defines protected variables g, width, and height
 * for use in subclasses.  This class has an abstract 
 * draw() method that must be defined in concrete subclasses;
 * it is meant to draw the art.  It has a reset() method that
 * just calls draw(), but it can be overridden in subclasses.
 */
abstract public class Art extends Canvas {
	
	protected GraphicsContext g;  // A graphic context for drawing on the canvas.
	protected double width;    // The width of the canvas, in pixels.
	protected double height;   // The height of the canvas, in pixels.
	protected boolean reset;   // Flag to keep track of if the art has been reset.
	
	/**
	 * Creates an Art with a given width and height.  (This constructor
	 * is called by any the constructor in any subclass, but can't be
	 * used directly since Art is an abstract class.)  Note that
	 * the constructor does not call draw.
	 */
	public Art(int width, int height) {
		super(width,height);
		g = getGraphicsContext2D();
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Just calls draw().  Note that this method is called by the
	 * Gallery class when the user clicks "Reset All Art".
	 */
	public void reset() {
		reset = true;
		draw();
		reset = false;
	}
	
	/**
	 * Returns a random, bright saturated color.
	 */
	public Color randomBrightColor() {
		return Color.hsb( 360*Math.random(), 1.0, 1.0, Math.random() );
	}
	
	/**
	 * Returns a random, dark unsaturated color.
	 */
	public Color randomDarkColor() {
		return Color.hsb( 360*Math.random(), .9, .9);
	}

	/**
	 * Do the actual drawing of the artwork.  IN subclasses, this method can use the
	 * variable g to draw on the canvas, and it can use width and height if it needs
	 * to know the size of the canvas.
	 */
	abstract protected void draw();
	
}