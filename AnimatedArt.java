import javafx.animation.AnimationTimer;

/**
 * A AnimatedArt represents an artwork that can be animated.  In
 * addition to the protected variables from Art, it defines a new
 * protected variable named frameNumber.  When the animation is
 * running, the draw() method will be called about 60 times per
 * second, and each time it is called, frameNumber increases by 
 * one each time the art.  By using frameNumber in the draw()
 * method, something different can be drawn in each frame.
 * This class is abstract because it does not define the draw() 
 * method; the draw() method must be defined in any concrete subclass.
 */
abstract public class AnimatedArt extends Art {

	protected int frameNumber = 0;    // The current frame number.
	private AnimationTimer animator;  // For implementing the animation.
	
	/**
	 * Create an AnimatedArt with a given width and height.  This
	 * constructor does not call draw() and does not start the animation 
	 * running.  This constructor is called by the constructor in any subclass, 
	 * but it can't be used directly since this is an abstract class.
	 */
	public AnimatedArt(int width, int height) {
		super(width,height); // Call constructor from the Art class.
		animator = new AnimationTimer() {
			public void handle(long now) {
				frameNumber++;
				draw();
			}
		};
	}
	
	/**
	 * Start the animation running (if it is not already running).
	 */
	public void startAnimation() {
		animator.start();
	}

	/**
	 * Stops the animation.  It can be restarted by calling the start() method.
	 */
	public void pauseAnimation() {
		animator.stop();
	}
	
	/**
	 * The reset method in this class sets the frame number to zero, then calls
	 * the reset() method in the superclass, which will call draw() to show
	 * frame number zero.
	 */
	public void reset() {
		frameNumber = 0;
		super.reset();
	}

}