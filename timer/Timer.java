package timer;

class Timer {

    /**
     * Creating a ref to instance, to delegate to his methods a behavior
     */
    private ITimeAction action;
    private int mls = -1;

    Timer(final ITimeAction action) {// dependency injection techniques
        this.action = action;
    }

    void run() {
        if (isTime(mls)) {
            action.ontime();
        }
    }

    void setMls(int min) {
        this.mls = min * 60 * 1000;
    }

    private boolean isTime(int mls) {
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

}
