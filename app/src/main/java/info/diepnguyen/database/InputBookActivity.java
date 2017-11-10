package info.diepnguyen.database;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InputBookActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    String genreTxt;
    Float rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_book);

        final EditText bookName = (EditText) findViewById(R.id.book_name);
        final EditText author = (EditText) findViewById(R.id.book_author);
        final EditText date = (EditText) findViewById(R.id.pub_date);

        spinner = (Spinner) findViewById(R.id.genre_spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.genre_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                genreTxt = parent.getItemAtPosition(position).toString();
                //Toast.makeText(getBaseContext(),+"selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        RatingBar star = (RatingBar) findViewById(R.id.ratingBar);
        star.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
                rating = v;
            }
        });

        Button addBtn = (Button) findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Book info", Context.MODE_PRIVATE);

                final SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("bookname",bookName.getText().toString());
                editor.putString("author",author.getText().toString());
                editor.putString("date",date.getText().toString());
                editor.putString("genre",genreTxt);
                editor.putFloat("rate",rating);

                editor.commit();

                //Toast.makeText(InputBookActivity.this,"Add Book successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InputBookActivity.this,ShowBook.class);
                startActivity(intent);
            }
        });
        Log.i("Input Book Activity","now running onCreate");
    }

    public void viewAllBook(View view){
        Intent intent = new Intent(InputBookActivity.this,showAllBookActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Input Book Activity","now running onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Input Book Activity","now running onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Input Book Activity","now running onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Input Book Activity","now running onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Input Book Activity","now running onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Input Book Activity","now running onDestroy");
    }


}
