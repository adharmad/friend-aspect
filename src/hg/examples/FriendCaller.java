package hg.examples;

public class FriendCaller {
	public FriendCaller() { }
	
	public void callFriend() {
		//new FriendExample().doSomething();
		new FriendExample().doSomethingElse("hello");
	}
	
	public static void main(String[] args) {
		new FriendCaller().callFriend();
	}
}
