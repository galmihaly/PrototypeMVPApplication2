package hu.unideb.inf.prototypemvpapplication2;

public interface IModelTwo {

    interface OnFinishedListener {
        void onFinished2(ModelTwo modelTwo);
    }

    void addInteger(IModelTwo.OnFinishedListener onFinishedListener);
}
