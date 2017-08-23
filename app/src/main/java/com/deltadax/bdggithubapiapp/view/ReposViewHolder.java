package com.deltadax.bdggithubapiapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.deltadax.bdggithubapiapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JosePablo on 20/08/17.
 */

public class ReposViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.repo_name)
    public TextView repoName;
    @BindView(R.id.repo_desc)
    public TextView repoDesc;
    @BindView(R.id.repo_language)
    public TextView repoLanguage;
    @BindView(R.id.repo_stars)
    public TextView repoStars;
    @BindView(R.id.repo_forks)
    public TextView repoForks;
    public View container;

    public ReposViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.container = itemView;
    }
}
