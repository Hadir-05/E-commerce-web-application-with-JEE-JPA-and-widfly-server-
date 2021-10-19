package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.midvi.entities.User;

/**
 * Session Bean implementation class UserManager
 */
@Stateless
@LocalBean
@Path("/users")
public class UserManager implements UserManagerRemote, UserManagerLocal {
	@PersistenceContext(unitName= "EcommerceEJB")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public UserManager() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/isExiste/{identifiant}/{email}/{pw}")
	@Override
	public boolean isExist(@PathParam("identifiant")String ident,
			@PathParam("email")String email, 
			@PathParam("pw")String pw) 
	{
		Query req = em.createQuery("SELECT e FROM User e where  e.identifiant = '"+ident+"' AND e.email ='"+email+"' AND e.pw ='"+pw+"'");
		List<User> user = req.getResultList();
		if(user.isEmpty())
			return false;
		return true;
	}
	@Override
	public boolean isSignup(String ident, String email) {
		Query req = em.createQuery("SELECT e FROM User e where  e.identifiant = '"+ident+"' OR e.email ='"+email+"'");
		List<User> user = req.getResultList();
		if(user.isEmpty())
			return false;
		return true;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/isUserExist/{email}")
	@Override
	public User getUserByemail(@PathParam("email")String email) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("SELECT e FROM User e where e.email ='"+email+"'");

		return (User) req.getSingleResult();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listUsers")
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT u FROM User u");
		List<User> l = q.getResultList();
		return l;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addUser/{nom}/{prenom}/{email}/{identifiant}/{telephone}/{pw}")
	@Override
	public void addUser(
			@PathParam("nom")String nom, 
			@PathParam("prenom")String prenom, 
			@PathParam("email")String email, 
			@PathParam("identifiant")String ident,
			@PathParam("telephone")String tele, 
			@PathParam("pw")String pw) {
		// TODO Auto-generated method stub
		User u =new User(ident, nom, prenom, tele, email, pw);
		em.persist(u);
	}
	

}
