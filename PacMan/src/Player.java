import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Grab the pellets as fast as you can!
 **/
class ListBots {
	static ArrayList<Bot> listBots = new ArrayList<>();

	public ListBots(ArrayList<Bot> listBots) {
		ListBots.listBots = listBots;
	}

	public ListBots() {

	}

	public ArrayList<Bot> getListBots() {
		return listBots;
	}

	public void setListBots(ArrayList<Bot> listBots) {
		ListBots.listBots = listBots;
	}

	public static Bot searchBot(int id) {
		Bot b;
		System.err.println("Id de recherche: " + id);
		for (int i = 0; i < listBots.size(); i++) {
			b = (Bot) listBots.get(i);
			System.err.println("Id du bot liste: " + b.getId());
			if (b.getId() == id) {
				System.err.println("Trouvé");
				return b;
			}
		}
		return new Bot();
	}
}

class ListPullets {
	ArrayList<Pullet> listPullet;

	public ListPullets(ArrayList<Pullet> listPullet) {
		this.listPullet = listPullet;
	}

	public ListPullets() {
	}

	public ArrayList<Pullet> getListPullet() {
		return listPullet;
	}

	public void setListPullet(ArrayList<Pullet> listPullet) {
		this.listPullet = listPullet;
	}
}

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
	int xm;
	int yb;
	int ym;
	int idb;
	Boolean dix;
	Boolean speed;
	Boolean collision;
	int speedTurnsLeft;
	int abilityCooldown;

	public Bot() {
		this.dix = false;
		this.speed = false;
		this.collision = false;
	}

	public int getX() {
		return xb;
	}

	public Boolean getDix() {
		return dix;
	}

	public Boolean getSpeed() {
		return speed;
	}

	public void setSpeed(Boolean speed) {
		this.speed = speed;
	}

	public int getXm() {
		return xm;
	}

	public void setXm(int xm) {
		this.xm = xm;
	}

	public int getYm() {
		return ym;
	}

	public void setYm(int ym) {
		this.ym = ym;
	}

	public Boolean getCollision() {
		return collision;
	}

	public void setCollision(Boolean collision) {
		this.collision = collision;
	}

	public int getSpeedTurnsLeft() {
		return speedTurnsLeft;
	}

	public void setSpeedTurnsLeft(int speedTurnsLeft) {
		this.speedTurnsLeft = speedTurnsLeft;
	}

	public int getAbilityCooldown() {
		return abilityCooldown;
	}

	public void setAbilityCooldown(int abilityCooldown) {
		this.abilityCooldown = abilityCooldown;
	}

	public void setDix(Boolean dix) {
		this.dix = dix;
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
	private static int tour = 0;

	public static String speedBot(Bot bot) {
		// System.err.println("SPEED: " + bot.getAbilityCooldown());
		if (bot.getAbilityCooldown() == 0) {
			bot.setSpeed(true);
			return "SPEED " + bot.getId() + " | ";
		}
		return "";
	}

	public static void collision(Bot bot) {
		if (tour != 1) {
			// System.err.println("Test de collision");
			if (bot.getX() == bot.getXm() && bot.getY() == bot.getYm()) {
				bot.setCollision(true);
			}
		}
		// System.err.println("Ancien X: " + bot.getXm() + " nouveau: " + bot.getX());
		// System.err.println("Ancien Y: " + bot.getYm() + " nouveau: " + bot.getY());
		bot.setXm(bot.getX());
		bot.setYm(bot.getY());
		// System.err.println("Bot: " + bot.getId() + " collision: " +
		// bot.getCollision());
		tour++;
	}

	public String pulletTen(ListPullets pullets, ListBots bots) {
		String move = "";

		// System.err.println("fonction: " + tour);
		// System.err.println("MOVE: " + move);
		ArrayList<Bot> listeBots = bots.getListBots();
		ArrayList<Pullet> listePullets = pullets.getListPullet();
		for (Bot b : listeBots) {
			System.err.println("Bot n°" + b.getId());
			b.setSpeed(false);
			b.setDix(false);

			Player.collision(b);
			System.err.println("Collision: " + b.getCollision());

			if (b.getCollision() == false) {
				move += Player.speedBot(b);

				int sum = 0;
				for (Pullet nbrTen : listePullets) {
					if (nbrTen.getValue() == 10) {
						sum++;
					}
				}
				if (sum != 0 && b.getSpeed() == false) {

					move += Player.distanceTen(pullets, b);
					b.setDix(true);
				}
				if (b.getDix() == false && b.getSpeed() == false) {
					move += Player.distance(pullets, b);
				}
				// System.err.println("Vers un speed :" + b.getSpeed());
				// System.err.println("Vers un dix :" + b.getDix());
			} else {
				move += Player.distanceLoin(pullets, b);
			}
		}
		return move;
	}

	public static String distanceTen(ListPullets pullets, Bot bot) {
		int xb = bot.getX();
		int yb = bot.getY();
		int d = 100;
		Pullet pullet = new Pullet();
		ArrayList<Pullet> listePullet = pullets.getListPullet();
		for (Pullet p : pullets.listPullet) {
			if (p.getValue() == 10 && !p.isUse()) {
				int xp = p.getX();
				int yp = p.getY();
				int dis = (int) Math.sqrt((xb - xp) * (xb - xp) + (yb - yp) * (yb - yp));
				if (dis < d) {
					d = dis;
					pullet.setValue(p.getValue());
					pullet.setX(p.getX());
					pullet.setY(p.getY());
				}
			}
		}
		for (Pullet pul : listePullet) {
			if (pul.getX() == pullet.getX() && pul.getY() == pullet.getY()) {
				pullets.getListPullet().remove(pul);
				// System.err.println("remove done: " + pul);
				break;
			}
		}
		// System.err.println("Fin d''un remove");
		String move = "MOVE " + bot.getId() + " " + pullet.getX() + " " + pullet.getY() + "|";
		return move;
	}

	public static String distance(ListPullets pullets, Bot bot) {
		int xb = bot.getX();
		int yb = bot.getY();
		int d = 99999;
		ArrayList<Pullet> listePullet = pullets.getListPullet();
		Pullet pullet = new Pullet();

		for (Pullet p : pullets.listPullet) {
			if (!p.isUse()) {
				int xp = p.getX();
				int yp = p.getY();
				int dis = (int) Math.sqrt((xb - xp) * (xb - xp) + (yb - yp) * (yb - yp));
				if (dis < d) {
					d = dis;
					pullet.setValue(p.getValue());
					pullet.setX(p.getX());
					pullet.setY(p.getY());
				}
			}
		}
		for (Pullet pul : listePullet) {
			if (pul.getX() == pullet.getX() && pul.getY() == pullet.getY()) {
				pullets.getListPullet().remove(pul);
				// System.err.println("remove done: " + pul);
				break;
			}
		}
		String move = "MOVE " + bot.getId() + " " + pullet.getX() + " " + pullet.getY() + "|";
		return move;
	}

	public static String distanceLoin(ListPullets pullets, Bot bot) {
		int xb = bot.getX();
		int yb = bot.getY();
		int d = 0;
		ArrayList<Pullet> listePullet = pullets.getListPullet();
		Pullet pullet = new Pullet();

		for (Pullet p : pullets.listPullet) {
			if (!p.isUse()) {
				int xp = p.getX();
				int yp = p.getY();
				int dis = (int) Math.sqrt((xb - xp) * (xb - xp) + (yb - yp) * (yb - yp));
				if (dis > d) {
					d = dis;
					pullet.setValue(p.getValue());
					pullet.setX(p.getX());
					pullet.setY(p.getY());
				}
			}
		}
		for (Pullet pul : listePullet) {
			if (pul.getX() == pullet.getX() && pul.getY() == pullet.getY()) {
				pullets.getListPullet().remove(pul);
				// System.err.println("remove done: " + pul);
				break;
			}
		}
		String move = "MOVE " + bot.getId() + " " + pullet.getX() + " " + pullet.getY() + "|";
		return move;
	}

	public void move(String move) {
		System.out.println(move); // MOVE <pacId> <x> <y>
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		Pullet pullet;
		ListPullets listPullets = new ListPullets();
		Bot bot;
		ListBots listBots = new ListBots();
		Player player = new Player();

		int turn = 0;
		int turnMoins = 0;

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
			ArrayList<Bot> listBot = new ArrayList<Bot>();
			for (int i = 0; i < visiblePacCount; i++) {
				int pacId = in.nextInt(); // pac number (unique within a team)
				boolean mine = in.nextInt() != 0; // true if this pac is yours
				int x = in.nextInt(); // position in the grid
				int y = in.nextInt(); // position in the grid
				String typeId = in.next(); // unused in wood leagues
				int speedTurnsLeft = in.nextInt(); // unused in wood leagues
				int abilityCooldown = in.nextInt(); // unused in wood leagues
				if (mine == true) {
					if (turn == 0) {
						bot = new Bot();
						bot.setX(x);
						bot.setY(y);
						bot.setId(pacId);
						bot.setAbilityCooldown(abilityCooldown);
						listBot.add(bot);
						System.err.println("bot new: " + bot.getId());
					} else {
						bot = ListBots.searchBot(pacId);
						bot.setX(x);
						bot.setY(y);
						System.err.println("bot deja: " + bot.getId());
					}
					// System.err.println("Ancien X: " + bot.getXm() + " nouveau: " + bot.getX());
					// System.err.println("Ancien Y: " + bot.getYm() + " nouveau: " + bot.getY());
				}
			}
			listBots.setListBots(listBot);

			int visiblePelletCount = in.nextInt(); // all pellets in sight
			ArrayList<Pullet> listPullet = new ArrayList<Pullet>();
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

			listPullets.setListPullet(listPullet);

			// Sysout du nombre de tours
			turn++;
			System.err.println("Tours = " + turn);
			//System.err.println("Tours - 1 = " + turnMoins);
            for (Bot list: listBot) {
                System.err.println("Bot de la liste: " + list.getId());
            }
			if (turnMoins != turn) {
				turnMoins = turn;
				// Action à faire
                System.err.println("action");
                
                
				String move = player.pulletTen(listPullets, listBots);
				player.move(move);
			}

		}
	}
}