package io.github.yuweiguocn.databindingdemo.bean;

import android.databinding.ObservableBoolean;

/**
 * Created by growth on 7/7/16.
 */
public class User {
    public final String name;
    public final String age;
    public final String include;
    public ObservableBoolean isComplete;

    public User(String name, String age, String include, boolean isComplete) {
        this.name = name;
        this.age = age;
        this.include = include;
        this.isComplete = new ObservableBoolean(isComplete);
    }
}
