package hu.unideb.inf.prototypemvpapplication2;

public interface IMainActivityPresenter {

    void onButtonClick();
    void onAddButtonClick();
    void onDestroy();
    Model GetModel();
    ModelTwo GetModelTwo();
    void SetModelTwo(ResultModel2 resultModel2);
    void SetModel(ResultModel resultModel);
}
