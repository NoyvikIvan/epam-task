package events;

public class SecondControlEvent extends ControlEvent {
    private final static double MARK = 7.5;
    private double exam;
    private boolean test;


    public double getExam() {
        return exam;
    }

    public void setExam(double exam) {
        this.exam = exam;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }


    @Override
    public boolean eventPassed() {
        return exam >= MARK && test;
    }

    @Override
    public String toString() {
        return super.toString()+"second control event!";
    }
}
