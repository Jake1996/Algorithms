package Algorithms.Tester;

import java.util.ArrayList;

import Algorithms.Geometry.LinesAndDots;

public class geometry {
    public static void main(String args[]) {
        LinesAndDots.Point2D a = new LinesAndDots.Point2D(1, 2);
        LinesAndDots.Point2D b = new LinesAndDots.Point2D(2, 1);
        ArrayList<LinesAndDots.Point2D> arr = new ArrayList<>();
        arr.add(a);
        arr.add(b);
        System.out.println(a.compareTo(b));
    }
}