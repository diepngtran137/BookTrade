package info.diepnguyen.database;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Map;

public class ShowBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView bookName = (TextView) findViewById(R.id.book_name);
        TextView authorName = (TextView) findViewById(R.id.author);
        TextView genreTxt = (TextView) findViewById(R.id.genre_txt);
        TextView dateTxt = (TextView) findViewById(R.id.date);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar2);
        WebView web = (WebView) findViewById(R.id.webView);
        web.getSettings().setJavaScriptEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowBook.this, InputBookActivity.class);
                startActivity(intent);
            }
        });


        SharedPreferences sharedPreferences = getSharedPreferences("Book info", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("bookname", "");
        String author = sharedPreferences.getString("author", "");
        String date = sharedPreferences.getString("date", "");
        String genre = sharedPreferences.getString("genre", "");
        Float rating = sharedPreferences.getFloat("rate", 0);

        String url = "https://en.wikipedia.org/wiki/" + name;

        bookName.setText(name);
        authorName.setText(author);
        genreTxt.setText(genre);
        dateTxt.setText(date);
        ratingBar.setRating(rating);
        web.loadUrl(url);

        Log.i("Show Book Activity","now running onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Show Book Activity","now running onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Show Book Activity","now running onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Show Book Activity","now running onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Show Book Activity","now running onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Show Book Activity","now running onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Show Book Activity","now running onDestroy");
    }



}
