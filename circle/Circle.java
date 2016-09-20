package circle;

public class Circle {
    private int pointX;
    private int pointY;
    private int radius;

    public Circle() {
        pointX = 0;
        pointY = 0;
        radius = 0;
    }

    public Circle(int x, int y, int r) {
        pointX = x;
        pointY = y;
        radius = r;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int r) {
        radius = r;
    }

    public void moveCenter(int length) {
        System.out.println("move centre by " + length);
        pointX *= length;
        pointY *= length;
    }

    public boolean isInCentre(int a, int b) {
        System.out.println("Is the point into circle?");
        if (Math.pow((a - pointX), 2) + Math.pow((b - pointY), 2) <= Math.pow(
                radius, 2)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "point X - " + pointX + ", point Y - " + pointY + ", radius - "
                + radius;
    }

}
