package com.deltadax.bdggithubapiapp.entity;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/**
 * Created by JosePablo on 20/08/17.
 */

//git_hub_repos
public class GitHubRepos extends SugarRecord<GitHubRepos> {

    private long git_id;
    private String name;
    private String full_name;
    private String language;

    @SerializedName("private")
    private boolean bPrivate;

    private String html_url;
    private String description;
    private int forks;
    private int stargazers_count;
    private String url;
    private String created_at;
    private String updated_at;
    private String git_url;

    public GitHubRepos() {
    }

    public static GitHubRepos newObject(GitHubRepos repo) {
        GitHubRepos obj = new GitHubRepos();

        obj.setGit_id(repo.getId());
        obj.setName(repo.getName());
        obj.setFull_name(repo.getFull_name());
        obj.setbPrivate(repo.isbPrivate());
        obj.setHtml_url(repo.getHtml_url());
        obj.setDescription(repo.getDescription());
        obj.setForks(repo.getForks());
        obj.setStargazers_count(repo.getStargazers_count());
        obj.setUrl(repo.getUrl());
        obj.setCreated_at(repo.getCreated_at());
        obj.setUpdated_at(repo.getUpdated_at());
        obj.setGit_url(repo.getGit_url());
        obj.setLanguage(repo.getLanguage());

        return obj;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public long getGit_id() {
        return git_id;
    }

    public void setGit_id(long git_id) {
        this.git_id = git_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public boolean isbPrivate() {
        return bPrivate;
    }

    public void setbPrivate(boolean bPrivate) {
        this.bPrivate = bPrivate;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
