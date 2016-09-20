package timer;

class TimeToEatChicken implements ITimeAction {

    @Override
    public void ontime() {
        System.out.println("chicken is ready");
    }
}
