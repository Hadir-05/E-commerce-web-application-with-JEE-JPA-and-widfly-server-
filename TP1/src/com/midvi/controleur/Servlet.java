package com.midvi.controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.session.CartProductManagerLocal;
import com.session.PanierManager;
import com.session.PanierManagerLocal;
import com.session.ProductManagerLocal;
import com.session.UserManager;
import com.session.UserManagerLocal;
import com.midvi.entities.CartProduct;
import com.midvi.entities.Panier;
import com.midvi.entities.Products;
import com.midvi.entities.User;
import com.midvi.modele.Model;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Model model;
	
	@EJB
	private ProductManagerLocal metier;
	@EJB
	private UserManagerLocal metier1;
	@EJB
	private PanierManagerLocal metier2;
	@EJB
	private CartProductManagerLocal metier3;
	
	public void init() throws ServletException{
		model = new Model();
	}
	public Servlet() {
		super();
	}
    /**
     * Default constructor. 
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		String page = (String) request.getParameter("page");
		 /*Cookie[] cookies = request.getCookies();
		  if (cookies!=null  ) { // càd la connection la premiere fois 
			  for(int i=0;i<cookies.length;i++) {
				  if(cookies[i].getName().equals("login")) {
					  if(cookies[i].getValue().equals("admin@admin.com"))
						  request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
					
					  else {
						  request.getRequestDispatcher("/WEB-INF/afficher.jsp").forward(request, response);
					  return;
					  }
				  }
			  }
			   }*/
		 // request.setAttribute("page", model);
		  if(page != null) {
			  switch (page) {
			  case "add":
				  request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
				  break;
			  case "home":
				 // Products p = new Products("pc","pc performant",20000,12);
				 // metier.editProducts(6L, p);
				 // metier.deleteProduct(4L);
				  
				  request.setAttribute("user", metier1.getUserByemail((String) request.getSession().getAttribute("email")));
				  model.setProductlist( metier.getProducts());
				  request.setAttribute("model",model);
				  request.getRequestDispatcher("/WEB-INF/afficher.jsp").forward(request, response);
				  break;
			  case "detail":
				  String id = (String) request.getParameter("id");
				  Long id1=(long) 0;
				  try {
					  id1 = Long.parseLong(id);
				  }catch(Exception e) {
					  
				  }
				  	model.setProduit(metier.getProduct(id1));
				  	request.setAttribute("modelD", model);
					request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request,response);
					break;
			  case "remove":
				  String idd = (String) request.getParameter("id");
				  Long id11=(long) 0;
				  try {
					  id11 = Long.parseLong(idd);
				  }catch(Exception e) {
					  
				  }
				  metier.deleteProduct(id11);
				  model.setProductlist( metier.getProducts());
				  request.setAttribute("model",model);
				  request.getRequestDispatcher("/WEB-INF/afficher.jsp").forward(request, response);
				  break;
			  case "searching":
					request.getRequestDispatcher("/WEB-INF/afficher.jsp").forward(request,response);
					break;
			  case "addCart":
				  request.setAttribute("user", metier1.getUserByemail((String) request.getSession().getAttribute("email")));
				  request.setAttribute("panier", metier2.getPanierByUser((String) request.getSession().getAttribute("email")));
				  request.getRequestDispatcher("/WEB-INF/panier.jsp").forward(request, response);
				  String id2 = (String) request.getParameter("id");
				  String id4 = (String) request.getParameter("id1");
				  int qte = Integer.parseInt(request.getParameter("qtt"));

				  Long id3=(long) 0;
				  try {
					  id3 = Long.parseLong(id2);
				  }catch(Exception e) {
					  
				  }
				  Long id5=(long) 0;
				  try {
					  id5 = Long.parseLong(id4);
				  }catch(Exception e) {
					  
				  }
				  Panier p1 = metier2.getPanierByUser(id5);
				  CartProduct c = new CartProduct();				  
				  Products p = metier.getProduct(id3);
				 
				  c.getProducts().add(p);
				  c.setQuantite(qte);
				  
				  p1= metier2.addProducPanier(p1, qte,id3);
				  request.setAttribute("panier", p1);
				  request.getRequestDispatcher("/WEB-INF/panier.jsp").forward(request, response);
				  break;
				  
			  case "ecom":
					request.getRequestDispatcher("/WEB-INF/ecom.jsp").forward(request,response);			
					break;
			  case "updateproduct":
					request.getRequestDispatcher("/WEB-INF/updateproduit.jsp").forward(request,response);			
					break;
			  case "deconnexion":
					HttpSession session= request.getSession();
					session.invalidate();
					request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
					break;
			  }
		  }
		  else 
			  request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			   
			   // request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);    	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String) request.getParameter("action");
		if(action.equals("login")) {
			String email = (String) request.getParameter("email");
			String identifiant = (String) request.getParameter("identifiant");
			String pw = (String) request.getParameter("pw");
			String remember = (String) request.getParameter("remember");
			if(remember != null) {
				Cookie cookie= new Cookie("email",email);
				cookie.setMaxAge(15*24*3600);
				response.addCookie(cookie);
			}
			HttpSession session = request.getSession();
			session.setAttribute("email",email);
			request.setAttribute("model",model);
			
			if(email.equals("admin@admin.com") && identifiant.equals("admin") && pw.equals("admin")) {
				model.setAdmin(true);
			}else {
				model.setAdmin(false);
			}
			if(model.isAdmin()) 
				request.getRequestDispatcher("/WEB-INF/ecom.jsp").forward(request, response);
			else {
					if(metier1.isExist(identifiant,email, pw))
					{
						User user = metier1.getUserByemail(email);
						request.setAttribute("user", user);
						model.setProductlist(metier.getProducts());
						request.setAttribute("model", model);
					     request.getRequestDispatcher("/WEB-INF/ecom.jsp").forward(request, response);

					}
				else
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}

			}
		if(action.equals("update")) { 
			String id = (String) request.getParameter("id");
			String libelle = (String) request.getParameter("libelle");
			String categorie = (String) request.getParameter("cat");
			String description = (String) request.getParameter("description");
			String prix = (String) request.getParameter("prix");
			String quantite = (String) request.getParameter("quantite");
			double price = 0;
			int qte = 0;
			Long id1=(long) 0;
			try {
				price = Double.parseDouble(prix);
			}catch(Exception e) {
				
			}
			try {
				id1 = Long.parseLong(id);
			}catch(Exception e) {
				
			}
			try {
				qte = Integer.parseInt(quantite);
			}catch(Exception e) {
				
			}
			Products produit = new Products(libelle,categorie, description, price, qte);
			model.setMsg("updateproduct");
			metier.editProducts(id1, produit);
			model.setProductlist(metier.getProducts());
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/updateproduit.jsp").forward(request, response);
		}	
		if(action.equals("search")) {
			String search = (String) request.getParameter("search");
			
			model.setProductlist(metier.Search(search));
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/afficher.jsp").forward(request, response);

		}
		if(action.equals("signup")) {
			String nom = (String) request.getParameter("nom");
			String prenom = (String) request.getParameter("prenom");
			String identifiant = (String) request.getParameter("identifiant");
			String mobile = (String) request.getParameter("mobile");
			String email = (String) request.getParameter("email");
			String pw = (String) request.getParameter("pw");
			User user = new User(identifiant,nom,prenom,mobile,email,pw,false);
			if(metier1.isSignup(identifiant, email)) {
				request.getRequestDispatcher("signup.jsp").forward(request, response);
				
			}
			else {
				metier1.addUser(user);
				Panier p = new Panier();
				metier2.addPanier(p,user);
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}

		}
		if (action.equals("add")) {
		String libelle =(String) request.getParameter("libelle");
		String categorie = (String) request.getParameter("cat");
		String description =(String) request.getParameter("description");
		String prix =(String) request.getParameter("prix");
		String quantite =(String) request.getParameter("quantite");
		double price = 0;
		int qte = 0;
		try {
		qte = Integer.parseInt(quantite);
		}catch(Exception e) {
			
		}
		try {
		price = Double.parseDouble(prix);
		}catch(Exception e) {
			
		}
		
		Products produit = new Products(libelle,categorie,description,price,qte);
		model.setMsg("add");
		metier.addProduct(produit);
		model.setProductlist(metier.getProducts());
		
		
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

		}
	}

}
