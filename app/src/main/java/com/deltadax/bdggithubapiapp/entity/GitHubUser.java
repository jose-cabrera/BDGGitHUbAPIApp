package com.deltadax.bdggithubapiapp.entity;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;


/**
 * Created by JosePablo on 20/08/17.
 * GitHub User Entity
 */

public class GitHubUser extends SugarRecord {
    //git_hub_user
    private String login;

    @Unique
    private long git_id;

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

    private int tipo;

    public GitHubUser() {
    }

    public static GitHubUser newObject(GitHubUser user) {
        GitHubUser we = new GitHubUser();
        we.setAvatar_url(user.getAvatar_url());
        we.setBlog(user.getBlog());
        we.setCompany(user.getCompany());
        we.setCreated_at(user.getCreated_at());
        we.setEmail(user.getEmail());
        we.setFollowers(user.getFollowers());
        we.setHtml_url(user.getHtml_url());
        we.setLocation(user.getLocation());
        we.setLogin(user.getLogin());
        we.setGit_id(user.getId());
        we.setName(user.getName());
        we.setPublic_repos(user.getPublic_repos());
        return we;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

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

    public long getGit_id() {
        return git_id;
    }

    public void setGit_id(long git_id) {
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
