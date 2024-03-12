package org.example;

class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle[radius=%.2f, color=%s]", radius, color);
    }
}

class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        this.height = 1.0;
    }

    public Cylinder(double radius) {
        super(radius);
        this.height = 1.0;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * super.getRadius() * (super.getRadius() + height);
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public String toString() {
        return String.format("Cylinder[radius=%.2f, height=%.2f, color=%s]", super.getRadius(), height, super.getColor());
    }
}

public class Program{
    public static void main(String[] args) {
        Circle[] circles = {
                new Cylinder(12.34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, 10.0, "blue")
        };

        for (Circle circle : circles) {
            System.out.println("Circle area: " + circle.getArea());
            if (circle instanceof Cylinder) {
                Cylinder cylinder = (Cylinder) circle;
                System.out.println("Cylinder volume: " + cylinder.getVolume());
            }
        }
    }
}
