package com.corz.manager;

import java.util.HashSet;
import java.util.Set;

public class FriendManager {
    private static final Set<String> friends = new HashSet<>();

    public static void init() {
        friends.add("OwnedByM4");
        friends.add("ไอ้ฝ้าย");
    }

    public static boolean isFriend(String name) { return friends.contains(name); }
    public static void addFriend(String name) { friends.add(name); }
    public static void removeFriend(String name) { friends.remove(name); }
    public static Set<String> getFriends() { return friends; }
}
