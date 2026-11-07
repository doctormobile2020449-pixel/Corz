package com.corz.manager;

import java.util.ArrayList;
import java.util.List;

public class WaypointManager {
    public static class Waypoint {
        public String name;
        public int x, y, z;
        public Waypoint(String name, int x, int y, int z) {
            this.name = name; this.x = x; this.y = y; this.z = z;
        }
    }
    private static final List<Waypoint> waypoints = new ArrayList<>();

    public static void init() {
        waypoints.add(new Waypoint("Base", 120, 64, -340));
        waypoints.add(new Waypoint("Spawn", 0, 70, 0));
        waypoints.add(new Waypoint("DonutShop", -50, 65, 410));
    }

    public static List<Waypoint> getWaypoints() { return waypoints; }
    public static void addWaypoint(String name, int x, int y, int z) {
        waypoints.add(new Waypoint(name, x, y, z));
    }
}
