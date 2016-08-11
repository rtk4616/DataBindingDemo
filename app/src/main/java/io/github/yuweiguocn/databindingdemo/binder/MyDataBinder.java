package io.github.yuweiguocn.databindingdemo.binder;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.text.TextUtils;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by growth on 8/11/16.
 */
public class MyDataBinder{
    private MyDataBinder(){}


    @BindingAdapter("imageUrl")
    public static void setImageUrl(SimpleDraweeView sdv, String url) {
        if (sdv == null || TextUtils.isEmpty(url)) {
            return;
        }
        sdv.setImageURI(Uri.parse(url));
    }

}
