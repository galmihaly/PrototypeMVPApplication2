package hu.unideb.inf.prototypemvpapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements IMainActivityView{

    // creating object of TextView class
    private TextView textView;

    // creating object of Button class
    private Button addTextButton;

    // creating object of ProgressBar class
    private ProgressBar progressBar;

    // creating object of Presenter interface in Contract
    MainActivityPresenter mainActivityPresenter;

    private Button addNumberButton;
    private TextView numberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        addTextButton = findViewById(R.id.addTextButton);
        progressBar = findViewById(R.id.progressBar);
        numberTextView = findViewById(R.id.numberTextView);
        addNumberButton = findViewById(R.id.addNumberButton);

        mainActivityPresenter = new MainActivityPresenter(this);

        addTextButton.setOnClickListener(v -> {

            progressBar.setVisibility(View.VISIBLE);
            textView.setVisibility(View.INVISIBLE);
            ModelOne modelOne = new ModelOne(textView.getText().toString());

            mainActivityPresenter.onButtonClick(modelOne);
        });
        addNumberButton.setOnClickListener(view -> {

            numberTextView.setVisibility(View.INVISIBLE);
            AdditionRequestModelTwo additionRequestModelTwo = new AdditionRequestModelTwo(Integer.parseInt(numberTextView.getText().toString()));

            mainActivityPresenter.onAddButtonClick(additionRequestModelTwo);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showProgress1() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgress2() {
        numberTextView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void SetModel(ResultModelOne resultModelOne) {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
        textView.setText(resultModelOne.resultText);
    }

    @Override
    public void SetModelTwo(AdditionResponseModel additionResponseModel) {
        numberTextView.setVisibility(View.VISIBLE);
        numberTextView.setText(String.valueOf(additionResponseModel.resultNumber));
    }
}