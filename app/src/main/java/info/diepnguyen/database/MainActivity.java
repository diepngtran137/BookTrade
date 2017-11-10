package info.diepnguyen.database;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnLogIn,btnSignUp;
    private ProgressBar progressBar;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnLogIn = (Button) findViewById(R.id.login_btn);
        btnSignUp= (Button) findViewById(R.id.signup_btn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Enter Email Address",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!email.contains("@")){
                    Toast.makeText(getApplicationContext(),"Invalid Email Address. Email should contain @",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length() <6){
                    Toast.makeText(getApplicationContext(),"Password should contain 6 characters",Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                 auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         progressBar.setVisibility(View.GONE);
                         if(!task.isSuccessful()){
                             Toast.makeText(MainActivity.this,"The User is invalid ",Toast.LENGTH_LONG).show();
                         }
                         else {
                             Intent intent = new Intent(MainActivity.this,InputBookActivity.class);
                             startActivity(intent);
                         }
                     }
                 });
            }
        });

        Log.i("Log In Activity","now running onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Log In Activity","now running onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Log In Activity","now running onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Log In Activity","now running onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Log In Activity","now running onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Log In Activity","now running onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Log In Activity","now running onDestroy");
    }
}
