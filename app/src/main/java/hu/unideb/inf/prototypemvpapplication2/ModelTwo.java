package hu.unideb.inf.prototypemvpapplication2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModelTwo implements IModelTwo{

    private int number;

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());

    public ModelTwo(int number) {
        this.number = number;
    }

    @Override
    public void addInteger(ModelTwo.OnFinishedListener onFinishedListener) {
        executor.execute(() -> {

            int result = this.getNumber() + 1;
            this.setNumber(result);

            handler.postDelayed(()-> {
                onFinishedListener.onFinished2(this);
            }, 500);
        });
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
