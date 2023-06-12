import javafx.scene.paint.Color;

/**
 * Represents an artwork that the user can click with the mouse.
 * Presumably, something will happen when the user clicks!
 */
abstract public class ClickArt extends Art {
	
	protected Color backgroundColor;  // Drawing the canvas fills it with this color.
	
	/**
	 * Create a ClickArt with a given size and backgroudn color WHITE.
	 */
	public ClickArt(int width, int height) {
		this(width,height,Color.WHITE);
	}

	/**
	 * Creates a ClickArt with a given size and a given background color.
	 * The background color should not be null.
	 */
	public ClickArt(int width, int height, Color backgroundColor) {
		super(width,height);
		this.backgroundColor = backgroundColor;
		setOnMousePressed( e -> doClickAt(e.getX(),e.getY()) );
	}
	
	/**
	 * The draw method simply fills the canvas with the background color,
	 * erasing anything else that has been drawn on the canvas.  Since
	 * reset() calls draw(), resetting a ClickArt will clear it.
	 */
	protected void draw() {
		g.setFill(backgroundColor);
		g.fillRect(0, 0, width, height);
	}
	
	/**
	 * This method is called when the user presses the mouse on the canvas.
	 * @param x the horizontal coordinate of the mouse location, in pixels
	 * @param y the vertical coordinate of the mouse location, in pixels
	 */
	abstract protected void doClickAt(double x, double y);

}