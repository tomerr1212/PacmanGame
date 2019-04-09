package GIS;

import Geom.Pixel;
import Geom.Point3D;

/**
 * 
 * @author Ortal, Tomer and Avichay
 * @note This class represent the main player on board.
 * My Player is a purple icon ('M')
 */
public class Myplayer {
	private String type;
	private int id ;
	private Point3D gps;
	private double speed;
	private double radius;
	private Pixel pix;
	private int score;

	public Myplayer() {
		this.type = "M";
		this.id = 1;
		this.gps = new Point3D();
		this.speed = 1;
		this.radius = 1;
		this.pix = new Pixel();
		this.score = 0;
	}

	public Myplayer(String type,int id, Point3D gps, double speed, double radius, Pixel pix, int score) {
		this.type = type;
		this.id= id;
		this.gps = gps;
		this.speed = speed;
		this.radius = radius;
		this.pix = pix;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Myplayer [type=" + type + ", id=" + id + ", gps=" + gps + ", speed=" + speed + ", radius=" + radius
				+ ", pix=" + pix + ", score=" + score + "]";
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

	public Pixel getPix() {
		return pix;
	}

	public void setPix(Pixel pix) {
		this.pix = pix;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
