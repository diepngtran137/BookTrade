package info.diepnguyen.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class showAllBookActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayBooks;
    String[] books;
    ListView listView;
    EditText search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_book);

        listView = (ListView) findViewById(R.id.listBook);
        search = (EditText) findViewById(R.id.searchBook);
        initList();

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    initList();
                }
                else {
                    //perform search
                    searchBook(s.toString());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Log.i("Show all book Activity","now running onCreate");

    }

    public void initList() {
        books = getResources().getStringArray(R.array.book);
        arrayBooks = new ArrayList<>(Arrays.asList(books));

        adapter = new ArrayAdapter<String>(
                showAllBookActivity.this,
                R.layout.book_list,
                R.id.name,
                arrayBooks);
        listView.setAdapter(adapter);
    }

    public void searchBook(String txtToSearch){
        for (String book:books) {
            if(!book.contains(txtToSearch)){
                arrayBooks.remove(book);
            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Show all book Activity","now running onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Show all book Activity","now running onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Show all book Activity","now running onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Show all book Activity","now running onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Show all book Activity","now running onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Show all book Activity","now running onDestroy");
    }



}
