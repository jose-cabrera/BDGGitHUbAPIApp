package com.deltadax.bdggithubapiapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.deltadax.bdggithubapiapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JosePablo on 20/08/17.
 */

public class UserItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.user_avatar)
    public ImageView userAvatar;
    @BindView(R.id.user_name)
    public TextView userName;
    @BindView(R.id.user_id)
    public TextView userId;
    public View container;

    public UserItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.container = itemView;
    }
}
