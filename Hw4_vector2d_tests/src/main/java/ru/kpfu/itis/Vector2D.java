package ru.kpfu.itis;

public class Vector2D {
    private double x = 0;
    private double y = 0;

    Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D scalarMultiply(Vector2D vector2D) {
        return new Vector2D(x * vector2D.getX(), y * vector2D.getY());
    }

    public Vector2D multiply(double k) {
        return new Vector2D(x * k, y * k);
    }

    public Vector2D add(Vector2D vector2D) {
        return new Vector2D(x + vector2D.getX(), y + vector2D.getY());
    }

    public Vector2D subtract(Vector2D vector2D) {
        return new Vector2D(x - vector2D.getX(), y - vector2D.getY());
    }

    @Override
    public boolean equals(Object other) {
        final Vector2D vector2D = (Vector2D) other;
        if (x == vector2D.getX() && y == vector2D.getY())
            return true;
        else
            return false;
    }
}
