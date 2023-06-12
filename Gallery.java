import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineJoin;
import javafx.stage.Stage;

/**
 * This program displays a large rectangle containing several
 * "artworks."  The artworks are rectangles that are defined by
 * subclasses of class Art.  Artworks can optionally be surrounded
 * by frames.  Some artworks are animated, and some are clickable
 * (that is, something happens when the user clicks the mouse on
 * the artwork).  There are buttons for turning animations on and
 * off and for "resetting" the art.  All art is added to the
 * gallery in the setup() method.
 */
public class Gallery extends Application {
	
	private final static int WALL_WIDTH = 1200;  // Width of gallery wall, in pixels.
	private final static int WALL_HEIGHT = 800;  // Height of gallery wall, in pixels.
	
	private Pane wall;  // The gallery wall -- the large rectangle containing the art.
	private boolean animationsRunning = true;  // Animations run when the is true.
	
	
	/**
	 * Adds the artworks to the gallery wall, by calling the addArt() methods in this class.
	 */
	private void setup() {
		addArt( new PseudoMondrian(300, 400), 50, 50);
		addArt( new PseudoKandinsky(400, 300), 400, 100);
		addArt( new PseudoPollock(300,400), 850, 50 );
		addArt( new BrownianMotion(300, 300), 50, 475);
		addArt( new ArcBurst(300, 350), 450, 425);
		addArt( new GrowingCircles(300, 300), 850, 475);
		//addArt( new InfiniteMotion(300, 300), 50, 50, Color.rgb(130,70,20) );
		
		
	}
	
	/**
	 * Adds an artwork to the wall, with no frame around the art.  This method is
	 * called by all the other addArt() methods.  Note that it calls the draw()
	 * method in the artwork to make sure that the art is drawn initially.  If
	 * animations are running and the artwork is animated, it also starts the artwork's
	 * animation.
	 * @param artwork The artwork to be added.  Must not be null.
	 * @param x The horizontal coordinate of the top left corner of the art, in pixels.
	 * @param y The vertical coordinate of the top left corner of the art, in pixels.
	 */
	private void addArt( Art artwork, int x, int y ) {
		wall.getChildren().add(artwork);
		artwork.relocate(x, y);
		artwork.draw();
		if (animationsRunning && artwork instanceof AnimatedArt) {
			AnimatedArt animArt = (AnimatedArt)artwork;
			animArt.startAnimation();
		}
	}

	/**
	 * Adds an artwork to the wall, with a frame around the art.  (The frame
	 * also comes with a white background, which lies behind the art.)
	 * @param artwork The artwork to be added.  Must not be null.
	 * @param x The horizontal coordinate of the top left corner of the art, in pixels.
	 * @param y The vertical coordinate of the top left corner of the art, in pixels.
	 * @param frameColor The color for the frame.  Must not be null.
	 * @param frameWidth The width of the frame, in pixels.  The frame is drawn
	 *   outside the art, so its size is larger than the art, and its top-left
	 *   corner is to the left and above the top-left corner of the art.
	 */
	private void addArt( Art artwork, int x, int y, Color frameColor, int frameWidth ) {
		Rectangle frame = new Rectangle( x-frameWidth/2, y-frameWidth/2,
				artwork.getWidth() + frameWidth,artwork.getHeight() + frameWidth);
		frame.setStroke(frameColor);
		frame.setFill(Color.WHITE);
		frame.setStrokeWidth(frameWidth);
		frame.setStrokeLineJoin(StrokeLineJoin.ROUND);
		wall.getChildren().add(frame);
		addArt(artwork,x,y);
	}
	
	/**
	 * This convenience method adds artwork to the wall with a given frame color
	 * and a frame width of 6.  It just calls the previous method.
	 */
	private void addArt( Art artwork, int x, int y, Color frameColor ) {
		addArt(artwork,x,y,frameColor,6);
	}
	
	
	/**
	 * This method is called by the main program when the user clicks the
	 * "Reset All Animations" button.  It calls the reset() method in each
	 * artwork.  Unless they have changed the behavior of reset(), an animated
	 * artwork restarts from frame number 0, a clickable artwork is cleared
	 * by filling it with its background color, and a regular artwork is
	 * redraw (which only has an effect if draw() uses some random numbers).
	 */
	private void resetArt() {
		for (Node node : wall.getChildren()) {
			if (node instanceof Art) {
				Art art = (Art)node;
				art.reset();
			}
		}
	}
	
	
	//---------- YOU ARE NOT EXPECTED TO FULLY UNDERSTAND THE REST OF THIS CLASS!------------
	
	
	/**
	 * This method is called by the main program when the user clicks the
	 * "Pause All Animations" button. 
	 */
	private void pauseAnimations() {
		if ( ! animationsRunning )
			return;
		animationsRunning = false;
		for (Node node : wall.getChildren()) { 
			if (node instanceof AnimatedArt) { 
				((AnimatedArt)node).pauseAnimation();
			}
		}
	}
	
	
	/**
	 * This method is called by the main program when the user clicks the
	 * "Start All Animations" button. 
	 */
	private void startAnimations() {
		if ( animationsRunning )
			return;
		animationsRunning = true;
		for (Node node : wall.getChildren()) {
			if (node instanceof AnimatedArt) { 
				((AnimatedArt)node).startAnimation();
			}
		}
	}
	
	
	/**
	 *  The Application's start() method is called by the system when the
	 *  program is run.  It sets up the GUI.
	 */
	public void start(Stage stage) {
		BorderPane root = new BorderPane();
		wall = new Pane();
		wall.setPrefSize(WALL_WIDTH,WALL_HEIGHT);
		root.setCenter(wall);
		Button resetButton = new Button("Reset All Art");
		resetButton.setOnAction( e -> resetArt() );
		Button pauseButton = new Button("Pause All Animations");
		pauseButton.setOnAction( e -> pauseAnimations() );
		Button startButton = new Button("Start All Aniimations");
		startButton.setOnAction( e -> startAnimations() );
		HBox buttons = new HBox(resetButton,pauseButton,startButton);
		buttons.setAlignment(Pos.CENTER);
		buttons.setStyle("-fx-padding:4px; -fx-border-color: black; -fx-border-width:2px 0 0 0");
		root.setBottom(buttons);
		stage.setScene( new Scene(root));
		stage.setTitle("Art Gallery");
		setup();
		stage.show();
		stage.setResizable(false);
	}
	
	
	/**
	 * The main() routine just calls launch() to launch the application.
	 */
	public static void main(String[] args) {
		launch();
	}
	
}