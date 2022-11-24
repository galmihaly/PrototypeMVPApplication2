package hu.unideb.inf.prototypemvpapplication2;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

public class MainActivityPresenter implements IMainActivityPresenter{

    private IMainActivityView iMainActivityView;
    private List<IMainActivityView> iMainActivityViewList = new ArrayList<>();


    public MainActivityPresenter(IMainActivityView iMainActivityView) {
        this.iMainActivityView = iMainActivityView;
    }

    @Override
    public void onButtonClick() {

        if(iMainActivityView == null) return;

        iMainActivityViewList.add(iMainActivityView);
        iMainActivityView.showProgress1();

        Model model = GetModel();
        model.getNextCourse(this::msda);
    }

    void msda(Model model){
        if (iMainActivityView == null) return;

        String c = model.getResult();
        String a = String.valueOf(c);
        boolean b = true;

        ResultModel resultModel = new ResultModel(a, b);

        SetModel(resultModel);
    }

    @Override
    public void onAddButtonClick() {

        if(iMainActivityView == null) return;

        iMainActivityViewList.add(iMainActivityView);
        iMainActivityView.showProgress2();

        ModelTwo modelTwo = GetModelTwo();
        modelTwo.addInteger(this::msda2);
    }

    void msda2(ModelTwo modelTwo){
        if (iMainActivityView == null) return;

        int a = modelTwo.getNumber();
        boolean b = (a%2)==0;

        ResultModel2 resultModel2 = new ResultModel2(a, b);

        SetModelTwo(resultModel2);
    }

    @Override
    public void onDestroy() {
        iMainActivityView = null;
    }

    @Override
    public Model GetModel() {
        return iMainActivityView.GetModel();
    }

    @Override
    public ModelTwo GetModelTwo() {
        return iMainActivityView.GetModelTwo();
    }

    @Override
    public void SetModelTwo(ResultModel2 resultModel2) {

        iMainActivityView.SetModelTwo(resultModel2);
    }

    @Override
    public void SetModel(ResultModel resultModel) {
        iMainActivityView.SetModel(resultModel);
    }

}
