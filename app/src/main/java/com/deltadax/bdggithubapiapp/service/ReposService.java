package com.deltadax.bdggithubapiapp.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import com.deltadax.bdggithubapiapp.RetroFitService;
import com.deltadax.bdggithubapiapp.entity.GitHubRepos;
import com.deltadax.bdggithubapiapp.entity.GitHubUser;
import com.deltadax.bdggithubapiapp.entity.ReposEvent;
import com.deltadax.bdggithubapiapp.webservice.GitHubApi;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * helper methods.
 */
public class ReposService extends IntentService {

    private static final String TAG = "ReposService";

    private static final String ACTION_FOO = "com.deltadax.bdggithubapiapp.service.action.FOO";

    private static final String EXTRA_USER = "com.deltadax.bdggithubapiapp.service.extra.PARAM1";

    public ReposService() {
        super("ReposService");
    }

    public static void startActionDescargarRepos(Context context, String usuario) {
        Intent intent = new Intent(context, ReposService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_USER, usuario);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_USER);
                handleActionDescargaRepos(param1);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionDescargaRepos(String usuario) {

        Log.d(TAG, "handleActionDescargaRepos: " + usuario);

        GitHubApi api = RetroFitService.getInstance();

        try {
            List<GitHubRepos> reposCall = api.getRepos(usuario).execute().body();

            List<GitHubRepos> repos = new ArrayList<>();
            if (reposCall != null)
                for (GitHubRepos repo : reposCall) {
                    repos.add(GitHubRepos.newObject(repo));
                }

            for (GitHubRepos repo : repos) {
                repo.save();
            }

            EventBus.getDefault().post(new ReposEvent(usuario));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
