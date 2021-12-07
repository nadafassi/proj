package de.tekup.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.tekup.data.models.User;
import de.tekup.data.services.UserService;

@Component
public class Test  implements CommandLineRunner{

	@Autowired
	private UserService us;
	
	@Override
	public void run(String... args) throws Exception {
		
//		User user = new User(0,"reggui","farah","f@g.c","0000","admin","admin",null);
		
		//us.save(user);             #test ajout user
		
//								     #test modification user
//		user.setNom("issaf");
//		user.setPrenom("douda");
//		user.setId(3);
//		us.update(user);
		
		//us.findAll();             #test affichage user
		//us.delete((long) 3);      #test delete user
		
	}
}
