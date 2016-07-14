package io.github.yuweiguocn.databindingdemo.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by growth on 7/9/16.
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
