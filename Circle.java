import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape{
	
	public Circle(double x, double y, double size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}
	public void draw(GraphicsContext g) {
		g.setFill(color);
		g.fillOval(x, y, size, size);
	}

	@Override
	protected void setX(double x) {	
		this.x = x;	
	}

	@Override
	protected void setY(double y) {
		this.y = y;		
	}

	@Override
	protected double getX() {
		return x;
	}

	@Override
	protected double getY() {
		return y;
	}

}
