package io.github.yuweiguocn.databindingdemo.ui.main;

import java.util.List;

import io.github.yuweiguocn.databindingdemo.base.BasePresenter;
import io.github.yuweiguocn.databindingdemo.base.BaseView;
import io.github.yuweiguocn.databindingdemo.bean.User;

/**
 * Created by growth on 7/7/16.
 */
public interface MainContract {
    interface Presenter extends BasePresenter {
        void loadData();
    }

    interface View extends BaseView<Presenter> {
        void onSuccess(User user);
        void onSuccess(List<String> strings);
        void invalidateAll();
    }
}
