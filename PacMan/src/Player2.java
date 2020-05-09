import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Grab the pellets as fast as you can!
 **/
class Pullet {
	int xp;
	int yp;
	int valuep;
	boolean use;

	public Pullet() {
		this.use = false;
	}

	public int getX() {
		return xp;
	}

	public int getY() {
		return yp;
	}

	public boolean isUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

	public int getValue() {
		return valuep;
	}

	public void setX(int x) {
		this.xp = x;
	}

	public void setY(int y) {
		this.yp = y;
	}

	public void setValue(int value) {
		this.valuep = value;
	}
}

class Bot {
	int xb;
	int yb;
	int idb;

	public Bot() {

	}

	public int getX() {
		return xb;
	}

	public int getY() {
		return yb;
	}

	public int getId() {
		return idb;
	}

	public void setX(int x) {
		this.xb = x;
	}

	public void setY(int y) {
		this.yb = y;
	}

	public void setId(int id) {
		this.idb = id;
	}
}

class Player {

	public String pulletTen(ArrayList<Pullet> listP, ArrayList<Bot> listB) {
		String move = "";
		for (Bot b : listB) {
			boolean ordre = false;
			int sum = 0;
			for (Pullet nbrTen : listP) {
				if (nbrTen.getValue() == 10) {
					sum++;
				}
			}
			if (sum != 0) {
				move += Player.distanceTen(listP, b);
			} else {
				move += Player.distance(listP, b);
			}
		}
		return move;
	}

	public static String distanceTen(ArrayList<Pullet> listP, Bot bot) {
		ArrayList<Pullet> distanceTen = new ArrayList();
		Pullet pullet = new Pullet();
		for (Pullet p : listP) {
			if (p.getValue() == 10) {
				pullet.setX(p.getX());
				pullet.setY(p.getY());
				pullet.setValue(p.getValue());
				distanceTen.add(pullet);
			}
		}
		String move = Player.distance(distanceTen, bot);
		return move;
	}

	public static String distance(ArrayList<Pullet> listP, Bot bot) {
		int xb = bot.getX();
		int yb = bot.getY();
		int d = 100;
		Pullet pullet2 = new Pullet();

		for (Pullet p : listP) {
			if (!p.isUse()) {
				int xp = p.getX();
				int yp = p.getY();
				int dis = (int) Math.sqrt((xb - xp) * (xb - xp) + (yb - yp) * (yb - yp));
				if (dis < d) {
					d = dis;
					pullet2.setValue(p.getValue());
					pullet2.setX(p.getX());
					pullet2.setY(p.getY());
				}
			}
		}
		pullet2.setUse(true);
		String move = "MOVE " + bot.getId() + " " + pullet2.getX() + " " + pullet2.getY() + "|";
		return move;
	}

	public static void updatePullet() {

	}

	public void move(String move) {
		System.out.println(move); // MOVE <pacId> <x> <y>
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		Pullet pullet;
		Bot bot;
		Player player = new Player();

		int width = in.nextInt(); // size of the grid
		int height = in.nextInt(); // top left corner is (x=0, y=0)
		if (in.hasNextLine()) {
			in.nextLine();
		}
		for (int i = 0; i < height; i++) {
			String row = in.nextLine(); // one line of the grid: space " " is floor, pound "#" is wall
		}

		// game loop
		while (true) {
			int myScore = in.nextInt();
			int opponentScore = in.nextInt();
			int visiblePacCount = in.nextInt(); // all your pacs and enemy pacs in sight
			ArrayList<Bot> listBot = new ArrayList();
			for (int i = 0; i < visiblePacCount; i++) {
				int pacId = in.nextInt(); // pac number (unique within a team)
				boolean mine = in.nextInt() != 0; // true if this pac is yours
				int x = in.nextInt(); // position in the grid
				int y = in.nextInt(); // position in the grid
				String typeId = in.next(); // unused in wood leagues
				int speedTurnsLeft = in.nextInt(); // unused in wood leagues
				int abilityCooldown = in.nextInt(); // unused in wood leagues
				if (mine == true) {
					bot = new Bot();
					bot.setX(x);
					bot.setY(y);
					bot.setId(pacId);
					listBot.add(bot);
				}

			}
			int visiblePelletCount = in.nextInt(); // all pellets in sight
			ArrayList<Pullet> listPullet = new ArrayList();
			for (int i = 0; i < visiblePelletCount; i++) {
				pullet = new Pullet();
				int x = in.nextInt();
				pullet.setX(x);
				int y = in.nextInt();
				pullet.setY(y);
				int value = in.nextInt(); // amount of points this pellet is worth
				pullet.setValue(value);
				listPullet.add(pullet);
			}

			// Write an action using System.out.println()
			// To debug: System.err.println("Debug messages...");
			player.move(player.pulletTen(listPullet, listBot));

		}
	}
}