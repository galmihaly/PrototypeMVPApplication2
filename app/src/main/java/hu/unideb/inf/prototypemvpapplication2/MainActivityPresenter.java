package hu.unideb.inf.prototypemvpapplication2;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Consumer;

public class MainActivityPresenter implements IMainActivityPresenter{

    private IMainActivityView iMainActivityView;

    public MainActivityPresenter(IMainActivityView iMainActivityView) {
        this.iMainActivityView = iMainActivityView;
    }

    @Override
    public void onButtonClick(ModelOne modelOne) { // VárakozósButton
        iMainActivityView.showProgress1();
        work(modelOne, this::maki1, this::maki2);
    }

//public void dolgoz(Function<Void,Object> maki1, Function<Object,Void> maki2 ){
    public <T,R> void work(T model, Function<T,R> function1, Consumer<R> function2 ){
        if(iMainActivityView == null) return;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            try
            {
                R o = function1.apply(model);
                LogObjects.error("hello");
                handler.postDelayed(() -> {
                    function2.accept((R)o);
                }, 500);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }

    public ResultModelOne maki1(ModelOne modelOne){

        for (int i = 0; i < 60; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String n = TextHelper.getText(modelOne.arrayList);
        boolean i = getModelOneBoolean(n);
        ResultModelOne resultModelOne = new ResultModelOne(n, i);
        return resultModelOne;
    }

    public void maki2(ResultModelOne o){
        if(o != null) iMainActivityView.SetModel(o);
    }

    public boolean getModelOneBoolean(String n){
        boolean b = true;
        return b;
    }

    @Override
    public void onAddButtonClick(AdditionRequestModelTwo additionRequestModelTwo) {

        iMainActivityView.showProgress2();
        work(additionRequestModelTwo, this::osszead1, iMainActivityView::SetModelTwo);
    }

    public AdditionResponseModel osszead1(AdditionRequestModelTwo additionRequestModelTwo)
    {
        int a = AdditionHelper.addInteger(additionRequestModelTwo.number, 1);
        boolean b = getModelTwoBoolean(additionRequestModelTwo.number); // remBy2
        AdditionResponseModel additionResponseModel = new AdditionResponseModel(a,b); // OsszeadsResponseModel
        return additionResponseModel;
    }

    @Override
    public boolean getModelTwoBoolean(int a){
        boolean b = (a % 2) == 0;
        return b;
    }
}
