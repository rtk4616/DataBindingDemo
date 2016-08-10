package io.github.yuweiguocn.databindingdemo.ui.main;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.github.yuweiguocn.databindingdemo.bean.User;
import io.github.yuweiguocn.databindingdemo.util.T;

/**
 * Created by growth on 7/7/16.
 */
public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;

    @Override
    public void loadData() {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User("姓名"+i, "年龄"+i, "", true, "");
            users.add(user);
        }
        view.onSuccessUserList(users);
        view.onSuccess(new User("我是姓名 ，通过方法引用处理了点击事件", "我是年龄 ，通过监听绑定处理了点击事件","我是传递到include的文本",true,"请输入你的电话"));
        List<String> strings = new ArrayList<>();
        strings.add("我是List中的数据");
        view.onSuccess(strings);
    }

    public void onClick(Context ct) {
        T.s(ct, "通过监听绑定处理的点击事件");
    }

    public void onCompletedChanged(Context ct, User user, boolean completed) {
        user.isComplete.set(completed);
        if (completed) {
            T.s(ct, "comleted");
        } else {
            T.s(ct, "uncomleted");
        }
    }

    public boolean onHelloLongClick(Context ct) {
        T.s(ct, "Handle long click");
        return true;
    }



    public MainPresenter(MainContract.View view) {
        this.view = view;
    }
}
