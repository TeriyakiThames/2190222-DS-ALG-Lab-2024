package logic;

import java.util.ArrayList;

public class Server {
	private String name;
	private User owner;
	private ArrayList<Channel> channelList;
	private ArrayList<User> memberList;

	public Server(String name, User owner, TemplateType template) {
		this.owner = owner;
		this.memberList = new ArrayList<User>();
		this.channelList = new ArrayList<Channel>();

		memberList.add(owner);
		owner.addJoinedServersList(this);
		setName(name);

		switch (template) {
			case BASIC:
				Channel addGeneral = new Channel("general");
				channelList.add(addGeneral);
				break;
			case GAMING:
				Channel addGaming = new Channel("gaming");
				channelList.add(addGaming);
				break;
			case STUDY:
				Channel addStudy = new Channel("homework-help");
				channelList.add(addStudy);
				break;
		}
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public ArrayList<Channel> getChannelList() {
		return channelList;
	}

	public void setChannelList(ArrayList<Channel> channelList) {
		this.channelList = channelList;
	}

	public ArrayList<User> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<User> memberList) {
		this.memberList = memberList;
	}

	public String getName() {
		return name;
	}

	public Channel addChannel(User user, String channelName) {
		if (owner.equals(user)) {
			Channel newChannel = new Channel(channelName);
			channelList.add(newChannel);
			return newChannel;
		}
		return null;
	}

	public User addUser(User user) {
		if (memberList.contains(user)) {
			return null;
		}
		memberList.add(user);
		user.addJoinedServersList(this);
		return user;
	}

	public boolean kickUser(User kicker, User kicked) throws Exception {
		boolean kickerIsOwner = kicker.equals(owner);
		boolean kickedInMember = false;
		if (memberList.contains(kicked)) {
			kickedInMember = true;
		}

		if (!kickerIsOwner) {
			throw new Exception();
		} else if (kickerIsOwner && (kicker.equals(kicked) || kickedInMember)) {
			return false;
		} else {
			kicked.getJoinedServersList().remove(this);
			memberList.remove(kicked);
			return true;
		}
	}

	public void setName(String name) {
		if (name.isBlank()) {
			name = owner + " home";
			return;
		}
		this.name = name;
	}

	public boolean isMemberInServer(User user) {
		if (memberList.contains(user)) {
			return true;
		} else {
			return false;
		}
	}
}