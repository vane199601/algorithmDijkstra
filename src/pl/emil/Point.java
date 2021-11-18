package pl.emil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Point {

    private final String name;
    private final int x;
    private final int y;
    private final Map<String, Double> mapDistances = new HashMap<>();

    public Point(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    private Double calculateDistance(Point point) {
        return Math.sqrt(Math.pow((point.getX() - this.getX()), 2) + Math.pow((point.getY() - this.getY()), 2));
    }

    public void putDistance(Point point) {
        mapDistances.put(point.getName(), calculateDistance(point));
    }

    public void removePointFromMapDistances(String pointName) {
        mapDistances.remove(pointName);
    }

    public Double getClosestDistance(String pointName) {
        return mapDistances.get(pointName);
    }

    private <K, V> K getKeyOfMap(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String findClosestPoint() {
        Double minValue =  Collections.min(mapDistances.values());
        return getKeyOfMap(mapDistances, minValue);
        }

    public Map<String, Double> getMapDistances() {
        return mapDistances;
    }
}
