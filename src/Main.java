public class Main {
    public static void main(String[] args) {

        Bowl bowl = new Bowl(10);
        Cat cat1 = new Cat("Murzik");
        Cat cat2 = new Cat("Barsik");
        Dog dog1 = new Dog("Bobik");

        Cat[] cats = {cat1, cat2};

        for (Cat cat : cats) {
            cat.eat(bowl, 5);
        }

        for (Cat cat : cats) {
            String state = cat.isFull() ? "full" : "hungry";
            System.out.println(cat.name + " is currently " + state + ".");
        }

        dog1.run(150);
        bowl.addFood(5);

        Shape circle = new Circle(5);
        circle.showInfo("Red", "Black");

        Shape rectangle = new Rectangle(4, 6);
        rectangle.showInfo("Green", "Blue");

        Shape triangle = new Triangle(3, 4, 5);
        triangle.showInfo("Yellow", "Purple");
    }
}

class Animal {
    static int count = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int distance) {
    }

    public void swim(int distance) {
    }
}

class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " ran " + distance + " m.");
        } else {
            System.out.println(name + " can't run " + distance + " m.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " swam " + distance + " m.");
        } else {
            System.out.println(name + " can't swim " + distance + " m.");
        }
    }
}

class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private static final boolean CAN_SWIM = false;
    private boolean isFull = false; // By default, cat is hungry

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " ran " + distance + " m.");
        } else {
            System.out.println(name + " can't run " + distance + " m.");
        }
    }

    @Override
    public void swim(int distance) {
        if (CAN_SWIM) {
            System.out.println(name + " swam " + distance + " m.");
        } else {
            System.out.println(name + " can't swim.");
        }
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.food >= amount) {
            bowl.food -= amount;
            isFull = true;
            System.out.println(name + " ate and is now full.");
        } else {
            System.out.println(name + " doesn't have enough food in the bowl.");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}

class Bowl {
    public int food;

    public Bowl(int food) {
        this.food = food;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Added " + amount + " food to the bowl. Now there is " + food + " food in the bowl.");
        } else {
            System.out.println("The amount of food added must be positive.");
        }
    }
}

interface Shape {
    double area();
    double perimeter();

    default void showInfo(String fillColor, String borderColor) {
        System.out.println("Fill color: " + fillColor);
        System.out.println("Border color: " + borderColor);
        System.out.println("Perimeter: " + perimeter());
        System.out.println("Area: " + area());
    }
}

class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}

class Triangle implements Shape {
    private double a;
    private double b;
    private double c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}
