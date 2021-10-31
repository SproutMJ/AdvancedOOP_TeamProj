package entity;

public class User {
	private int id;
	private String name;
	private String userId;
	private String password;
	private int level;
	
	public User(int id, String name, String userId, String password, int level) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public int getLevel() {
		return level;
	}
}
