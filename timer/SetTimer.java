package timer;

class SetTimer {

    static Timer createTimer(String userAlarm) {
        switch (userAlarm) {
            case "1":
                return new Timer(new TimeToWakeUp());
            case "2":
                return new Timer(new TimeToEatChicken());
            default:
                return null;
        }
    }
}
