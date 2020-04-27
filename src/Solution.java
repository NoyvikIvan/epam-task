import events.ControlEvent;
import info.ExtractInfoFirstEvent;
import info.ExtractSecondInfoEvent;
import info.ExtractInfoThirdEvent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    
    private static final String FIRST_CONTROL_EVENT = "First control event";
    private static final String SECOND_CONTROL_EVENT = "Second control event";
    private static final String THIRD_CONTROL_EVENT = "Third control event";

    public static void main(String[] args) {
        List<ControlEvent> eventList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0])/*("Ivan.txt")*/)) {
            while (bufferedReader.ready()) {
                String readLine = bufferedReader.readLine();                       // считываем файл построчно
                switch (readLine) {
                    case FIRST_CONTROL_EVENT:                        // определяем к какому мероприятию относятся дальнейшие строки
                        while (true) {
                            String nextLine = bufferedReader.readLine();               // читаем следующую строку зная какое именно это мероприятие
                            if (!nextLine.isEmpty()) {
                                eventList.add(ExtractInfoFirstEvent.extractAllInfo(nextLine)); // заполняем элемент события и добавляем в коллекцию
                            } else
                                break;
                        }
                        break;
                    case SECOND_CONTROL_EVENT:          // определяем к какому мероприятию относятся дальнейшие строки
                        while (true) {
                            String nextLine = bufferedReader.readLine();    // читаем следующую строку зная какое именно это мероприятие
                            if (!nextLine.isEmpty()) {
                                eventList.add(ExtractSecondInfoEvent.extractAllInfo(nextLine)); // заполняем элемент события и добавляем в коллекцию
                            } else break;
                        }
                        break;
                    case THIRD_CONTROL_EVENT:                                       // определяем к какому мероприятию относятся дальнейшие строки
                        while (true) {
                            String nextLine = bufferedReader.readLine();            // читаем следующую строку зная какое именно это мероприятие
                            if (!nextLine.isEmpty()) {
                                eventList.add(ExtractInfoThirdEvent.extractAllInfo(nextLine)); // заполняем элемент события и добавляем в коллекцию
                            } else break;
                        }
                        break;
                }
            }

            System.out.println(eventList.toString());

            Collections.sort(eventList, new Comparator<ControlEvent>() {
                @Override
                public int compare(ControlEvent o1, ControlEvent o2) {
                    if (o1.eventPassed() && o2.eventPassed() || !o1.eventPassed() && !o2.eventPassed()){
                        return 0;
                    }
                    else if (o1.eventPassed() && !o2.eventPassed() || !o1.eventPassed() && o2.eventPassed()){
                        if (o1.eventPassed())
                            return -1;
                        else return 1;
                    }
                    return 0;
                }
            });
            System.out.println("\n***\n");
            System.out.println(eventList.toString());
        }
        catch (FileNotFoundException e){
            System.out.println("Failed to find the desired file");
        }
        catch (IOException e){
            System.out.println("An error occurred while reading the file");
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Invalid string format entered");
        }
        System.out.println(eventList.toString());
    }

}
