package com.indatus.android.timber.sample;
//  Created by jonstaff on 6/26/14.

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.indatus.android.timber.R;
import com.indatus.android.timber.library.Timber;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.verbose).setOnClickListener(this);
        findViewById(R.id.debug).setOnClickListener(this);
        findViewById(R.id.info).setOnClickListener(this);
        findViewById(R.id.warn).setOnClickListener(this);
        findViewById(R.id.error).setOnClickListener(this);
        findViewById(R.id.wtf).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.verbose:
                Timber.v("Logging verbose");
                break;
            case R.id.debug:
                Timber.d("Logging debug");
                break;
            case R.id.info:
                Timber.i("Logging info");
                break;
            case R.id.warn:
                Timber.w("Logging warn");
                break;
            case R.id.error:
                Timber.e("Logging error");
                break;
            case R.id.wtf:
                Timber.wtf("Logging wtf");
                break;
            default:
                break;
        }
    }
}
