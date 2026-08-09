class Shape {
    void area() {
        System.out.println("Area of shape");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void area() {
        double result = Math.PI * radius * radius;
        System.out.println("Area of Circle = " + result);
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    void area() {
        double result = length * width;
        System.out.println("Area of Rectangle = " + result);
    }
}

public class ShapeDemo {
    public static void main(String[] args) {

        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(10, 5);

        s1.area();
        s2.area();
    }
}