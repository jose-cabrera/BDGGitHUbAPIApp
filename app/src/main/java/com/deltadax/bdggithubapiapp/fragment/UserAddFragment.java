package com.deltadax.bdggithubapiapp.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.deltadax.bdggithubapiapp.R;
import com.deltadax.bdggithubapiapp.RetroFitService;
import com.deltadax.bdggithubapiapp.adapter.UserAdapter;
import com.deltadax.bdggithubapiapp.entity.GitHubUser;
import com.deltadax.bdggithubapiapp.webservice.GitHubApi;
import com.deltadax.bdggithubapiapp.webservice.RetroFitImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class UserAddFragment extends DialogFragment {

    @BindView(R.id.et_usuario)
    EditText etUsuario;
    @BindView(R.id.tipo_usuario)
    Spinner tipoUsuario;
    @BindView(R.id.agregar_usuario)
    Button agregarUsuario;
    Unbinder unbinder;

    String[] tipos = new String[]{
            "Seleccione uno...", "Dev", "Dev2", "Dev3"
    };

    usuarioAgregadoInterface listener;

    public UserAddFragment() {
        // Required empty public constructor
    }

    public static UserAddFragment newInstance() {
        UserAddFragment fragment = new UserAddFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_add, container, false);
        unbinder = ButterKnife.bind(this, view);
        preareSpinner();
        return view;
    }

    private void preareSpinner() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item);
        adapter.addAll(tipos);
        tipoUsuario.setAdapter(adapter);

    }

    public void setListener(usuarioAgregadoInterface listener) {
        this.listener = listener;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.agregar_usuario)
    public void onViewClicked() {
        String usuario = etUsuario.getText().toString();
        if (!usuario.isEmpty()) {
            etUsuario.setError(null);
            consumirWs(usuario);
        } else {
            etUsuario.setError("Ingresa un usuario");
        }
    }

    private void consumirWs(String usuario) {

        new getUsuario(getActivity()).execute(usuario);

    }

    public interface usuarioAgregadoInterface {
        void usuarioAgregado();
    }

    private class getUsuario extends AsyncTask<String, Void, GitHubUser> {

        private ProgressDialog dialog;
        private Context context;

        public getUsuario(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(context, "Obtener Usuario",
                    "Cargando");
        }

        @Override
        protected GitHubUser doInBackground(String... strings) {

            GitHubApi api = RetroFitService.getInstance();

            try {
                return api.getUser(strings[0]).execute().body();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(GitHubUser gitHubUser) {

            if (dialog != null)
                dialog.dismiss();

            if (gitHubUser == null) {
                etUsuario.setError("Usuario no existe u ocurrio un error");
            } else {
                GitHubUser user = GitHubUser.newObject(gitHubUser);
                user.save();
                UserAddFragment.this.dismiss();
                listener.usuarioAgregado();
            }
        }
    }
}
