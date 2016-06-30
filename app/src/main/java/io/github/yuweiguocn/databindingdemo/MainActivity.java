package io.github.yuweiguocn.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;

import io.github.yuweiguocn.databindingdemo.databinding.ActivityMainBinding;
import io.github.yuweiguocn.databindingdemo.databinding.ViewInflateTestBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.tvHello.setText("Hi,I'm from DataBinding.");
        binding.tvWeibo.setText(Html.fromHtml("weibo: <font color=\"#3F51B5\">@于卫国</font>"));
        binding.tvWeibo.setOnClickListener(this);
        binding.tvGithub.setText(Html.fromHtml("GitHub: <font color=\"#3F51B5\">http://github.com/yuweiguocn/</font>"));
        binding.tvGithub.setOnClickListener(this);
        binding.tvBlog.setText(Html.fromHtml("blog: <font color=\"#3F51B5\">http://yuweiguocn.github.io/</font>"));
        binding.tvBlog.setOnClickListener(this);
        binding.tvEmail.setText(Html.fromHtml("gmail: <font color=\"#3F51B5\">yuweiguocn@gmail.com</font>"));


        ViewInflateTestBinding inflateTestBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_inflate_test, null, true);
        binding.llContainer.addView(inflateTestBinding.getRoot());

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_blog:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://yuweiguocn.github.io/"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.tv_weibo:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://weibo.com/weiguo58"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

                break;
            case R.id.tv_github:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://github.com/yuweiguocn/"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

                break;

        }


    }
}
