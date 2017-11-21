package com.telusko;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	private static List<User> usersList = new ArrayList<User>();
	private static String[] names = { "Navin", "Teju", "Kamil", "James", "Sarah", "Mohammed", "Raja", "Thabisile",
			"Xolani", "Nkosinathi" };
	private static int[] ages = { 20, 22, 18, 30, 17, 30, 23, 40, 19, 27 };
	private static UserRepository repository = new UserRepository();

	private UserRepository() {
		populateUsers();
	}

	// Applied Singleton Pattern hence called only once by the the constructor.
	public void populateUsers() {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setUid(i);
			user.setUname(names[i]);
			user.setAge(ages[i]);
			usersList.add(user);
		}
	}

	public static UserRepository getRepository() {
		return repository;
	}

	public List<User> getUsersByContainedText(String txt) {
		List<User> matchingUsers = new ArrayList<User>();
		for (User user : usersList) {
			if (user.getUname().toLowerCase().contains(txt.toLowerCase())) {
				matchingUsers.add(user);
			}
		}

		return matchingUsers;
	}
}
