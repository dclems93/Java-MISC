//full name: Joe Biden
//username: joeb
// collaborator(s): I went to German's help sessions.

class Homework7 {

        public static void main(String[] args) {
        //Use this to test out your code, this section will not be graded.
        //You can copy and paste examples in from the assignment page (inside
        //the main methods, but be careful as you might re-use some variable
        //names. Always be aware of what it is you are actually running.

        //Insert testing code in body of this main method:
    Point a = new Point(3, 0);
    Point b = new Point(0, 4);
    System.out.println(a.distanceTo(b));
    System.out.println((new Point(1, 1)).distanceTo(new Point()));

        Line c = new Line(new Point(0, 0), new Point(1, 1));
        System.out.println(c.length());

        Triangle d = new Triangle( new Point(0, 0), new Point(0, 3), new Point(4, 0) );

    System.out.println(d.area()); // prints 3 * 4 / 2 (that is: 6 (six))

    Clock one = new Clock("2350");
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());
    one.tick();
    System.out.println(one.report());

    Car two= new Car(50);
    two.addGas(20);
    two.drive(100);
    System.out.println(two.getGasLevel()); // Should be 18

    Student three = new Student("Larry");
    three.addQuiz(10);
    three.addQuiz(9);
    three.addQuiz(8);
    three.getTotalScore(); // Should be 27.0
    three.getAverageScore(); // Should be 9.0


        int xcor = (int)(Math.random() * 1000),
            ycor = (int)(Math.random() * 1000);
        Tigger u = new Tigger(xcor, ycor);
        for (int i = 0; i < 30; i++) {
            u.bounce();
            System.out.println(u.report());
}
}
}

//Problem 1
class Point {
  private int x, y;
  Point(int a, int b) {
    this.x = a;
    this.y = b;
  }
  Point() {
    this(0, 0);
  }
  int getX() { return this.x; }
  int getY() { return this.y; }
  double distanceTo(Point another) {
    int dx = this.x - another.x;
    int dy = this.y - another.y;
    return Math.sqrt( dx * dx + dy * dy );
  }
}

//Problem 2
class Line {
  Point x, y;
  Line(Point a, Point b) {
    this.x = a;
        this.y = b;
  }
  double length() {
    return x.distanceTo(y);
  }
}

//Problem 3
class Triangle {
  Line x, y, z;
  Triangle(Point a, Point b, Point c) {
        this.x = new Line(a, b);
        this.y = new Line(b, c);
        this.z = new Line(c, a);
  }
  double area() {
    double s1 = x.length();
    double s2 = y.length();
    double s3 = z.length();
    double s = (s1 + s2 + s3) / 2;
        return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
  }
}

//Problem 4
class Clock {
  int hours, minutes;
  Clock(String time) {
    hours = Integer.parseInt(time.substring(0, 2));
        minutes = Integer.parseInt(time.substring (2, 4));
  }
  void tick() {
    minutes++;
        if (minutes == 60) {
          hours++;
          minutes = 0;
        }
        if (hours == 24) {
          hours = 0;
        }
  }
  String report() {
      if ((hours < 10) && (minutes < 10)) {
    return "0" + hours + ":" + "0" + minutes;
  }
  if (hours < 10) {
    return "0" + hours + ":" + minutes;
  }
  if (minutes < 10) {
    return hours + ":" + "0" + minutes;
  }
  else return hours + ":" + minutes;
  }
}

//Problem 5
class Car {
  double fuel;
  int efficiency;
  int miles;
  Car (int x) {
    this.efficiency = x;
  }
  int addGas(int y) {
    this.fuel = y;
    return y;
  }
  int drive(int z) {
    this.miles = z;
        z = z / efficiency;
        return z;
  }
  int getGasLevel() {
    return (int)fuel - (miles / efficiency);
  }
}

//Problem 6
class Student {
  private String name;
  private int total;
  private int count;
  Student(String givenName) {
    this.name = givenName;
    System.out.println("This student's name is: " + givenName);
  }
  String getName() {
    return this.name;
  }
  double addQuiz(int score) {
    total += score;
        count++;
        return total;
  }
  int getTotalScore() {
    // System.out.println("Total score is: " + total);
    return total;
  }
  double getAverageScore() {
    double avg = ((double) total) / count;
        System.out.println("Average score is: " + avg);
        return (count == 0) ? 0 : avg;
  }
}

//Problem 7
class Robot {

  private int x, y;

  int getX() { return this.x; }
  int getY() { return this.y; }

  String direction() { return this.dir; }

  private String name;

  private String dir;

  Robot (String givenName, int a, int b, String givenDirection) {
        this.name = givenName;
        this.x = a;
        this.y = b;
        this.dir = givenDirection;
  }

  String turnLeft() {
    if (dir.equals("North")) {
          System.out.println("Robot " + name + " now turns left.");
      dir = "West";
          return dir;
        }
        else if (dir.equals("South")) {
          System.out.println("Robot " + name + " now turns left.");
          dir = "East";
          return dir;
        }
        else if (dir.equals("West")) {
          System.out.println("Robot " + name + " now turns left.");
          dir = "South";
          return dir;
        }
        else {
          System.out.println("Robot " + name + " now turns left.");
          dir = "North";
          return dir;
        }
  }
  int moveForward() {
    if (dir.equals("North")) {
          System.out.println("Robot " + name + " now moves forward.");
      y--;
          return y;
        }
        else if (dir.equals("South")) {
          System.out.println("Robot " + name + " now moves forward.");
          y++;
          return y;
        }
        else if (dir.equals("East")) {
          System.out.println("Robot " + name + " now moves forward.");
          x++;
          return x;
    }
    else {
      System.out.println("Robot " + name + " now moves forward.");
      x--;
      return x;
    }
  }
  String report() {
    System.out.println("Robot " + name + " located at (" + x + ", " + y + ") facing " + dir);
    return "";
}



}

// Problem 8
class Tigger {

    private String x, y;

    Tigger(int x, int y) {
        this.x = x + "";
        this.y = y + "";
    }
    void bounce() {
        int a = calculate(x),
            b = calculate(y);
        this.x = a + "";
        this.y = b + "";

    }
    int calculate(String a) {
        int sum = 0;
        for (int i = 0; i < a.length(); i++) {
            sum += (a.charAt(i) - '0') * (a.charAt(i) - '0');
        }
        return sum;
    }
//    String report() {
//       String
//            x = "   " + this.x,
//            y = "   " + this.y;
//        return
//            "Tigger just bounced to (" +
//            x.substring(x.length() - 3) + ", "
//            + y.substring(y.length() - 3) + ")";
//    }
    String report() {
        return "Tigger just bounced to (" + x + ", " + y + ")";
    }
}
