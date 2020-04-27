package info;
import static info.ExtractInformation.*;
import static info.ExtractInformation.catLine;
import events.FirstControlEvent;



public class ExtractInfoFirstEvent {
    public static FirstControlEvent extractAllInfo(String line) {
        FirstControlEvent event = new FirstControlEvent();
        event.setName(extractInfo(catLine(line)));
        event.setId(Integer.parseInt(extractInfo(catLine(line, 2))));
        event.setExam1(Integer.parseInt(extractInfo(catLine(line, 3))));
        event.setExam2(Integer.parseInt(extractLastInfo(catLine(line, 4))));
        return event;
    }
}
