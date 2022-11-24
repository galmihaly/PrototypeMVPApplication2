package hu.unideb.inf.prototypemvpapplication2;

public interface IMainActivityView {

    void showProgress1();
    void showProgress2();

    ModelOne GetModel();
    ModelTwo GetModelTwo();
    void SetModelTwo(ResultModelTwo resultModelTwo);
    void SetModel(ResultModelOne resultModelOne);

}
