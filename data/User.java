package data;

public abstract class User {

	/**
	 * 
	 */

	protected String userId;
	protected String password;
	protected boolean isLogin=false;

	public User() {

	}

	public User(String id, String password) {
		this.password = password;
		this.userId = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLoginStatus(boolean status) {
		this.isLogin = status;
	}

	public boolean getLoginStatus() {
		return this.isLogin;
	}
}
