package Geometry;

import java.util.ArrayList;

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

    public static ArrayList<Point2D> convexHull(ArrayList<Point2D> arr) {
        ArrayList<Point2D> hull = new ArrayList<>();
        
        return hull;
    }
}
