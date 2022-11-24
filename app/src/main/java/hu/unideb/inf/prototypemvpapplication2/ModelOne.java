package hu.unideb.inf.prototypemvpapplication2;

import android.os.Looper;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.os.Handler;

public class ModelOne implements IModelOne {

    private List<String> arrayList = Arrays.asList(
            "DSA Self Paced: Master the basics of Data Structures and Algorithms to solve complex problems efficiently. ",
            "Placement 100: This course will guide you for placement with theory,lecture videos, weekly assignments " +
                    "contests and doubt assistance.",
            "Amazon SDE Test Series: Test your skill & give the final touch to your preparation before applying for " +
                    "product based against like Amazon, Microsoft, etc.",
            "Complete Interview Preparation: Cover all the important concepts and topics required for the interviews. " +
                    "Get placement ready before the interviews begin",
            "Low Level Design for SDE 1 Interview: Learn Object-oriented Analysis and Design to prepare for " +
                    "SDE 1 Interviews in top companies"
    );

    private String result;

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());

    public ModelOne(String result) {
        this.result = result;
    }

    @Override
    public void getNextCourse(ModelOne.OnFinishedListener onFinishedListener) {

        executor.execute(() ->{

            for (int i = 0; i < 60; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.setResult(getRandomString());

            handler.postDelayed(()-> {
                onFinishedListener.onFinished(this);
            }, 500);
        });
    }

    private String getRandomString() {

        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
