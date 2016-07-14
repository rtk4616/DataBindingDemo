package io.github.yuweiguocn.databindingdemo.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import io.github.yuweiguocn.databindingdemo.R;
import io.github.yuweiguocn.databindingdemo.base.BaseActivity;
import io.github.yuweiguocn.databindingdemo.bean.User;
import io.github.yuweiguocn.databindingdemo.databinding.ActivityMainBinding;
import io.github.yuweiguocn.databindingdemo.databinding.ViewInflateTestBinding;
import io.github.yuweiguocn.databindingdemo.ui.about.AboutActivity;

public class MainActivity extends BaseActivity implements MainContract.View{


    private MainPresenter presenter;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.includeToolbar.toolbar);

        ViewInflateTestBinding inflateTestBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_inflate_test, null, false);
        binding.llContainer.addView(inflateTestBinding.getRoot());

        presenter = new MainPresenter(this);
        presenter.loadData();

        binding.setHandlers(new MainClickHandlers());
        binding.setPresenter(presenter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this, AboutActivity.class));
        return true;
    }


    @Override
    public void onSuccess(User user) {
        if (binding != null) {
            binding.setUser(user);
        }
    }

    @Override
    public void onSuccess(List<String> strings) {
        if (binding != null) {
            binding.setStringList(strings);
        }
    }

    @Override
    public void invalidateAll() {
        if (binding != null) {
            binding.invalidateAll();
        }
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
