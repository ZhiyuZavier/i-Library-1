package control;

import user.User;

public class LoginUserManager {

	private static LoginUserManager loginUserManager;
	
	private User currentUser;

	private LoginUserManager() {
	}

	synchronized public static final LoginUserManager getInstance() {

		if (loginUserManager == null)
			loginUserManager = new LoginUserManager();

		return loginUserManager;
	}
	
	
	/**
	 * return current login user ,
	 * return null if no user login
	 * @return
	 */
	public User getCurrentUser(){
		return currentUser;
		
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	

}
