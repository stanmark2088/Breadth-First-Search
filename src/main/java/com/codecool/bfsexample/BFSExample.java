package com.codecool.bfsexample;

import com.codecool.bfsexample.model.BreadthFirstSearch;
import com.codecool.bfsexample.model.UserNode;
import java.util.List;

public class BFSExample {

    private static List<UserNode> populateDB() {

        RandomDataGenerator generator = new RandomDataGenerator();
        List<UserNode> users = generator.generate();

        GraphPlotter graphPlotter = new GraphPlotter(users);

        System.out.println("Done!");
        return users;
    }

    public static void main(String[] args) {
        List<UserNode> users = populateDB();
        UserNode user1 = users.get(34);
        UserNode user2 = users.get(75);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(users);
        System.out.println(breadthFirstSearch.getDistanceBetweenNodes(user1, user2));
        System.out.println(breadthFirstSearch.getFriendsOfFriends(user1, 2));
        System.out.println(breadthFirstSearch.shortestPath(user1, user2));
    }
}
