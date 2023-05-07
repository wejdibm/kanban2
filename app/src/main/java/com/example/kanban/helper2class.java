package com.example.kanban;

public class helper2class {

    String name, email,  matricule ,as ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


    public helper2class(String name, String email, String username, String matricule) {
        this.name = name;
        this.email = email;

        this.matricule = matricule ;
        this.as = as ;

    }

    public helper2class() {
    }
}

