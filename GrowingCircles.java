import javafx.scene.paint.Color;

/**
 * An animated artwork that draws different randomized circles at random points on the canvas.
 * The circles grow as long as they're under 5 pixels in size, once they go over this
 * a new random circle is created. 
 * 
 * @author martin
 *
 */
public class GrowingCircles extends AnimatedArt {
	
	protected Shape[] circles; 			// Holds the circle data. 
	protected final int SHAPES = 100;	// The total number of shapes in the array. 

	/**
	 * Constructor.
	 * @param width the width of the canvas.
	 * @param height the height of the canvas.
	 */
	public GrowingCircles(int width, int height) {
		super(width, height);
		createShapes(SHAPES);
	}

	@Override
	protected void draw() {
		//System.out.println("Frame: " + frameNumber);
		for(int i = 0; i < circles.length; i++) {
			circles[i].draw(g);
			updateForNextFrame();
		}
		
		g.setStroke(Color.BLACK);
		g.setLineWidth(5);
		g.strokeRect(0, 0, width, height);
	}
	
	
	/**
	 * Creates a circle with random attributes.
	 * @return the randomized circle.
	 */
	public Circle randomCircle() {
		return new Circle(Math.random() * width, Math.random() * height,
				Math.random() * 20, randomBrightColor() );
	}
	
	/**
	 * Utility function that initializes the circles array and fills it with random circles.
	 * @param numberOfShapes the total number of shapes.
	 */
	public void createShapes(int numberOfShapes) {
		circles = new Shape[numberOfShapes];
		for(int i = 0; i < numberOfShapes; i++) {
			circles[i] = randomCircle();
		}
	}
	
	/**
	 * Utility function that updates the circles for the next frame by adding +1
	 * to the size of the shape. 
	 */
	public void updateForNextFrame() {
		for(int i = 0; i < circles.length; i++) {
			if(circles[i].size > 5)
				circles[i] = randomCircle();
			else
				circles[i].size += 1;
		}
	}

}
