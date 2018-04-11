package com.example.rodneytressler.week2assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private WelcomeFragment welcomeFragment;

    public static final String ACCOUNT = "Account info";

    @BindView(R.id.input_name)
    protected EditText nameInput;
    @BindView(R.id.input_email)
    protected EditText emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void toastRegistrationFailure() {
        Toast.makeText(this, "Please enter all fields first!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_register)
    protected void registerButtonClicked() {
        if (nameInput.getText().length() == 0 || emailInput.getText().length() == 0) {
            toastRegistrationFailure();
        } else {
            welcomeFragment = WelcomeFragment.newInstance();
            Account account = new Account(nameInput.getText().toString(), emailInput.getText().toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable(ACCOUNT, account);
            welcomeFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, welcomeFragment).commit();
        }
    }
}
