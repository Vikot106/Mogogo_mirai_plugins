package ink.moku.util;

import java.io.*;

public class Txt2String {
    public String Txt2String(File file) {
        String result = "";
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String s = null;
            Boolean flag = false;
            while ((s = br.readLine()) != null) {
                if (flag)
                    result = result + "\n";
                result = result + s;
                flag = true;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
