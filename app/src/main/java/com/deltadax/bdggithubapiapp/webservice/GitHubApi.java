package com.deltadax.bdggithubapiapp.webservice;

import com.deltadax.bdggithubapiapp.entity.GitHubRepos;
import com.deltadax.bdggithubapiapp.entity.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JosePablo on 21/08/17.
 */

public interface GitHubApi {

    @GET("users/{user}")
    Call<GitHubUser> getUser(@Path("user") String user);

    @GET("users/{user}/repos")
    Call<List<GitHubRepos>> getRepos(@Path("user") String user);

}
