import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Grab the pellets as fast as you can!
 **/

class ListBotsEnnemi {
	static ArrayList<Bot> listBotsEnnemi = new ArrayList<>();

	public ListBotsEnnemi(ArrayList<Bot> listBotsEnnemi) {
		ListBotsEnnemi.listBotsEnnemi = listBotsEnnemi;
	}

	public ListBotsEnnemi() {

	}

	public ArrayList<Bot> getListBotsEnnemi() {
		return listBotsEnnemi;
	}

	public static void setListBotsEnnemi(ArrayList<Bot> listBotsEnnemi) {
		ListBotsEnnemi.listBotsEnnemi = listBotsEnnemi;
	}

	public static Bot searchBot(int id) {
		Bot b;
		// System.err.println("Id de recherche: " + id);
		for (int i = 0; i < listBotsEnnemi.size(); i++) {
			b = (Bot) listBotsEnnemi.get(i);
			// System.err.println("Id du bot liste: " + b.getId());
			if (b.getId() == id) {
				// System.err.println("Trouvé");
				return b;
			}
		}
		return new Bot();
	}
}

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

	public static void setListBots(ArrayList<Bot> listBots) {
		ListBots.listBots = listBots;
	}

	public static Bot searchBot(int id) {
		Bot b;
		// System.err.println("Id de recherche: " + id);
		for (int i = 0; i < listBots.size(); i++) {
			b = (Bot) listBots.get(i);
			// System.err.println("Id du bot liste: " + b.getId());
			if (b.getId() == id) {
				// System.err.println("Trouvé");
				return b;
			}
		}
		return new Bot();
	}
}

class ListPullets {
	static ArrayList<Pullet> listPullet = new ArrayList<>();

	public ArrayList<Pullet> getListPullet() {
		return listPullet;
	}

	public void setListPullet(ArrayList<Pullet> listPullet) {
		ListPullets.listPullet = listPullet;
	}

	public static Pullet searchPullet(int x, int y) {
		Pullet p;
		for (int i = 0; i < listPullet.size(); i++) {
			p = (Pullet) listPullet.get(i);
			if (p.getX() == x && p.getY() == y) {
				return p;
			}
		}
		return new Pullet();
	}
}

class ListPulletsVisible {
	static ArrayList<Pullet> listPulletsVisible = new ArrayList<>();

	public static ArrayList<Pullet> getListPulletsVisible() {
		return listPulletsVisible;
	}

	public static void setListPulletsVisible(ArrayList<Pullet> listPulletsVisible) {
		ListPulletsVisible.listPulletsVisible = listPulletsVisible;
	}

	public static Pullet searchPulletVisible(int x, int y) {
		Pullet p;
		for (int i = 0; i < listPulletsVisible.size(); i++) {
			p = (Pullet) listPulletsVisible.get(i);
			if (p.getX() == x && p.getY() == y) {
				return p;
			}
		}
		return new Pullet();
	}
}

class Pullet {
	int xp;
	int yp;
	int valuep;
	boolean use;

	public Pullet(int x, int y) {
		this.xp = x;
		this.yp = y;
		this.use = false;
	}

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
	int xc;
	int yc;
	int idb;
	int speedTurnsLeft;
	int abilityCooldown;
	String typeId;
	Boolean dix;
	Boolean speed;
	Boolean speedCurrent;
	Boolean collision;
	Boolean vivant;

	public Bot(int xb, int yb, int idb, int speedTurnsLeft, int abilityCooldown, String typeId) {
		this.xb = xb;
		this.yb = yb;
		this.idb = idb;
		this.speedTurnsLeft = speedTurnsLeft;
		this.abilityCooldown = abilityCooldown;
		this.typeId = typeId;
		this.dix = false;
		this.speed = false;
		this.collision = false;
		this.speedCurrent = false;
		this.vivant = true;
	}

	public Bot() {
		this.dix = false;
		this.speed = false;
		this.collision = false;
		this.speedCurrent = false;
		this.vivant = true;
	}

	public int getXc() {
		return xc;
	}

	public void setXc(int xc) {
		this.xc = xc;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public int getYc() {
		return yc;
	}

	public void setYc(int yc) {
		this.yc = yc;
	}

	public int getX() {
		return xb;
	}

	public Boolean getSpeedCurrent() {
		return speedCurrent;
	}

	public void setSpeedCurrent(Boolean speedCurrent) {
		this.speedCurrent = speedCurrent;
	}

	public Boolean getVivant() {
		return vivant;
	}

	public void setVivant(Boolean vivant) {
		this.vivant = vivant;
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

	public String pulletTen(ListPullets pullets, ListBots bots) {
		String move = "";

		// System.err.println("fonction: " + tour);
		// System.err.println("MOVE: " + move);
		ArrayList<Bot> listeBots = bots.getListBots();
		ArrayList<Pullet> listePullets = pullets.getListPullet();

		for (Bot b : listeBots) {
			if (b.getVivant()) {
				System.err.println("Bot n°" + b.getId());
				b.setSpeed(false);
				b.setDix(false);

				if (b.getSpeedTurnsLeft() == 0) {
					Player.collision(b);
				}

				// System.err.println("Collision: " + b.getCollision());
				if (b.getCollision() == false) {
					// move += Player.speedBot(b);

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
				b.setVivant(false);
			}
		}
		return move;
	}

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
			} else {
				bot.setCollision(false);
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

	public static String distanceTen(ListPullets pullets, Bot bot) {
		int xb = bot.getX();
		int yb = bot.getY();
		int d = 100;
		int dis = 0;
		Pullet pullet = new Pullet();
		for (Pullet p : ListPullets.listPullet) {
			if (p.getValue() == 10 && !p.isUse()) {
				int xp = p.getX();
				int yp = p.getY();
				dis = (int) Math.sqrt((xb - xp) * (xb - xp) + (yb - yp) * (yb - yp));
				if (dis < d) {
					d = dis;
					bot.setXc(xp);
					bot.setYc(yb);
				}
			}
		}
		System.err.println("distance: " + dis);
		pullet = ListPullets.searchPullet(bot.getXc(), bot.getYc());
		pullet.setUse(true);
		// System.err.println("Fin d''un remove");
		String move = "MOVE " + bot.getId() + " " + bot.getXc() + " " + bot.getYc() + "|";
		return move;
	}

	public static String distance(ListPullets pullets, Bot bot) {
		int xb = bot.getX();
		int yb = bot.getY();
		int d = 99999;
		int dis = 0;
		Pullet pullet = new Pullet();
		for (Pullet p : ListPullets.listPullet) {
			if (!p.isUse()) {
				int xp = p.getX();
				int yp = p.getY();
				dis = (int) Math.sqrt((xb - xp) * (xb - xp) + (yb - yp) * (yb - yp));
				if (dis < d) {
					d = dis;
					bot.setXc(xb);
					bot.setYc(yb);
				}
			}
		}
		System.err.println("distance: " + dis);
		pullet = ListPullets.searchPullet(bot.getXc(), bot.getYc());
		pullet.setUse(true);
		String move = "MOVE " + bot.getId() + " " + bot.getXc() + " " + bot.getYc() + "|";
		return move;
	}

	public static String distanceLoin(ListPullets pullets, Bot bot) {
		System.err.println("Distance Loin");
		int xb = bot.getX();
		int yb = bot.getY();
		int d = 0;
		int dis = 0;
		Pullet pullet = new Pullet();

		for (Pullet p : ListPullets.listPullet) {
			if (!p.isUse()) {
				int xp = p.getX();
				int yp = p.getY();
				dis = (int) Math.sqrt((xb - xp) * (xb - xp) + (yb - yp) * (yb - yp));
				if (dis > d) {
					d = dis;
					bot.setXc(bot.getX() - 1);
					bot.setYc(bot.getY() - 1);
				}
			}
		}
		System.err.println("distance: " + dis);
		pullet = ListPullets.searchPullet(bot.getXc(), bot.getYc());
		pullet.setUse(true);
		String move = "MOVE " + bot.getId() + " " + bot.getXc() + " " + bot.getYc() + "|";
		return move;
	}

	public void move(String move) {
		System.out.println(move); // MOVE <pacId> <x> <y>
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		Pullet pullet;
		Pullet pullet2;
		ListPullets listPullets = new ListPullets();

		Bot bot;
		ListBots listBots = new ListBots();
		ListBotsEnnemi listBotsEnnemi = new ListBotsEnnemi();

		Player player = new Player();

		int turn = 0;

		int width = in.nextInt(); // size of the grid
		// System.err.println("width: " + width);
		int height = in.nextInt(); // top left corner is (x=0, y=0)
		if (in.hasNextLine()) {
			in.nextLine();
		}

		ArrayList<Pullet> listPullet2 = new ArrayList<Pullet>();
		for (int i = 0; i < height; i++) {
			String row = in.nextLine(); // one line of the grid: space " " is floor, pound "#" is wall
			for (int j = 0; j < width; j++) {
				char c = row.charAt(j);
				// System.err.println("char: " + j + " / " + c );
				if (c != '#') {
					pullet2 = new Pullet(i, j);
					listPullet2.add(pullet2);
					// System.err.println(listPullet2.size());
				}
			}
			// System.err.println(listPulletsVisibles.getListPullet().toString());
			System.err.println(row);
		}
		ListPulletsVisible.setListPulletsVisible(listPullet2);
		System.err.println("liste totate class: " + ListPulletsVisible.getListPulletsVisible().size());

		// game loop
		while (true) {
			int myScore = in.nextInt();
			int opponentScore = in.nextInt();
			int visiblePacCount = in.nextInt(); // all your pacs and enemy pacs in sight
			ArrayList<Bot> listBot = new ArrayList<Bot>();
			ArrayList<Bot> listBotEnnemi = new ArrayList<Bot>();
			for (int i = 0; i < visiblePacCount; i++) {
				int pacId = in.nextInt(); // pac number (unique within a team)
				boolean mine = in.nextInt() != 0; // true if this pac is yours
				System.err.println(mine);
				int x = in.nextInt(); // position in the grid
				int y = in.nextInt(); // position in the grid
				String typeId = in.next(); // unused in wood leagues
				int speedTurnsLeft = in.nextInt(); // unused in wood leagues
				int abilityCooldown = in.nextInt(); // unused in wood leagues
				if (turn == 0 && mine == true) {
					bot = new Bot(x, y, pacId, speedTurnsLeft, abilityCooldown, typeId);
					listBot.add(bot);
					// System.err.println("bot new: " + bot.getId());
					ListBots.setListBots(listBot);
				} else if (turn != 0 && mine == true) {
					bot = ListBots.searchBot(pacId);
					bot.setX(x);
					bot.setY(y);
					bot.setVivant(true);
				} else if (turn == 0 && mine == false) {
					bot = new Bot(x, y, pacId, speedTurnsLeft, abilityCooldown, typeId);
					listBotEnnemi.add(bot);
					// System.err.println("bot new: " + bot.getId());
					ListBotsEnnemi.setListBotsEnnemi(listBotEnnemi);
				} else if (turn != 0 && mine == true) {
					bot = ListBotsEnnemi.searchBot(pacId);
					bot.setX(x);
					bot.setY(y);
					bot.setVivant(true);
				}
				// System.err.println("Ancien X: " + bot.getXm() + " nouveau: " + bot.getX());
				// System.err.println("Ancien Y: " + bot.getYm() + " nouveau: " + bot.getY());
			}

			for (Bot bo : ListBots.listBots) {
				System.err.println("Bot ami:" + bo.getId());
			}
			for (Bot bo : ListBotsEnnemi.listBotsEnnemi) {
				System.err.println("Bot ennemi:" + bo.getId());
			}

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
			System.err.println("Nombre de pullets visible: " + listPullets.getListPullet().size());

			// Sysout du nombre de tours
			turn++;
			System.err.println("Tours = " + turn);

			String move = player.pulletTen(listPullets, listBots);
			for (Pullet p : ListPullets.listPullet) {
				p.setUse(false);
			}
			player.move(move);
		}
	}
}