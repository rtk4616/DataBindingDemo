/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.yuweiguocn.databindingdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.yuweiguocn.databindingdemo.BR;
import io.github.yuweiguocn.databindingdemo.R;
import io.github.yuweiguocn.databindingdemo.bean.User;
import io.github.yuweiguocn.databindingdemo.databinding.ItemUserBinding;

public class UserAdapter2 extends RecyclerView.Adapter<UserAdapter2.ViewHolder> {

    LayoutInflater mLayoutInflater;
    private List<User> users;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding binding;
        public ViewHolder(View itemView) {
            super(itemView);
            this.binding = DataBindingUtil.bind(itemView);
            this.binding = ItemUserBinding.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }


    public UserAdapter2(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }


    public void setDatas(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public UserAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        final User user = users.get(position);
        holder.getBinding().setVariable(BR.user, user);
        holder.getBinding().executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }
}
