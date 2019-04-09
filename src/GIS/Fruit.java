package GIS;

import Geom.Pixel;
import Geom.Point3D;
import java.awt.Color;
/**
 * 
 * @author Ortal, Tomer and Avichay
 * @note This class represent a Fruit with getter and setters data.
 * Fruit is RED on the frame ('F')
 */

public class Fruit {
	private String type;
	private int id;
	private Point3D gps;
	private double weight;
	private Color color =Color.red;
	private Pixel pix;
	private String currentTime;
	private double timeMet;

	public Fruit() {
		this.type ="F";
		this.id=0;
		this.gps=new Point3D();
		this.weight=1;
		this.pix=new Pixel(); 
		this.currentTime="";
		this.timeMet=0;
	}

	public Fruit(String type, int id, Point3D gps, double weight , Pixel pix,String currentTime, double timeMet ) {
		this.type = type;
		this.id = id;
		this.gps = gps;
		this.weight = weight;
		this.pix = pix;
		this.currentTime=currentTime;
		this.timeMet=timeMet;
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Color getColor() {
		return color;
	}

	public Pixel getPix() {
		return pix;
	}

	public void setPix(Pixel pix) {
		this.pix = pix;
	}



	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public double getTimeMet() {
		return timeMet;
	}

	public void setTimeMet(double timeMet) {
		this.timeMet = timeMet;
	}

	@Override
	public String toString() {
		return "Fruit [type=" + type + ", id=" + id + ", gps=" + gps + ", weight=" + weight + ", color=" + color
				+ ", pix=" + pix + ", currentTime=" + currentTime + ", timeMet=" + timeMet + "]";
	}

}