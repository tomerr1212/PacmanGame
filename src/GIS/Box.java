package GIS;

import Geom.Pixel;
import Geom.Point3D;

/**
 * 
 * @author Ortal, Tomer and Avichay
 * @note This class represent a box on board.
 * box is Black
 */
public class Box {

	private String type;
	private int id;
	private Point3D gps1,gps2;
	private Pixel pix1,pix2;


	public Box() {
		this.type ="B";
		this.id=0;
		this.gps1=new Point3D();
		this.gps2=new Point3D();
		this.pix1=new Pixel();
		this.pix2=new Pixel();
	}


	public Box(String type, int id, Point3D gps1, Point3D gps2, Pixel pix1, Pixel pix2) {
		super();
		this.type = type;
		this.id = id;
		this.gps1 = gps1;
		this.gps2 = gps2;
		this.pix1 = pix1;
		this.pix2 = pix2;
	}

	public Box(Point3D gps1,Point3D gps2) {
		this.gps1 = gps1;
		this.gps2 = gps2;
	}

	@Override
	public String toString() {
		return "Box [type=" + type + ", id=" + id + ", gps1=" + gps1 + ", gps2=" + gps2 + ", pix1=" + pix1 + ", pix2="
				+ pix2 + "]";
	}
	public Point3D getGps2() {
		return gps2;
	}

	public void setGps2(Point3D gps2) {
		this.gps2 = gps2;
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

	public Point3D getGps1() {
		return gps1;
	}

	public void setGps1(Point3D gps) {
		this.gps1 = gps;
	}

	public Pixel getPix1() {
		return pix1;
	}

	public void setPix1(Pixel pix) {
		this.pix1 = pix;
	}


	public Pixel getPix2() {
		return pix2;
	}


	public void setPix2(Pixel pix2) {
		this.pix2 = pix2;
	}



}
