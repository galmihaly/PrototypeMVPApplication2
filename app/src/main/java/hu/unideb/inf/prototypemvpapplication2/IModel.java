package hu.unideb.inf.prototypemvpapplication2;

public interface IModel {

    interface OnFinishedListener {
        void onFinished(Model model);
    }

    void getNextCourse(IModel.OnFinishedListener onFinishedListener);
}
