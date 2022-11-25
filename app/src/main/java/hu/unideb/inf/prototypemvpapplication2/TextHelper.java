package hu.unideb.inf.prototypemvpapplication2;

import java.util.List;
import java.util.Random;

public class TextHelper {

    public static String getText(List<String> i) {

        Random random = new Random();
        int index = random.nextInt(i.size());
        String n = i.get(index);

        return n;
    }
}
