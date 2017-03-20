package it.hearst.iclub;

/**
 * Created by granatag on 10/03/2017.
 */

public class Database {
    private String id;
    private String nomedb;
    private String project;
    private String namespace;
    private Boolean mainrepo;
    private Boolean deleted;
    private int userCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomedb() {
        return nomedb;
    }

    public void setNomedb(String nomedb) {
        this.nomedb = nomedb;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Boolean getMainrepo() {
        return mainrepo;
    }

    public void setMainrepo(Boolean mainrepo) {
        this.mainrepo = mainrepo;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getUserCount() { return userCount; }

    public void setUserCount(int userCount) { this.userCount = userCount; }
}
