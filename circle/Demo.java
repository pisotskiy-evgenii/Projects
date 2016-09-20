package circle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        Circle circle = new Circle(4, 5, 7);
        System.out.println(circle);
        if (circle.isInCentre(5, 2))
            System.out.println("Yes");
        else
            System.out.println("No");

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        do {
            try {
                if (circle.getRadius() == 0) throw new NotValueOfRadius();
            } catch (NotValueOfRadius excR) {
                System.err.println(excR);
                int r;
                try {
                    r = Integer.parseInt(reader.readLine());
                } catch (final IOException | NumberFormatException ioExc) {
                    System.out.println("You entered not correct data."
                            + " \nThe programme will be close");
                    return;
                }
                circle.setRadius(r);
                System.out.println("Radius is " + r + ", Ok.");
            }
        } while (circle.getRadius() == 0);

        circle.moveCenter(7);
        System.out.println(circle);
////////////////////////////////////////////////
        System.out.println("Typing coordinate of point:");
        System.out.print("Type x coordinate: ");
        int x;
        try {
            x = Integer.parseInt(reader.readLine());
        } catch (final IOException | NumberFormatException ioExc) {
            System.out.println("You entered not correct data."
                    + " \nThe programme will be closed");
            return;
        }
        System.out.print("Type y coordinate: ");
        int y;
        try {
            y = Integer.parseInt(reader.readLine());
        } catch (final IOException | NumberFormatException ioExc) {
            System.out.println("You entered not correct data."
                    + " \nThe programme will be closed");
            return;
        }
        if (circle.isInCentre(x, y)) {
            System.out.println("Yes");
        } else
            System.out.println("No");
    }
}
