package info;

import events.ThirdControlEvent;
import static info.ExtractInformation.*;
import static info.ExtractInformation.catLine;

public class ExtractInfoThirdEvent {
    private static final String PASSED = "passed";
    public static ThirdControlEvent extractAllInfo(String line) {
        ThirdControlEvent event = new ThirdControlEvent();
        event.setName(extractInfo(catLine(line)));
        event.setId(Integer.parseInt(extractInfo(catLine(line, 2))));
        for (int i = 0; i < 4; i++) {
            event.setTest(extractInfo(catLine(line, i+3)).equals(PASSED), i);
        }
        event.setTest(extractLastInfo(catLine(line, 7)).equals(PASSED), 4);
        return event;
    }
}
