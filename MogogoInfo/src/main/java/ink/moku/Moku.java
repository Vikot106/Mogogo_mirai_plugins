package ink.moku;

import ink.moku.util.RandomPic;

import java.io.File;

public class Moku {
    public File getPic() {
        return new File("./data/mogogo/info/pic/moku/" +
                new RandomPic().getPic("./data/mogogo/info/Moku.txt"));
    }
}
