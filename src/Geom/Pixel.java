package Geom;
/**
 * @author Ortal, Tomer and Avichay
 * This class is for calculate the proportions between coordinates and pixels 
 * on the board game and the frame of it.
 */
public class Pixel {
	double x;
	double y;

	public Pixel() {
		this.x=0;
		this.y=0;
	}
	public Pixel(double x , double y) {
		this.x =x;
		this.y =y;
	}
	/**
	 * @param a Pixel
	 * @return the distance of 2 pixels points on the frame
	 */
	public double distance(Pixel a) {
		double dx = this.x -a.x;
		double dy = this.y -a.y;
		double t = dx*dx+dy*dy;
		return Math.sqrt(t);
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Pixel [x=" + x + ", y=" + y + "]";
	}
}