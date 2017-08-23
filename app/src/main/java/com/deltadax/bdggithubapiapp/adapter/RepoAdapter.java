package com.deltadax.bdggithubapiapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deltadax.bdggithubapiapp.R;
import com.deltadax.bdggithubapiapp.entity.GitHubRepos;
import com.deltadax.bdggithubapiapp.view.ReposViewHolder;

import java.util.List;

/**
 * Created by JosePablo on 20/08/17.
 */

public class RepoAdapter extends RecyclerView.Adapter<ReposViewHolder> {

    private Context context;
    private List<GitHubRepos> items;

    public RepoAdapter(Context context) {
        this.context = context;
    }

    public void setItems(List<GitHubRepos> items) {
        this.items = items;
        this.notifyDataSetChanged();
    }

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v3 = LayoutInflater.from(context).inflate(R.layout.repos_item, parent, false);
        return new ReposViewHolder(v3);
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {

        if (items != null) {
            GitHubRepos repo = items.get(position);
            holder.repoDesc.setText(repo.getDescription());
            holder.repoForks.setText(String.valueOf(repo.getForks()));
            holder.repoLanguage.setText(repo.getLanguage());
            holder.repoName.setText(repo.getName());
            holder.repoStars.setText(String.valueOf(repo.getStargazers_count()));
        }

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

}
