package com.deltadax.bdggithubapiapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.deltadax.bdggithubapiapp.R;
import com.deltadax.bdggithubapiapp.entity.GitHubUser;
import com.deltadax.bdggithubapiapp.view.UserItemViewHolder;

import java.util.List;

/**
 * Created by JosePablo on 20/08/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserItemViewHolder> {

    private List<GitHubUser> items;
    private Context context;
    private userItemCliked listener;

    public UserAdapter(Context context, userItemCliked listener) {
        this.context = context;
        this.listener = listener;
    }

    public List<GitHubUser> getItems() {
        return items;
    }

    public void setItems(List<GitHubUser> items) {
        this.items = items;
        this.notifyDataSetChanged();
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v3 = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new UserItemViewHolder(v3);

    }

    @Override
    public void onBindViewHolder(final UserItemViewHolder holder, int position) {

        if (items != null) {
            holder.userName.setText(items.get(position).getName());
            holder.userId.setText(String.valueOf(items.get(position).getGit_id()));

            Glide.with(context)
                    .load(items.get(position).getAvatar_url())
                    .thumbnail(0.1f)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.userAvatar);

            holder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClicked(holder.getAdapterPosition());
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public interface userItemCliked {
        void itemClicked(int position);
    }
}
