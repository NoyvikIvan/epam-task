package info;

import events.SecondControlEvent;

import static info.ExtractInformation.*;

public class ExtractSecondInfoEvent {
    private static final String PASSED = "passed";
    public static SecondControlEvent extractAllInfo(String line)  {
        SecondControlEvent event = new SecondControlEvent();
        event.setName(extractInfo(catLine(line)));
        event.setId(Integer.parseInt(extractInfo(catLine(line, 2))));
        event.setExam(Double.parseDouble(extractInfo(catLine(line, 3))));
        event.setTest(extractLastInfo(catLine(line, 4)).equals(PASSED));
        return event;
    }
}
