package hg.examples;

public class DisallowedCaller {
	public DisallowedCaller() { }
	
	public void callFriend() {
		new FriendExample().doSomething();
	}
	
	public static void main(String[] args) {
		new DisallowedCaller().callFriend();
	}

}
