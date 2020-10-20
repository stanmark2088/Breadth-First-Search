package com.codecool.bfsexample.model;

import java.util.*;

public class BreadthFirstSearch {

    private List<UserNode> users;


    public BreadthFirstSearch(List<UserNode> users) {
        this.users = users;

    }


    public int getDistanceBetweenNodes(UserNode startNode, UserNode endNode) {

        Queue<UserNode> queue = new LinkedList<>();
        Map<UserNode, Integer> distances = new HashMap<>();

        if (users.contains(startNode) && !startNode.equals(endNode)) {
            queue.add(startNode);
            distances.put(startNode, 0);
            while (!queue.isEmpty()) {
                UserNode currentNode = queue.remove();
                if (currentNode.equals(endNode)) {
                    return distances.get(currentNode);
                }
                for (UserNode friend : currentNode.getFriends()) {
                    if (!distances.containsKey(friend)) {
                        queue.add(friend);
                        distances.put(friend, distances.get(currentNode) + 1);
                    }
                }
            }
        }
        return 0;
    }

    public List<UserNode> getFriendsOfFriends(UserNode startNode, Integer distance) {

        Queue<UserNode> queue = new LinkedList<>();
        Map<UserNode, Integer> distances = new HashMap<>();
        List<UserNode> friendsOfFriends = new ArrayList<>();

        if (users.contains(startNode)) {
            queue.add(startNode);
            distances.put(startNode, 0);
            while (!queue.isEmpty()) {
                UserNode currentNode = queue.remove();
                friendsOfFriends.remove(startNode);
                if (distances.get(currentNode) > distance) {
                    return friendsOfFriends;
                } else {
                    friendsOfFriends.add(currentNode);
                }
                for (UserNode friend : currentNode.getFriends()) {
                    if (!distances.containsKey(friend)) {
                        queue.add(friend);
                        distances.put(friend, distances.get(currentNode) + 1);
                    }
                }
            }
        }
        return friendsOfFriends;
    }

    public Map<UserNode, Integer> shortestPath(UserNode startNode, UserNode endNode) {

        Queue<UserNode> queue = new LinkedList<>();
        Map<UserNode, Integer> distances = new HashMap<>();

        if (users.contains(startNode)) {
            queue.add(startNode);
            distances.put(startNode, 0);

            while (!queue.isEmpty()) {
                UserNode currentNode = queue.remove();
                if (currentNode.equals(endNode)) {
                    break;
                }
                for (UserNode friend : currentNode.getFriends()) {
                    if (!distances.containsKey(friend)) {
                        queue.add(friend);
                        distances.put(friend, distances.get(currentNode) + 1);
                    }
                }
            }
        }
        return distances;
    }
}
