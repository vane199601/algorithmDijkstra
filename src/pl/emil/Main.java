package pl.emil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Point pointA = new Point("A", 2,3);
        Point pointB = new Point("B", 5,1);
        Point pointC = new Point("C", 4,7);
        Point pointD = new Point("D", 7,7);
        Point pointE = new Point("E", 7,3);

        pointA.putDistance(pointB);
        pointA.putDistance(pointC);
        pointA.putDistance(pointD);
        pointA.putDistance(pointE);

        pointB.putDistance(pointA);
        pointB.putDistance(pointC);
        pointB.putDistance(pointD);
        pointB.putDistance(pointE);

        pointC.putDistance(pointB);
        pointC.putDistance(pointA);
        pointC.putDistance(pointD);
        pointC.putDistance(pointE);

        pointD.putDistance(pointB);
        pointD.putDistance(pointC);
        pointD.putDistance(pointA);
        pointD.putDistance(pointE);

        pointE.putDistance(pointA);
        pointE.putDistance(pointB);
        pointE.putDistance(pointC);
        pointE.putDistance(pointD);

        String startPoint = "C";

        Map<String, Point> pointMap = new HashMap<>();
        pointMap.put(pointA.getName(), pointA);
        pointMap.put(pointB.getName(), pointB);
        pointMap.put(pointC.getName(), pointC);
        pointMap.put(pointD.getName(), pointD);
        pointMap.put(pointE.getName(), pointE);

        List<String> shortestPathList = new ArrayList<>();

        String actualPoint = startPoint;
        String previousPoint;
        Point temporaryPoint = pointMap.get(actualPoint);;

        double totalDistance = 0.0;

        for (int i = pointMap.size(); i > 1 ; i--) {
            shortestPathList.add(temporaryPoint.getName());
            pointMap.remove(actualPoint);
            previousPoint = actualPoint;
            actualPoint = temporaryPoint.findClosestPoint();
            totalDistance = totalDistance + temporaryPoint.getClosestDistance(actualPoint);
            temporaryPoint = pointMap.get(actualPoint);
            if(temporaryPoint.getMapDistances().size() > 0) {
                temporaryPoint.removePointFromMapDistances(previousPoint);
            }
        }

       shortestPathList.add(temporaryPoint.getName());

        System.out.print("The shortest way is: ");
        for (String s : shortestPathList) {
            System.out.print(s + " > ");
        }
        System.out.println(startPoint);

        totalDistance = totalDistance + temporaryPoint.getClosestDistance(startPoint);
        System.out.println("Total distance= " + totalDistance);
    }
}
