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
            if(x>b.x) return 1;
            else if(x<b.x) return -1;
            else if(y>b.y) return 1;
            else if(y<b.y) return -1;
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

        public static double shortestDistance(ArrayList<Point2D> arr) {
            arr.sort((Point2D a,Point2D b)->a.compareTo(b));
            double min = Double.MAX_VALUE;
            for(int i=0;i<arr.size();i++) {
                while(arr.get(i).x-arr.get(i+1).x<min) {

                }
            }
            
            return 0;
        }

    }
}
