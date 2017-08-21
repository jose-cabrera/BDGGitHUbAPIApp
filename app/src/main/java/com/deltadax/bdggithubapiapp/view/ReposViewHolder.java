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

    int we = R.layout.repos_item;
    @BindView(R.id.repo_name)
    TextView repoName;
    @BindView(R.id.repo_desc)
    TextView repoDesc;
    @BindView(R.id.repo_language)
    TextView repoLanguage;
    @BindView(R.id.repo_stars)
    TextView repoStars;
    @BindView(R.id.repo_forks)
    TextView repoForks;
    View container;

    public ReposViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.container = itemView;
    }
}
