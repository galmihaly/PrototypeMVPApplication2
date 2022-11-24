package hu.unideb.inf.prototypemvpapplication2;

public interface IMainActivityView {

    // method to display progress bar
    // when next random course details
    // is being fetched
    void showProgress1();
    void showProgress2();

    // method to hide progress bar
    // when next random course details
    // is being fetched
    void hideProgress1();
    void hideProgress2();

    // method to set random
    // text on the TextView
    void setString(String string);

    void setInteger(String i);

    Model GetModel();
    ModelTwo GetModelTwo();
    void SetModelTwo(ResultModel2 resultModel2);
    void SetModel(ResultModel resultModel);

}
