package ink.moku;

import ink.moku.util.OS2String;
import ink.moku.util.Txt2String;

import java.io.File;

public class Status {
    public String Status(){
        OS2String os2String = new OS2String();
        File file = new File("./data/mogogo/info/Status.txt");
        Txt2String txt2String = new Txt2String();
        String result = txt2String.Txt2String(file);
        result = result.replaceAll("<os>",os2String.getOS());
        result = result.replaceAll("<ram>",os2String.getRAM());
        return result;
    }
}
