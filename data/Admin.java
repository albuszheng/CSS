package data;

public class Admin extends User {

	/**
	 * 
	 */
	private static Admin instance = new Admin("admin", "admin");

	private Admin(String id, String password) {
		super(id, password);
	}

	public static Admin getInstance() {
		if (instance == null) {
			instance = new Admin("admin", "admin");
		}
		return instance;
	}

}
