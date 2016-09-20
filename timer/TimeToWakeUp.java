package timer;

class TimeToWakeUp implements ITimeAction {

    @Override
    public void ontime() {
        System.out.println("Time to wake up");
    }
}
