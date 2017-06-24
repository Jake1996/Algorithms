package Geometry;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LinesAndDots {

    public static class Point2D {
        double x, y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point2D b) {
            if (x > b.x)
                return 1;
            else if (x < b.x)
                return -1;
            else if (y > b.y)
                return 1;
            else if (y < b.y)
                return -1;
            return 0;
        }

        public static double distanceBTW(Point2D a, Point2D b) {
            double x = a.x - b.y;
            double y = a.y - b.y;
            return Math.sqrt(x * x + y * y);
        }

        public double distanceTo(Point2D a) {
            double tx = a.x - x;
            double ty = a.y - y;
            return Math.sqrt(tx * tx + ty * ty);
        }
    }

    // To find orientation of ordered triplet (p1, p2, p3).
    // The function returns following values
    // 0 --> p, q and r are colinear
    // 1 --> Clockwise
    // 2 --> Counterclockwise
    public static int orientation(Point2D p1, Point2D p2, Point2D p3) {
        // See 10th slides from following link for derivation
        // of the formula
        double val = (p2.y - p1.y) * (p3.x - p2.x) - (p2.x - p1.x) * (p3.y - p2.y);

        if (val == 0)
            return 0; // colinear

        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }

    public static double shortestDistance(ArrayList<Point2D> arr) {
        arr.sort((Point2D a, Point2D b) -> a.compareTo(b));
        double min = Double.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            int j = i + 1;
            while (j < arr.size() && arr.get(j).x - arr.get(i).x < min) {
                min = Math.min(min, arr.get(i).distanceTo(arr.get(j)));
                j++;
            }
        }
        return min;
    }

    public static Point2D[] convexHull(ArrayList<Point2D> arr) {
        Deque<Point2D> hull = new LinkedList<>();;
        int l = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).x < arr.get(l).x) {
                l = i;
            }
        }
        Point2D ref = arr.get(l);
        arr.set(l, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        arr.sort((Point2D o1, Point2D o2) -> {
            int val = orientation(ref, o1, o2);
            if (val == 0) {
                return Point2D.distanceBTW(ref, o1) < Point2D.distanceBTW(ref, o2) ? -1 : 1;
            }
            if (val == 2)
                return -1;
            return 1;
        });
        hull.add(ref);
        //check if all points are equal
        for (l = 0; l < arr.size(); l++) {
            if (ref.compareTo(arr.get(l)) != 0) {
                break;
            }
        }

        //all points are equal
        if (l == arr.size())
            return (Point2D[])hull.toArray();
        hull.add(arr.get(l++));
        for (; l < arr.size(); l++) {
            if (orientation(ref, hull.peek(), arr.get(l)) == 2) {
                break;
            }
        }
        if (l == arr.size())
            return (Point2D[])hull.toArray();
        hull.add(arr.get(l++));

        for (; l < arr.size(); l++) {
            Point2D pop = hull.pop();
            while(orientation(hull.peek(), pop, arr.get(l))!=2) {
                pop = hull.pop();
            }
            hull.push(pop);
            hull.push(arr.get(l));
        }

        return (Point2D[])hull.toArray();
    }
}
