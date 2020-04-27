package events;

public class ThirdControlEvent extends ControlEvent {

    private boolean[] test = new boolean[5];

    public boolean[] getTest() {
        return test;
    }

    public void setTest(boolean test, int index) {
        this.test[index] = test;
    }

    @Override
    public boolean eventPassed() {
        int i = 0;
        for (boolean result : test) {
            if (result) {
                i++;
            }
        }
        return i >= 4;
    }

    @Override
    public String toString() {
        return super.toString()+"third control event!";
    }
}
