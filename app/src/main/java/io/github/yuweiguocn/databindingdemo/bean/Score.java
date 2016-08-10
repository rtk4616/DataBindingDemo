package io.github.yuweiguocn.databindingdemo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import io.github.yuweiguocn.databindingdemo.BR;

/**
 * Created by growth on 8/1/16.
 */
public class Score extends BaseObservable {
    private String math;
    private String english;

    @Bindable
    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
        notifyPropertyChanged(BR.math);
    }

    @Bindable
    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
        notifyPropertyChanged(BR.english);
    }
}
