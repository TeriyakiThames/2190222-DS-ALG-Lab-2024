package logic;
import java.util.ArrayList;

public class Region {
	private String name;
	private ArrayList<Player> playerList;
	private ArrayList<Quest> questList;
	
	public Region(String name) {
		setName(name);
		this.playerList = new ArrayList<Player>();
		this.questList = new ArrayList<Quest>();
	}
	
	public int getPlayerCount() {
		return playerList.size();
	}
	
	public double getRegionRank() {
		double rank = 0.0;
		double players = 0.0;
		for (Player p:playerList) {
			rank += p.getRank();
			players += 1;
		}
		return (double) Math.round((rank/players)*100)/100;
	}
	
	public ArrayList<Quest> getAvailableQuests(Player viewer) {
		ArrayList<Quest> availableQuests = new ArrayList<Quest>();
		for (Quest q:questList) {
			if (q.getStatus().equals(Status.AVAILABLE) && !q.getAuthor().equals(viewer)) {
				availableQuests.add(q);				
			}
		}
		return availableQuests;
	}
	
	public void addPlayerToRegion (Player p) {
		playerList.add(p);
	}
	
	public void addQuestToRegion (Quest q) {
		questList.add(q);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isBlank() || name == " ") {
			this.name = "Nowhere";
			return;
		}
		this.name = name;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Quest> getQuestList() {
		return questList;
	}

	public void setQuestList(ArrayList<Quest> questList) {
		this.questList = questList;
	}
	
	
	
	
	
}