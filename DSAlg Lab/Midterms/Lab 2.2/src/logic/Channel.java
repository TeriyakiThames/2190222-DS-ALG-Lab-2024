package logic;
import java.util.ArrayList;

public class Channel {
	private String name;
	private ArrayList<Message> messageList;
	
	public Channel(String name) {
		setName(name);
		this.messageList = new ArrayList<Message>();
	}
	
	public void addMessage(Message message) {
		messageList.add(message);
	}
	
	public void setName(String name) {
		if (name.isBlank()) {
			this.name = "off-topic";
			return;
		}
		this.name = name;
	}
	
	public int getMessageCount() {
		return messageList.size();
	}

	public ArrayList<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(ArrayList<Message> messageList) {
		this.messageList = messageList;
	}

	public String getName() {
		return name;
	}
	
	
	
}