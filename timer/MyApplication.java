package timer;

import java.util.Scanner;

public class MyApplication {

    public static void main(String[] args) {
        System.out.println("You have two Alarms: \n1.Wakeup\n2.CookChicken");
        System.out.println("Choose one. Type \n1 or 2");
        System.out.println("Please: ");

        Scanner sc = new Scanner(System.in);
        String userAlarm = sc.nextLine();
        if (!userAlarm.equals("1") && !userAlarm.equals("2")) {
            System.out.println("You type uncorrected alarm name");
            System.out.println("Alarm clock has finished" + "");
            sc.close();
            return;
        }

        Timer timer = SetTimer.createTimer(userAlarm);

        System.out.println("Now type how many minutes must the alarm start");

        timer.setMls(Integer.parseInt(sc.nextLine()));
        timer.run();
        System.out.println("Alarm clock has finished" + "");
        sc.close();

    }
}
