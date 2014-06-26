package com.indatus.android.timber.sample;
//  Created by jonstaff on 6/26/14.

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.indatus.android.timber.R;
import com.indatus.android.timber.library.Timber;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Timber.d("this is a test");
            }
        });
    }
}
