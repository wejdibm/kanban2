package com.example.kanban;

public class model
{
    String name,matricule,email,purl,password,username ;
    model()
    {

    }
    public model( String matricule, String purl, String password, String username) {
        this.matricule = matricule;
        this.purl = purl ;
        this.password = password ;
        this.username = username ;

    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
