package hu.unideb.inf.prototypemvpapplication2;

public interface IMainActivityPresenter {

    void onButtonClick();
    void onAddButtonClick();
    void onDestroy();
    ModelOne GetModel();
    ModelTwo GetModelTwo();
    void SetModelTwo(ResultModelTwo resultModelTwo);
    void SetModel(ResultModelOne resultModelOne);
}
