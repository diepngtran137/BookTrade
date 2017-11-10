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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private Button btnSignUp;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignUp = (Button) findViewById(R.id.signup_btn);

        inputEmail.setText("");
        inputPassword.setText("");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length() <6){
                    Toast.makeText(getApplicationContext(),"Password should contain 6 characters",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                //create new user
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignUp.this,"Create new user with Email and Password:onComplete: "+task.isSuccessful(),Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);

                        if(!task.isSuccessful()){
                            Toast.makeText(SignUp.this,"Authentication fail: "+task.getException(),Toast.LENGTH_LONG).show();

                        }
                        else {
                            Intent intent = new Intent(SignUp.this,InputBookActivity.class);
                            startActivity(intent);

                        }
                    }
                });
            }
        });

        Log.i("Sign up Activity","now running onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Sign up Activity","now running onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Sign up Activity","now running onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Sign up Activity","now running onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Sign up Activity","now running onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Sign up Activity","now running onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Sign up Activity","now running onDestroy");
    }

}
