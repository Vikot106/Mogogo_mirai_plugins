package ink.moku.util;

import java.io.File;
import java.io.FileOutputStream;

public class String2Txt {

    public Boolean String2Txt(File file, String text) {
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            fos.write(text.getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
