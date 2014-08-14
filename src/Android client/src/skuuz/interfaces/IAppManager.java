package skuuz.interfaces;

import java.io.UnsupportedEncodingException;


public interface IAppManager {
	
	public String getUsername();
	public String sendMessage(String username,String tousername, String message) throws UnsupportedEncodingException;
	public String authenticateUser(String usernameText, String passwordText) throws UnsupportedEncodingException; 
	public void messageReceived(String username, String message);
//	public void setUserKey(String value);
	public boolean isNetworkConnected();
	public boolean isUserAuthenticated();
	public String getLastRawFriendList();
	public void exit();
	public String updatelocation(String user,String longitude,String latitude);
	public String signUpUser(String usernameText, String passwordText,String name,String phone,String Gender, String email,String langitude,String latitude);
	public String addNewFriendRequest(String friendUsername);
	public String sendFriendsReqsResponse(String approvedFriendNames,
			String discardedFriendNames);

	
}
