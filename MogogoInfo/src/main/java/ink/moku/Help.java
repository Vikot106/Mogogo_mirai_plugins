package ink.moku;

import ink.moku.util.Txt2String;

import java.io.File;

public class Help {
    public String Help(){
        File file = new File("./data/mogogo/info/Help.txt");
        Txt2String txt2String = new Txt2String();
        String result = txt2String.Txt2String(file);
        return result;
    }
}
