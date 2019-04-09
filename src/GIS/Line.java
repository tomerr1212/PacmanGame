package GIS;

import Geom.Pixel;
/**
 * 
 * @author Ortal, Tomer and Avichay
 * @note this class represent a line on the board game
 * line created for pacman and it's way to a fruit
 * using pixels for the size of the image on the board game
 *
 */
public class Line {
	private Pixel start;
	private Pixel end;

	public Line() {
		start = new Pixel();
		end = new Pixel();
	}

	public Pixel getStart() {
		return start;
	}

	public void setStart(Pixel start) {
		this.start = start;
	}

	public Pixel getEnd() {
		return end;
	}

	public void setEnd(Pixel end) {
		this.end = end;
	}

	public Line(Pixel start, Pixel end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Line [start=" + start + ", end=" + end + "]";
	}

}
