package GIS;

import Geom.Pixel;
import Geom.Point3D;

/**
 * 
 * @author Ortal, Tomer and Avichay
 * @note This class represent a ghost on board.
 * ghost is icon ('G')
 */
public class Ghost {

	private String type;
	private int id;
	private Point3D gps;
	private Pixel pix;
	private double speed;
	private double radius;



	public Ghost() {
		this.type ="G";
		this.id=0;
		this.gps=new Point3D();
		this.pix=new Pixel(); 
		this.speed=0;
		this.radius=0;
	}

	public Ghost(String type, int id, Point3D gps, Pixel pix,double speed,double radius) {
		this.type = type;
		this.id = id;
		this.gps = gps;
		this.pix = pix;
		this.speed = speed;
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Ghost [type=" + type + ", id=" + id + ", gps=" + gps + ", pix=" + pix + "speed="+speed+"radius="+radius+"]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Point3D getGps() {
		return gps;
	}

	public void setGps(Point3D gps) {
		this.gps = gps;
	}

	public Pixel getPix() {
		return pix;
	}

	public void setPix(Pixel pix) {
		this.pix = pix;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}