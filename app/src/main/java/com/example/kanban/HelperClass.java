package com.example.kanban;

public class HelperClass {

        String name, email, username, password, matricule ,as ;

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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {this.password = password;}
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


        public HelperClass(String name, String email, String username, String password , String matricule,String as) {
            this.name = name;
            this.email = email;
            this.username = username;
            this.password = password;
            this.matricule = matricule ;
            this.as = as ;

        }

        public HelperClass() {
        }
    }

