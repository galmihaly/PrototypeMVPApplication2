package hu.unideb.inf.prototypemvpapplication2;

public interface IMainActivityPresenter {

    void onButtonClick(ModelOne modelOne);
    void onAddButtonClick(AdditionRequestModelTwo additionRequestModelTwo);
    boolean getModelOneBoolean(String n);
    boolean getModelTwoBoolean(int a);
}
