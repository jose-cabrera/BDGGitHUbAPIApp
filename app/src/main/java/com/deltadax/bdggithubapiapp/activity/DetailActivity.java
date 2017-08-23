package com.deltadax.bdggithubapiapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.deltadax.bdggithubapiapp.R;
import com.deltadax.bdggithubapiapp.entity.GitHubUser;
import com.deltadax.bdggithubapiapp.entity.ReposEvent;
import com.deltadax.bdggithubapiapp.service.ReposService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    private static final String ARG_ID = "id";
    @BindView(R.id.user_avatar)
    ImageView userAvatar;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_id)
    TextView userId;
    @BindView(R.id.user_organization)
    TextView userOrganization;
    @BindView(R.id.user_location)
    TextView userLocation;
    @BindView(R.id.repo_email)
    TextView repoEmail;
    @BindView(R.id.repo_webpage)
    TextView repoWebpage;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.detail_layout)
    ScrollView detailLayout;

    private GitHubUser user;

    public static void start(Context context, long id) {
        Intent starter = new Intent(context, DetailActivity.class);
        starter.putExtra(ARG_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        getUserData();
    }

    private void getUserData() {

        long id = getIntent().getLongExtra(ARG_ID, 0);
        if (id != 0) {

            GitHubUser usuario = GitHubUser.findById(GitHubUser.class, id);
            if (usuario != null) {
                user = usuario;
                prepareView();
                ReposService.startActionDescargarRepos(this, usuario.getLogin());
            } else {
                onBackPressed();
            }
        } else {
            onBackPressed();
        }
    }

    private void prepareView() {

        Glide.with(this)
                .load(user.getAvatar_url())
                .thumbnail(0.1f)
                .apply(RequestOptions.circleCropTransform())
                .into(userAvatar);

        userName.setText(user.getName());
        userId.setText(String.valueOf(user.getGit_id()));
        userOrganization.setText(user.getCompany() == null ? "" : user.getCompany());
        userOrganization.setVisibility(user.getCompany() == null ? View.GONE : View.VISIBLE);

        userLocation.setText(user.getLocation());
        repoEmail.setText(user.getEmail());
        repoWebpage.setText(user.getHtml_url());

    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    private void eventoRecibido(ReposEvent evento) {
        Toast.makeText(this,
                String.format(getString(R.string.repos_sincro), evento.getUsuario()),
                Toast.LENGTH_SHORT).show();
    }
}
