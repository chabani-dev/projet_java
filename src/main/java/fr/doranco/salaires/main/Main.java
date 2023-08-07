package fr.doranco.salaires.main;

import fr.doranco.salaires.entity.User;
import fr.doranco.salaires.model.UserDao;

public class Main {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		
		
		User user3 = new User();
		
		user3.setNom("chabani");
		user3.setPrenom("naima");
		
		user3.setEmail("naima@fake.com");
		user3.setPassword("azerty");
		UserDao userD = new UserDao();
		
		userD.addUser(user3);
		
		
		

	}

}
