package events;

public class FirstControlEvent extends ControlEvent {
    private final static int MARK = 18;
    private int exam1;
    private int exam2;

    public int getExam1() {
        return exam1;
    }

    public void setExam1(int exam1) {
        this.exam1 = exam1;
    }

    public int getExam2() {
        return exam2;
    }

    public void setExam2(int exam2) {
        this.exam2 = exam2;
    }



    @Override
    public boolean eventPassed() {
        return exam1 + exam2 >= MARK;
    }

    @Override
    public String toString() {
        return super.toString()+"first control event!";
    }
}
