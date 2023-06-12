import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A Shape object is a simple container for the specification
 * of a colored shape with a center point, a size, and a color.
 * All instance variables of the object are protected.
 */
public abstract class Shape {

	/**
	 * X-coordinate of the the center point of the shape.
	 */
	protected double x;

	/**
	 * Y-coordinate of the center point of the shape.
	 */
	protected double y;

	/**
	 * Size of the shape, such as the diameter of a disk or
	 * the length of side of a square.
	 */
	protected double size;

	/**
	 * The color of the shape.
	 */
	protected Color color;

	/**
	 * The bounds of where the shape can move.
	 */
	protected double top, bottom, left, right;
	
	
	/********* ABSTRACT METHODS *********/
	
	/**
	 * Do the actual drawing of the artwork.  IN subclasses, this method can use the
	 * variable g to draw on the canvas, and it can use width and height if it needs
	 * to know the size of the canvas.
	 */
	abstract protected void draw(GraphicsContext g);
	
	abstract protected void setX(double x);
	
	abstract protected void setY(double y);
	
	abstract protected double getX();
	
	abstract protected double getY();

} // end class Shape

