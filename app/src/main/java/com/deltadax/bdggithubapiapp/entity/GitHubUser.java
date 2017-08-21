package com.deltadax.bdggithubapiapp.entity;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/**
 * Created by JosePablo on 20/08/17.
 * GitHub User Entity
 */

public class GitHubUser extends SugarRecord<GitHubUser> {

    private String login;

    @SerializedName("id")
    private int git_id;

    private String avatar_url;
    private String url;
    private String html_url;
    private String name;
    private String company;
    private String location;
    private String email;
    private String blog;
    private String created_at;
    private int public_repos;
    private int followers;

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getGit_id() {
        return git_id;
    }

    public void setGit_id(int git_id) {
        this.git_id = git_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

}
