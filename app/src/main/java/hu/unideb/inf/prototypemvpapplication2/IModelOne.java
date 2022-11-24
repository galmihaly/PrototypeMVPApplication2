package hu.unideb.inf.prototypemvpapplication2;

public interface IModelOne {

    interface OnFinishedListener {
        void onFinished(ModelOne modelOne);
    }

    void getNextCourse(IModelOne.OnFinishedListener onFinishedListener);
}
