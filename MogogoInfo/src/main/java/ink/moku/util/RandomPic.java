package ink.moku.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomPic {
    public String getPic(String txtPath){
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(txtPath)), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            InputStreamReader nisr = new InputStreamReader(new FileInputStream(new File(txtPath)), "UTF-8");
            BufferedReader brb = new BufferedReader(nisr);
            int count = 0;
            String s = null;
            while ((s = br.readLine()) != null) {
                if (!s.trim().equals("")) {
                    count++;
                }
            }
            Random random = new Random();
            int r = random.nextInt(count);
            String name = null;
            for (int i = 0; i <= r; i++) {
                name = brb.readLine();
            }
            System.out.println(name);
            br.close();
            brb.close();
            return name;
        } catch (Exception e) {
            e.printStackTrace();
            return "404.jpg";
        }
    }
}
