package logic;
import java.util.ArrayList;

public class Database {
	private ArrayList<Player> playerList;
	private ArrayList<Region> regionList;
	
	public Database() {
		this.playerList = new ArrayList<Player>();
		this.regionList = new ArrayList<Region>();
	}
	
	public Database(ArrayList<Player> playerList, ArrayList<Region> regionList) {
		this.playerList = playerList;
		this.regionList = regionList;
	}

	public Player addPlayer(String name, Region region) throws Exception {
		for (Player p:playerList) {
			if (p.getName().equals(name)) {
				throw new Exception();
			}
		}
		Player newPlayer = new Player (name);
		playerList.add(newPlayer);
		region.addPlayerToRegion(newPlayer);
		return newPlayer;
	}
	
	public boolean addRegion (String name) {
		for (Region r:regionList) {
			if (r.getName().equals(name)) {
				return false;
			}
		}
		Region newRegion = new Region(name);
		regionList.add(newRegion);
		return true;
	}
	
	public Region getRegionByName (String name) {
		for (Region r:regionList) {
			if (r.getName().equals(name)) {
				return r;
			}
		}
		return null;
	}
	
	public void addQuest (Player author, Region region, String name, String description) {
		Quest newQuest = new Quest(author,region,name,description);
		region.addQuestToRegion(newQuest);
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(ArrayList<Region> regionList) {
		this.regionList = regionList;
	}
	
}