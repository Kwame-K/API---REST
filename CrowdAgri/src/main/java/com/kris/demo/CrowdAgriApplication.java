package com.kris.demo;


import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kris.demo.model.Agriculteur;
import com.kris.demo.model.Campagne;
import com.kris.demo.model.User;
import com.kris.demo.service.AgriculteurService;
import com.kris.demo.service.CampagneService;
import com.kris.demo.service.UserService;



@SpringBootApplication(scanBasePackages={"com.kris.demo"})
@ComponentScan("com.kris.demo")
public class CrowdAgriApplication {
	
	private static final Logger log= LoggerFactory.getLogger(CrowdAgriApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrowdAgriApplication.class, args);
	
}
	@Configuration
	public class AdditionalResourceWebConfiguration implements WebMvcConfigurer {

	  @Override
	  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/Images/**").addResourceLocations("file://" + System.getProperty("user.dir") + "/src/main/Images/");
	  }
	}
	@Bean
	  public CommandLineRunner demo(UserService Urepository,AgriculteurService Arepository,CampagneService xe) {
	    return (args) -> {
	    /* User ds = new User("Jadck", "hjtfj");
	      Urepository.saveUser(ds);
	      Urepository.saveUser(new User("Dack", "jgc"));
	      Urepository.saveUser(new User("gack", "jfj"));
	      Urepository.saveUser(new User("jack", "jgc"));
	      Urepository.saveUser(new User("Michelle", "Dessler"));
	      Agriculteur ag = new Agriculteur("nom", "prenom", "adresse", "email", 13467913, ds);
	     Arepository.saveAgriculteur(ag);
	      //Agriculteur ag = new
          Arepository.saveAgriculteur(ag);
	   
	    Campagne a = new Campagne("intitule",null, 56454834, 0, "temps_production", "photo_camp", ag);
	     xe.saveCampagne(a);
	      // fetch all customers
	      log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	     // Urepository.getUser();
	     // log.info(ag.toString());
	     // log.info(ds.toString());
	     // log.info(a.toString());
	      
	     int i=0;
	     ArrayList<String> maListe=new ArrayList<String>();
	      for (User user : Urepository.getUser()) {
	    	  log.info(""+i);
	         String a0=user.getEmail();
	         String b=user.getPassword();
	         maListe.add(""+a0+ " "+b); 
	          i++;
	          log.info(""+user.getId());
	        }
	     
	      
	      
	      Iterator<String> itr=maListe.iterator();//getting the Iterator  
	      while(itr.hasNext()){
	       log.info(""+itr.next());
	      }  
	      
	    
	      //  }
	      //ag.getUser_agri().getId();
	   //   log.info(""+Urepository.getUser());
	      
	      // fetch customers by last name
	   
	      log.info("");*/
	    };
}
}
