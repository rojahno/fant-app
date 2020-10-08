package no.ntnu.obligapp.ui.register;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import no.ntnu.obligapp.R;
import no.ntnu.obligapp.data.Result;

public class RegisterView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        final Button backButton = findViewById(R.id.backButton);
        final EditText firstNameEditText = findViewById(R.id.firstNameInput);
        final EditText lastNameEditText = findViewById(R.id.lastNameInput);
        final EditText emailEditText = findViewById(R.id.emailInput);
        final EditText passwordEditText = findViewById(R.id.passwordEdit);
        final Button registerButton = findViewById(R.id.registerButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View v) {

                new AsyncTask<Void, Void, Result>() {
                    Result result = null;
                    @Override
                    protected Result doInBackground(Void... voids) {
                        result = UserRegister.registerUser(48,firstNameEditText.getText().toString(), lastNameEditText.getText().toString(),
                                emailEditText.getText().toString(),passwordEditText.getText().toString());
                        return result;
                    }

                    @Override
                    protected void onPostExecute(Result result) {
                        if (result instanceof Result.Success){
                            firstNameEditText.setTextColor(Color.BLUE);
                        }
                        else{
                            lastNameEditText.setTextColor(Color.GREEN);
                        }

                }
            }.execute();
        }

        });
    };
}





