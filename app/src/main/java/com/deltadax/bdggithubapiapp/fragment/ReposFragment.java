package com.deltadax.bdggithubapiapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.deltadax.bdggithubapiapp.R;
import com.deltadax.bdggithubapiapp.adapter.RepoAdapter;
import com.deltadax.bdggithubapiapp.entity.GitHubRepos;
import com.deltadax.bdggithubapiapp.entity.GitHubUser;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReposFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReposFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.repos_list)
    RecyclerView reposList;
    Unbinder unbinder;

    private long usuario;

    private RepoAdapter adapter;

    public ReposFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param usuario Parameter 1.
     * @return A new instance of fragment ReposFragment.
     */
    public static ReposFragment newInstance(long usuario) {
        ReposFragment fragment = new ReposFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PARAM1, usuario);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            usuario = getArguments().getLong(ARG_PARAM1);
        }


    }

    private void prepareRecycler() {

        reposList.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        reposList.setAdapter(adapter);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_repos, container, false);
        unbinder = ButterKnife.bind(this, view);

        adapter = new RepoAdapter(getActivity());
        prepareRecycler();
        getData();

        return view;
    }

    private void getData() {

        GitHubUser user = GitHubUser.findById(GitHubUser.class, usuario);
        List<GitHubRepos> repos = GitHubRepos.find(GitHubRepos.class,
                "usuario =? ", String.valueOf(user.getId()));

        adapter.setItems(repos);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
