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
        User user = new User("张三", "28", "", true, "","http://i-cdn.phonearena.com/images/article/53617-image/Best-new-Android-iOS-and-Windows-Phone-apps-of-February-2014.jpg");
        users.add(user);
        user = new User("李四", "23", "", true, "","http://i-cdn.phonearena.com/images/article/80839-image/How-Android-N-is-being-built-to-prevent-the-next-Stagefright.jpg");
        users.add(user);
        user = new User("王老五", "25", "", true, "","http://www.shake-them-all.net/files/skins/69/preview.png");
        users.add(user);
        user = new User("洪荒之力", "18", "", true, "","http://i-cdn.phonearena.com/images/article/68492-image/This-Android-6.0-Muffin-video-concept-calls-for-a-Multi-Window-feature-more-Material-Design-goodness.jpg");
        users.add(user);
        view.onSuccessUserList(users);
        view.onSuccess(new User("我是姓名 ，通过方法引用处理了点击事件", "我是年龄 ，通过监听绑定处理了点击事件","我是传递到include的文本",true,"请输入你的电话",""));
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
