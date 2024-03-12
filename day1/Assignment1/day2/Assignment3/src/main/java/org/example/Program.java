package org.example;

abstract class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return String.format("Shape[color=%s, filled=%b]", color, filled);
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle[radius=%.2f, color=%s, filled=%b]", radius, super.getColor(), super.isFilled());
    }
}

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[width=%.2f, length=%.2f, color=%s, filled=%b]", width, length, super.getColor(), super.isFilled());
    }
}

class Square extends Rectangle {
    public Square() {
        super(1.0, 1.0);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public String toString() {
        return String.format("Square[side=%.2f, color=%s, filled=%b]", super.getWidth(), super.getColor(), super.isFilled());
    }
}

public class Program {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        shapes[0] = new Circle(1.0, "blue", true);
        shapes[1] = new Rectangle(2.0, 3.0, "green", false);
        shapes[2] = new Square(4.0, "yellow", true);
        shapes[3] = new Circle(5.0, "red", false);
        shapes[4] = new Rectangle(6.0, 7.0, "orange", true);
        shapes[5] = new Square(8.0, "purple", false);
        shapes[6] = new Circle(9.0, "white", true);
        shapes[7] = new Rectangle(10.0, 11.0, "black", false);
        shapes[8] = new Square(12.0, "gray", true);
        shapes[9] = new Circle(13.0, "pink", false);

        for (Shape shape : shapes) {
            System.out.println(shape.toString());
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
            System.out.println();
        }
    }
}
