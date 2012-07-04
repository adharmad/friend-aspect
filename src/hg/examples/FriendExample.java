package hg.examples;

import hg.annotation.Friend;

public class FriendExample {
	public FriendExample() {}
	
	@Friend(callers = ("hg.examples.FriendCaller"))
	public void doSomething() {
		System.out.println("doing something");
	}
	
	@Friend(callers = {"hg.examples.FriendCaller", "hg.examples.AnotherFriendCaller"})
	public void doSomethingElse(String s) {
		System.out.println("doing something else");
	}	
}
