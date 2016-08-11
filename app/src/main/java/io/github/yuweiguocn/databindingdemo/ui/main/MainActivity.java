package io.github.yuweiguocn.databindingdemo.ui.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.yuweiguocn.databindingdemo.R;
import io.github.yuweiguocn.databindingdemo.adapter.UserAdapter;
import io.github.yuweiguocn.databindingdemo.base.BaseActivity;
import io.github.yuweiguocn.databindingdemo.bean.Score;
import io.github.yuweiguocn.databindingdemo.bean.User;
import io.github.yuweiguocn.databindingdemo.databinding.ActivityMainBinding;
import io.github.yuweiguocn.databindingdemo.databinding.ViewInflateTestBinding;
import io.github.yuweiguocn.databindingdemo.ui.about.AboutActivity;

public class MainActivity extends BaseActivity implements MainContract.View{


    private MainPresenter presenter;
    private ActivityMainBinding binding;
    private Score score;

    private UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.includeToolbar.toolbar);

        ViewInflateTestBinding inflateTestBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_inflate_test, null, false);
        binding.llContainer.addView(inflateTestBinding.getRoot());

        presenter = new MainPresenter(this);

        binding.setHandlers(new MainClickHandlers());
        binding.setPresenter(presenter);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("problem", "what's you name?");
        map.put("name", "jack");
        map.put("age", 18);
        binding.setMap(map);


        score = new Score();
        score.setEnglish("请输入英语成绩");
        score.setMath("请输入数学成绩");
        binding.setScore(score);

        binding.etMath.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        binding.etMath.setOnEditorActionListener(new MyAction());

        binding.etEnglish.setImeOptions(EditorInfo.IME_ACTION_DONE);
        binding.etEnglish.setOnEditorActionListener(new MyAction());

        binding.etPhone.setImeOptions(EditorInfo.IME_ACTION_DONE);
        binding.etPhone.setOnEditorActionListener(new MyAction());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ct);
        linearLayoutManager.setAutoMeasureEnabled(true);
        binding.rv.setLayoutManager(linearLayoutManager);
        binding.rv.setHasFixedSize(true);
        binding.rv.setNestedScrollingEnabled(false);

        adapter = new UserAdapter(this);
        binding.rv.setAdapter(adapter);

        presenter.loadData();
    }

    public class MyAction implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                handleInputData();
                return true;
            }
            switch (actionId) {
                case EditorInfo.IME_ACTION_DONE:
                    handleInputData();
                    break;
                case EditorInfo.IME_ACTION_NEXT:
                    binding.etEnglish.requestFocus();
                    break;
            }
            return true;
        }
    }

    private void handleInputData() {
        String math = binding.etMath.getText().toString();
        String english = binding.etEnglish.getText().toString();
        String phone = binding.etPhone.getText().toString();
        if (!TextUtils.isEmpty(math)) {
            score.setMath("数学成绩："+math);
        }
        if (!TextUtils.isEmpty(english)) {
            score.setEnglish("英语成绩："+english);
        }

        if (!TextUtils.isEmpty(phone)) {
            binding.getUser().phone.set("电话："+phone);
        }
        hideKeybord(binding.etEnglish);
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
    public void onSuccessUserList(List<User> users) {
        adapter.setDatas(users);
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

    private void hideKeybord(EditText keyWord) {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(keyWord.getWindowToken(), 0);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
