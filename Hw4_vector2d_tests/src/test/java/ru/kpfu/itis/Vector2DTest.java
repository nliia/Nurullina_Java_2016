package ru.kpfu.itis;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2DTest {
    private static Vector2D vector2D;
    public static final double X = 3.25;
    public static final double Y = 4.2;
    public static final double X_FOR_CHECK = 3.7;
    public static final double Y_FOR_CHECK = 5.23;
    public static final double K = 3;
    private static final double DELTA = 10e-2;

    @BeforeClass
    public static void setUp() {
        vector2D = new Vector2D(X, Y);
    }

    @Test
    public void getXShouldReturnX() {
        Assert.assertEquals(X, vector2D.getX(), DELTA);
    }

    @Test
    public void getYShouldReturnY() {
        Assert.assertEquals(Y, vector2D.getY(), DELTA);
    }

    @Test
    public void lengthShouldReturnCorrectLength() {
        Assert.assertEquals(Math.sqrt(X * X + Y * Y), vector2D.length(), DELTA);
    }

    @Test
    public void addShouldReturnCorrectResult() {
        Assert.assertEquals(new Vector2D(X + X_FOR_CHECK, Y + Y_FOR_CHECK), vector2D.add(new Vector2D(X_FOR_CHECK, Y_FOR_CHECK)));
    }

    @Test
    public void subtractShouldReturnCorrectResult() {
        Assert.assertEquals(new Vector2D(X - X_FOR_CHECK, Y - Y_FOR_CHECK), vector2D.subtract(new Vector2D(X_FOR_CHECK, Y_FOR_CHECK)));
    }

    @Test
    public void multiplyShouldReturnCorrectResult() {
        Assert.assertEquals(new Vector2D(X * K, Y * K), vector2D.multiply(K));
    }

    @Test
    public void multiplyScalarShouldReturnCorrectResult() {
        Assert.assertEquals(new Vector2D(X * X_FOR_CHECK, Y * Y_FOR_CHECK), vector2D.scalarMultiply(new Vector2D(X_FOR_CHECK, Y_FOR_CHECK)));
    }

    @Test
    public void equalsShouldReturnTrue() {
        Assert.assertTrue(vector2D.equals(new Vector2D(X, Y)));
    }

    @Test
    public void equalsShouldReturnFalse() {
        Assert.assertFalse(vector2D.equals(new Vector2D(X_FOR_CHECK, Y_FOR_CHECK)));
    }
}
