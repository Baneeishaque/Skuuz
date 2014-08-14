package skuuz.interfaces;
import skuuz.types.FriendInfo;
import skuuz.types.MessageInfo;


public interface IUpdateData {
	public void updateData(MessageInfo[] messages, FriendInfo[] friends, FriendInfo[] unApprovedFriends, String userKey);

}
