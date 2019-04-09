package GIS;

import java.util.ArrayList;

import Coords.MyCoords;
import Geom.Pixel;
import Geom.Point3D;

/**
 * @author Ortal, Tomer and Avichay
 * @note this class represent the basic calculation of coordinate on point3D and Pixels
 * convert each other and using also meters and distance.
 * to make sure the data will be represent real and clear.
 * 
 * got help from : 
 * //https://stackoverflow.com/questions/14329691/convert-latitude-longitude-point-to-a-pixels-x-y-on-mercator-projection?rq=1
	//https://stackoverflow.com/questions/35299786/draw-circle-on-jpanel-after-mouse-click/35300018
 */
public class Map {
	//private File image = new File("C:\\temp\\Ariel1.png");
	private int mapWidth = 1433;
	private int mapHeight = 642;
	private double west = 35.202574; 
	private double north = 32.106046;
	private double east = 35.212405;
	private double south = 32.101858;

	/**
	 * @param latitude and longitude
	 * function to convert from coordinate to pixel
	 * @return pixel
	 */
	public Pixel getXYfromLatLon(Point3D gps1) {
		double y = (mapHeight*gps1.x() - mapHeight*north)/(south-north);
		double x = (mapWidth*gps1.y() - mapWidth*west)/(east-west);
		return new Pixel(x,y);
	}

	/**
	 * @param latitude and longitude
	 * function to convert from pixel to coordinate
	 * @return coordinate
	 */
	public Point3D getLatLonfromXY(Pixel p) {
		double lat =((p.getY()*(south-north))/mapHeight)+north;
		double lon  = ((p.getX()*(east-west))/mapWidth)+west;
		return new Point3D(lat,lon);
	}

	/**
	 * @param latitude and longitude
	 * function to calculate angle between two pixels
	 * @return angle
	 */
	public double anglefrompixel(Pixel pixel0 ,Pixel pixel1) {
		Map m = new Map();
		Point3D p = m.getLatLonfromXY(pixel0) ;
		Point3D p2 = m.getLatLonfromXY(pixel1);
		MyCoords coord = new MyCoords();
		double angle = coord.azimuth_elevation_dist(p, p2)[0];
		return angle;
	}

	/**
	 * @param latitude and longitude
	 * function to calculate distance in meters between two pixels
	 * @return meters
	 */
	public double PixeldistanceInMeters(Pixel pixel0, Pixel pixel1) {
		Map m = new Map();
		Point3D p = m.getLatLonfromXY(pixel0) ;
		Point3D p2 = m.getLatLonfromXY(pixel1);
		MyCoords coord = new MyCoords();
		double  Pixeldistance = coord.distance3d(p, p2);
		return Pixeldistance;
	}

	public boolean CrossingALine(Pixel start,Pixel end,Pixel source,Pixel target) {
		double x1=source.getX();
		double y1=source.getY();
		double x2=target.getX();
		double y2=target.getY();
		double x3=start.getX();
		double y3=start.getY();
		double x4=end.getX();
		double y4=end.getY();

		double a = ((x4-x3)*(y1-y3)-(y4-y3)*(x1-x3))/((y4-y3)*(x2-x1)-(x4-x3)*(y2-y1));
		double b = ((x2-x1)*(y1-y3)-(y2-y1)*(x1-x3))/((y4-y3)*(x2-x1)-(x4-x3)*(y2-y1));

		if(a>0 && a<1 && b>0 && b<1) {
			return true;
		}		
		return false;
	}
	public boolean closeBoxVertexs(ArrayList<Box> boxes, Pixel source ,Pixel target) {
		ArrayList <Line> lines = new ArrayList<>();

		for(int i=0;i<boxes.size();i++) {
			lines.add(new Line(new Pixel(boxes.get(i).getPix1().getX(),boxes.get(i).getPix1().getY()),new Pixel(boxes.get(i).getPix2().getX(),boxes.get(i).getPix1().getY())));
			lines.add(new Line(new Pixel(boxes.get(i).getPix2().getX(),boxes.get(i).getPix2().getY()),new Pixel(boxes.get(i).getPix1().getX(),boxes.get(i).getPix2().getY())));
			lines.add(new Line(new Pixel(boxes.get(i).getPix1().getX(),boxes.get(i).getPix1().getY()),new Pixel(boxes.get(i).getPix1().getX(),boxes.get(i).getPix2().getY())));
			lines.add(new Line(new Pixel(boxes.get(i).getPix2().getX(),boxes.get(i).getPix2().getY()),new Pixel(boxes.get(i).getPix2().getX(),boxes.get(i).getPix1().getY())));
		}

		for (int i = 0; i < lines.size(); i++) {
			if(CrossingALine(lines.get(i).getStart(), lines.get(i).getEnd(), source, target)) {
				return true;
			}
		}
		return false;
	}
}