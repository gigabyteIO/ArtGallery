import javafx.scene.paint.Color;

/**
 * An animated artwork that shows a set of nested rectangles that constantly shrink
 * towards the center of the canvas (when the animation is running).  Adapted from
 * the example in http://math.hws.edu/javanotes8/c3/s9.html#control.8.3
 */
public class InfiniteMotion extends AnimatedArt {

	public InfiniteMotion(int width, int height) {
		super(width,height);
	}

	protected void draw() {
		g.setFill(Color.WHITE);
		g.fillRect(0,0,width,height);  // Fill drawing area with white.
		double inset; // Gap between edges of drawing area and outer rectangle.
		double rectWidth, rectHeight;   // The size of one of the rectangles.
		g.setStroke(Color.BLACK);  // Draw the rectangle outlines in black.
		inset = (frameNumber/2) % 15 + 0.5;  // (The 0.5 is a technicality that gives
		                                 //  a sharper picture.)
		rectWidth = width - 2*inset;
		rectHeight = height - 2*inset;
		while (rectWidth >= 0 && rectHeight >= 0) {
			g.strokeRect(inset, inset, rectWidth, rectHeight);
			inset += 15;       // rectangles are 15 pixels apart
			rectWidth -= 30;
			rectHeight -= 30;
		}
	}

}