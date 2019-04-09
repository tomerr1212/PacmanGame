package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {
	final int r_earth=6371000;
	/**
	 * https://www.omnicalculator.com/other/azimuth#how-to-calculate-the-azimuth-from-latitude-and-longitude
	 *@author Ortal and Tomer
	 */

	/**
	 * @param gps(lat,lon,alt) , local_vector_in_meter(x,y,z)
	 * @returns the target destination after advancing in meters from the start point
	 */
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {	
		double m  = local_vector_in_meter.x()/r_earth;
		double new_latitude = gps.x() + (m * 180/Math.PI);
		double n =(local_vector_in_meter.y()/(r_earth*Math.cos(gps.x()*Math.PI/180)));
		double new_longitude = gps.y()+(n * 180/Math.PI);
		return new Point3D(new_latitude,new_longitude,gps.z()+local_vector_in_meter.z());	
	}
	/**
	 * @param gps0 ,gps1
	 * @return the distance in meters between two given point on earth
	 */
	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		double LonNorm =Math.cos(gps0.x()*Math.PI/180);
		double a = Math.pow((Math.sin((gps1.x()-gps0.x())*Math.PI/180)*r_earth),2);
		double b = Math.pow((Math.sin((gps1.y()-gps0.y())*Math.PI/180)*LonNorm*r_earth),2);
		return Math.sqrt(a+b);	  
	}

	/**
	 *@param gps0,gps1 - (lat,lon,alt)
	 *@returns Vector between two points on earth
	 */
	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		double LonNorm =Math.cos(gps0.x()*Math.PI/180);
		double ansX =Math.sin((gps1.x()-gps0.x())*Math.PI/180)*r_earth;
		double ansY =Math.sin((gps1.y()-gps0.y())*Math.PI/180)*LonNorm*r_earth;
		double ansZ =(gps1.z()-gps0.z());
		return new Point3D(ansX,ansY,ansZ);
	}
	/**
	 *computes the azimuth ,elevation and destination between two points on earth
	 *@returns an array [azimuth,elevation,destination]
	 *@param gps0 , gps1
	 */
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {

		double g0r_x=Math.toRadians(gps0.x());
		double g0r_y=Math.toRadians(gps0.y());
		double g1r_x=Math.toRadians(gps1.x());
		double g1r_y=Math.toRadians(gps1.y());

		double y=Math.sin(g1r_y-g0r_y)*Math.cos(g1r_x);
		double x=Math.cos(g0r_x)*Math.sin(g1r_x)-(Math.sin(g0r_x)*Math.cos(g1r_x)*Math.cos(g0r_y-g0r_y));
		double teta=Math.atan2(y, x);
		teta = Math.toDegrees(teta);
		if(teta<0) {
			teta = teta+360;
		}
		double distance = distance3d(gps0, gps1);
		double elevation = Math.asin((gps1.z()-gps0.z())/distance);
		elevation =Math.toDegrees(elevation);
		double [] arry= {teta,elevation,distance};

		return arry;
	}
	
	
	/**
	 *@param p point3D
	 *@return true if the coordinates of a given point on earth are valid
	 *checks if point p ([-180,180],[-90,90],[-450,10000])
	 */
	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		if(p.x() <-180 || p.x()>180) {
			if(p.x()<-180) {
				System.out.println("You went far west");
				return false;
			}
			else {
				System.out.println("You went far east");
				return false;
			}
		}
		else if(p.y() <-90 || p.y()>90) {
			if(p.y()<-90) {
				System.out.println("You went far south");
			}
			else { System.out.println("You went far north");
			return false;
			}
		}
		else if(p.z() <-450 || p.z()>10000) {
			if(p.z()<-450) {
				System.out.println("You went below the dead sea");
				return false;
			}
			else {
				System.out.println("You went to space");
				return false;
			}
		}
		return true;
	}

}