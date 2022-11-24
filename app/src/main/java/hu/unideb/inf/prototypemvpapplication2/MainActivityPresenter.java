package hu.unideb.inf.prototypemvpapplication2;

import java.util.ArrayList;
import java.util.List;

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

        ModelOne modelOne = GetModel();
        modelOne.getNextCourse(this::initResultModelOne);
    }

    void initResultModelOne(ModelOne modelOne){
        if (iMainActivityView == null) return;

        String c = modelOne.getResult();
        String a = String.valueOf(c);
        boolean b = true;
        ResultModelOne resultModelOne = new ResultModelOne(a, b);

        SetModel(resultModelOne);
    }

    @Override
    public void onAddButtonClick() {

        if(iMainActivityView == null) return;

        iMainActivityViewList.add(iMainActivityView);
        iMainActivityView.showProgress2();

        ModelTwo modelTwo = GetModelTwo();
        modelTwo.addInteger(this::initResultModelTwo);
    }

    void initResultModelTwo(ModelTwo modelTwo){
        if (iMainActivityView == null) return;

        int a = modelTwo.getNumber();
        boolean b = (a%2)==0;

        ResultModelTwo resultModelTwo = new ResultModelTwo(a, b);

        SetModelTwo(resultModelTwo);
    }

    @Override
    public void onDestroy() {
        iMainActivityView = null;
    }

    @Override
    public ModelOne GetModel() {
        return iMainActivityView.GetModel();
    }

    @Override
    public ModelTwo GetModelTwo() {
        return iMainActivityView.GetModelTwo();
    }

    @Override
    public void SetModelTwo(ResultModelTwo resultModelTwo) {iMainActivityView.SetModelTwo(resultModelTwo);}

    @Override
    public void SetModel(ResultModelOne resultModelOne) {
        iMainActivityView.SetModel(resultModelOne);
    }

}
