package Threads;

import GIS.Game;
import Algo.Direction;
import GUI.MyFrame;
import Robot.Play;

/**
 * @author Ortal, Tomer and Avichay
 * this class extends "Thread" to be able to 
 * move on the same time pacmans and creating them paths and etc. 
 */
public class MyThread extends Thread {

	private Game game;
	private MyFrame mf;
	private Play play1;
	private double azimuth;
	private boolean mouse;

	/**
	 * 
	 * @param mf (MyFrame)
	 * @param game
	 * @param play1 (the server)
	 * 
	 * this constructor using the frame the game already existing.
	 */
	public MyThread (MyFrame mf,Game game,Play play1) {
		super();//we are extending "Thread"
		this.mf = mf;
		this.game = game;
		this.play1=play1;
	}

	public double getAzimuth() {
		return azimuth;
	}


	public void setAzimuth(double azimuth) {
		this.azimuth = azimuth;
	}

	public boolean isMouse() {
		return mouse;
	}

	public void setMouse(boolean mouse) {
		this.mouse = mouse;
	}

	/**
	 * run starts the game on the board when the user click/choose "run" option from the menu.
	 * using to find the shortest and the fastest path for each pacman on the board 
	 * and moves then on the same time.
	 */

	public void run() {

		play1.start();
		Direction dir = new Direction();
		double teta =0;

		while(play1.isRuning()) {

			if(mouse == true) { //if the game works by mouse click on the frame
				play1.rotate(getAzimuth());
			}
			else if(mouse ==false) { //if the game works automatically
				teta =dir.direction(game);
				play1.rotate(teta);
			}
			game.CleanBoard();
			game.ReadBoard(play1.getBoard());

			mf.repaint();

			try {
				sleep(50);

			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
		mf.repaint();
		System.out.println("GAME OVER !!!");
	}
}