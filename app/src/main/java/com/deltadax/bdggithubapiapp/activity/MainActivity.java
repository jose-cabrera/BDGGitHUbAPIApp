package com.deltadax.bdggithubapiapp.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.deltadax.bdggithubapiapp.R;
import com.deltadax.bdggithubapiapp.adapter.UserAdapter;
import com.deltadax.bdggithubapiapp.entity.GitHubUser;
import com.deltadax.bdggithubapiapp.fragment.UserAddFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements UserAddFragment.usuarioAgregadoInterface, UserAdapter.userItemCliked {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lista_usuarios)
    RecyclerView listaUsuarios;

    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new UserAdapter(this, this);

        prepareRecylerView();
        cargarUsuarios();
    }

    private void prepareRecylerView() {
        listaUsuarios.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false
        ));

        listaUsuarios.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarUsuarios();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {

        UserAddFragment fragment = UserAddFragment.newInstance();
        fragment.setListener(this);
        fragment.show(getSupportFragmentManager(), UserAddFragment.class.getSimpleName());

    }

    @Override
    public void usuarioAgregado() {
        cargarUsuarios();
    }

    public void cargarUsuarios() {
        List<GitHubUser> lista = GitHubUser.listAll(GitHubUser.class);

        if (adapter != null)
            adapter.setItems(lista);
    }

    @Override
    public void itemClicked(int position) {
        callDetailActivity(adapter.getItems().get(position));
    }

    private void callDetailActivity(GitHubUser usuario) {
        DetailActivity.start(this, usuario.getId());
    }
}
