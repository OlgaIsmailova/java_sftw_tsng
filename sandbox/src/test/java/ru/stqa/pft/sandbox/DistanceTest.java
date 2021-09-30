package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;
public class DistanceTest{

    @Test
    public void testDistance() {

        Point o = new Point(0, 0);
        Point l = new Point(1, 1);
        assert o.distance(o, l) == 1;
    }
}
