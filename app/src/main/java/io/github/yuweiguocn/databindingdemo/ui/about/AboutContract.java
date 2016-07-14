package io.github.yuweiguocn.databindingdemo.ui.about;

import io.github.yuweiguocn.databindingdemo.base.BasePresenter;
import io.github.yuweiguocn.databindingdemo.base.BaseView;
import io.github.yuweiguocn.databindingdemo.bean.About;

/**
 * Created by growth on 7/9/16.
 */
public interface AboutContract {
    interface Presenter extends BasePresenter {
        void loadData();
    }

    interface View extends BaseView<Presenter> {
        void onSucess(About about);
    }
}
