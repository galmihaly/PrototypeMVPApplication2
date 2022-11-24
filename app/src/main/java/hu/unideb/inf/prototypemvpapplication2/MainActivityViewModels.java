package hu.unideb.inf.prototypemvpapplication2;

public class MainActivityViewModels {
    private Model model;
    private ModelTwo modelTwo;

    public MainActivityViewModels(Model model, ModelTwo modelTwo) {
        this.model = model;
        this.modelTwo = modelTwo;
    }

    public Model getModel() {
        return model;
    }

    public ModelTwo getModelTwo() {
        return modelTwo;
    }
}
