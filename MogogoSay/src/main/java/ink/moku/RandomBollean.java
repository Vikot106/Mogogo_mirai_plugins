package ink.moku;

import java.util.Random;

public class RandomBollean {
    public Boolean getRandom(){
        Random r = new Random();
        if(r.nextBoolean()) {
            return true;
        }else
            return false;
    }
}
