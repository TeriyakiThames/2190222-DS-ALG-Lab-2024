
public class File {
	private int id;
	private String name;
	private String owner;
	private long size;
	
	public File(int id, String name, String owner, long size) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
}
