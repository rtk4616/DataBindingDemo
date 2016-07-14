package io.github.yuweiguocn.databindingdemo.ui.about;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import io.github.yuweiguocn.databindingdemo.R;
import io.github.yuweiguocn.databindingdemo.base.BaseActivity;
import io.github.yuweiguocn.databindingdemo.bean.About;
import io.github.yuweiguocn.databindingdemo.databinding.ActivityAboutBinding;

public class AboutActivity extends BaseActivity implements AboutContract.View {

    private ActivityAboutBinding binding;

    AboutPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about);
        setSupportActionBar(binding.includeToolbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.setHandlers(new AboutClickHandlers());
        presenter = new AboutPresenter(this);
        presenter.loadData();
    }

    @Override
    public void onSucess(About about) {
        binding.setAbout(about);
    }

    @Override
    public void setPresenter(AboutContract.Presenter presenter) {

    }
}
