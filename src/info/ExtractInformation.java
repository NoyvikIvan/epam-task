package info;

public class ExtractInformation {

    public static String catLine(String line) {
        return line.substring(line.indexOf(':')+2);
    }

    public static String catLine(String line, int quantity)  {
        String resultLine = line;
        for (int i = 0; i < quantity; i++) {
            resultLine = catLine(resultLine);
        }
        return resultLine;
    }
    public static String extractInfo(String line) {
               return line.substring(0, line.indexOf(';'));
    }

    public static String extractLastInfo(String line)  {
       return line.substring(0, line.indexOf('.'));
    }


}