package hu.unideb.inf.prototypemvpapplication2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdditionRequestModelTwo {

    //model adattagjai
    public int number;

    //konstruktor
    public AdditionRequestModelTwo(int number) {
        this.number = number;
    }
}
