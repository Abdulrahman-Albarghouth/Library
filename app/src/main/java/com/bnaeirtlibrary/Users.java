package com.bnaeirtlibrary;


public class Users {

    String u_fullname;
    String u_email;
    String u_password;
    String u_phone;

public Users(){

}
    public Users(String u_fullname, String u_email,  String u_phone) {

        this.u_fullname = u_fullname;
        this.u_email = u_email;
        this.u_password = u_password;
        this.u_phone = u_phone;
    }
    public Users(String u_fullname, String u_email, String u_password, String u_phone) {

        this.u_fullname = u_fullname;
        this.u_email = u_email;
        this.u_password = u_password;
        this.u_phone = u_phone;
    }






    public String getU_fullname() {
        return u_fullname;
    }

    public void setU_fullame(String u_lastname) {
        this.u_fullname = u_fullname;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }


    }





//------------------------END OF CLASS--------------------