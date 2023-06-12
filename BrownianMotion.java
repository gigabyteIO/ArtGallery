import javafx.scene.paint.Color;

/**
 * An animated artwork that shows 1000 shapes vibrate in random directions. 
 * @author martin
 *
 */
public class BrownianMotion extends AnimatedArt {

	private Shape[] shapes; // The array of shapes.
	
	public BrownianMotion(int width, int height) {
		super(width, height);
		shapes = new Shape[1000];
		makeShapes();
	}

	/**
	 * Draws the shapes.
	 */
	@Override
	protected void draw() {
		g.setFill(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		// Draws shapes.
		for(int i = 0; i < shapes.length; i++) {
			shapes[i].draw(g);
			shapes[i].setX(shapes[i].getX() + getRandomOffset());
			shapes[i].setY(shapes[i].getY() + getRandomOffset());
		}
		// Border.
		g.setStroke(Color.BLACK);
		g.setLineWidth(5);
		g.strokeRect(0, 0, width, height);
	}
	
	/**
	 * Creates and fills the shapes array with a 50% chance of a square or circle and a randomly selected color.
	 */
	public void makeShapes() {
		for(int i = 0; i < shapes.length; i++) {
			if(Math.random() > .5)
				shapes[i] = new Square(width/2, height/2, width / 50, randomBrightColor() );
			else
				shapes[i] = new Circle(width/2, height/2, width / 50, randomBrightColor() );
		}
	}
	
	/**
	 * Returns the offset -1 or 1. (50%/50%)
	 */
	public double getRandomOffset() {
		double offset;
		if(Math.random() > .5)
			offset = 1;
		else
			offset = -1;
		return offset;
	}
	
	

}
