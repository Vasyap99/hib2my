package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;

public class chat {
    class BadLogin extends Throwable {}
    class BadPassword extends Throwable {}

    HashMap<Integer,user> _users=new HashMap<Integer,user>();
    user _activeUser;

    private Session s;
    Transaction t;

    chat(Session s){
        this.s=s;
        t = s.getTransaction();
        List<user>l=getAllUsers();
        for(var v:l){
            _users.put(v.id,v);
        }
    }
    void createNewUser(String n,String l,String p) throws BadLogin {
        if (isLoginExist(l)) {
            System.out.println("User with login "+l+" is already exists."+'\n');
            throw new BadLogin();
        }else{
            user u=new user(n,l,p);
            t.begin();
            s.persist(u);
            t.commit();
        }
    }

    void login(String login, String password) throws BadLogin, BadPassword {
        boolean found = isLoginExist(login);
        if (!found || isDisabled(login))
            throw new BadLogin();
        for (var it : _users.entrySet()){
            if (it.getValue().login.equals(login)) {
                if (it.getValue().password.equals(password)) {
                    setActiveUser(it.getValue());
                }else
                    throw new BadPassword();
            }
        }
    }

    List<user> getAllUsers(){
        Query<user>q=s.createQuery("from user",user.class);
        return q.list();
    }

    void setActiveUser(user u)
    {
        _activeUser = u;
    }

    boolean isLoginExist(String login){
        return true;
    }
    boolean isDisabled(String login){
        return false;
    }
}
