import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

/**
 * This subclass of ClickArt draws a random assortment of arcs with random colors where the user clicks. 
 * @author martin
 *
 */
public class ArcBurst extends ClickArt {
	
	protected double x, y;		// The x/y-coordinates of the users clicks.
	protected boolean clicked;	// Flag that keeps track of whether the user clicked.

	/**
	 * Constructor.
	 * @param width the width of the canvas.
	 * @param height the height of the canvas.
	 */
	public ArcBurst(int width, int height) {
		super(width, height);
		super.draw();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Draws where the user clicked.
	 */
	protected void draw() {
		if(clicked) {
			burst(x,y);
			clicked = false;
		}
		if(reset) 
			super.draw();
			
		g.setStroke(Color.BLACK);
		g.setLineWidth(10);
		g.strokeRect(0, 0, width, height);
		g.setLineWidth(1);
	}
	
	/**
	 * Does the drawing of the burst.
	 * @param x the x-coordinate of the click.
	 * @param y the y-coordinate of the click.
	 */
	protected void burst(double x, double y) {
		for(int i = 0; i < 30; i++) {		
			g.setStroke(randomBrightColor());
			g.strokeArc(x, y, Math.random() * width, Math.random() * height, Math.random() * 1000 , Math.random() * 100 , ArcType.OPEN);
		}	
	}

	/**
	 * Sets the x/y-coordinates, changes clicked flag, and calls the draw() method. 
	 */
	@Override
	protected void doClickAt(double x, double y) {
		if(!clicked) {
			this.x = x;
			this.y = y;
			clicked = true;
			draw();
		}
	}

}
