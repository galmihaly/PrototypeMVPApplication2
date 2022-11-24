package hu.unideb.inf.prototypemvpapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements IMainActivityView{

    // creating object of TextView class
    private TextView textView;

    // creating object of Button class
    private Button button;

    // creating object of ProgressBar class
    private ProgressBar progressBar;

    // creating object of Presenter interface in Contract
    MainActivityPresenter presenter;

    private Button addButton;
    private TextView numberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning ID of the TextView
        textView = findViewById(R.id.textView);

        // assigning ID of the Button
        button = findViewById(R.id.button);

        // assigning ID of the ProgressBar
        progressBar = findViewById(R.id.progressBar);

        // instantiating object of Presenter Interface
        presenter = new MainActivityPresenter(this);

        // operations to be performed when
        // user clicks the button

        button.setOnClickListener(v -> presenter.onButtonClick());

        //-------------------------------------------------------------------------------------------------
        numberTextView = findViewById(R.id.numberTextView);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(view -> presenter.onAddButtonClick());

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    // method to display the Course Detail TextView
    public void showProgress1() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgress2() {
        numberTextView.setVisibility(View.INVISIBLE);
    }

    @Override
    // method to hide the Course Detail TextView
    public void hideProgress1() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress2() {
        numberTextView.setVisibility(View.VISIBLE);
    }

    @Override
    // method to set random string
    // in the Course Detail TextView
    public void setString(String string) {
        textView.setText(string);
    }

    @Override
    public void setInteger(String i) {
        numberTextView.setText(i);
    }

    @Override
    public Model GetModel() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
        return new Model(textView.getText().toString());
    }

    @Override
    public void SetModel(ResultModel resultModel) {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
        textView.setText(resultModel.resultText);
    }

    @Override
    public ModelTwo GetModelTwo() {
        numberTextView.setVisibility(View.INVISIBLE);
        return new ModelTwo(Integer.parseInt(numberTextView.getText().toString()));
    }

    @Override
    public void SetModelTwo(ResultModel2 resultModel2) {
        numberTextView.setVisibility(View.VISIBLE);
        numberTextView.setText(String.valueOf(resultModel2.resultNumber));
    }
}