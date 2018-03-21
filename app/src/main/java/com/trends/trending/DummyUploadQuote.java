package com.trends.trending;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.trends.trending.model.Quote;
import com.trends.trending.utils.FirebaseHelper;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by USER on 3/8/2018.
 */

public class DummyUploadQuote extends AppCompatActivity {

    @BindView(R.id.author)
    EditText author;
    @BindView(R.id.quote)
    EditText quote;
    FirebaseHelper firebaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy_activity_quote);
        ButterKnife.bind(this);
        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseHelper = new FirebaseHelper(firebaseDatabase, DummyUploadQuote.this);

    }

    public void uploadQuote(View view) {

        if (firebaseHelper.uploadQuote(new Quote(author.getText().toString(), quote.getText().toString())))
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }
}
