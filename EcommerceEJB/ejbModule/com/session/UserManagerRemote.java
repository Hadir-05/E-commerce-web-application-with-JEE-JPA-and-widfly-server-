package com.session;

import java.util.List;

import javax.ejb.Remote;

import com.midvi.entities.User;

@Remote
public interface UserManagerRemote {
	public void addUser(User u);
	public boolean isExist(String ident, String email, String pw);
	public boolean isSignup(String ident,String email);
	User getUserByemail(String email);
	public List<User> getUsers();
	public void addUser(String nom,String prenom,String email,String ident,String tele,String pw);


}
