package io.github.yuweiguocn.databindingdemo.bean;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

/**
 * Created by growth on 7/7/16.
 */
public class User {
    public final String name;
    public final String age;
    public final String include;
    public ObservableBoolean isComplete;
    public final ObservableField<String> phone = new ObservableField<>();

    public final String url;

    public User(String name, String age, String include, boolean isComplete,String phone,String url) {
        this.name = name;
        this.age = age;
        this.include = include;
        this.isComplete = new ObservableBoolean(isComplete);
        this.phone.set(phone);
        this.url = url;
    }
}
