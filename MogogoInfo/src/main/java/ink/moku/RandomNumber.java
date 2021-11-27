package ink.moku;

import java.util.Random;

public class RandomNumber {
    public String RandomNumber(String limit) {
        Random r = new Random();
        return String.valueOf(r.nextInt(Integer.parseInt(limit) + 1));
    }
}
