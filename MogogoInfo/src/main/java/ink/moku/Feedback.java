package ink.moku;

import ink.moku.util.String2Txt;

import java.io.File;

public class Feedback {
    public Boolean Feedback(String text) {
        File file = new File("./data/mogogo/info/Feedback.txt");
        String2Txt string2Txt = new String2Txt();
        return string2Txt.String2Txt(file, text);
    }
}
