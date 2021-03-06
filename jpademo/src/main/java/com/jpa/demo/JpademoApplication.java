package com.jpa.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.demo.entity.User;
import com.jpa.demo.repo.UserRepo;

@SpringBootApplication
public class JpademoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(JpademoApplication.class, args);
		UserRepo userRepo=context.getBean(UserRepo.class);
		/*
		 * User u1=new User(); u1.setCity("Noida"); u1.setName("Ishan Srivastava");
		 * u1.setStatus("At Work"); User u2= userRepo.save(u1); System.out.println(u2);
		 */
		/*
		 * User u2=new User(); u2.setCity("Mankapur"); u2.setName("Ishu");
		 * u2.setStatus("At Home"); User u3=new User(); u3.setCity("Lucknow");
		 * u3.setName("Kavin"); u3.setStatus("At Home"); List<User>
		 * users=List.of(u2,u3); Iterable<User>u=userRepo.saveAll(users);
		 * u.forEach(e->System.out.println(e));
		 */
		/*
		 * Optional<User>opt=userRepo.findById(2); User user=opt.get();
		 * user.setName("Carleeto"); System.out.println(userRepo.save(user));
		 * Iterable<User> users=userRepo.findAll();
		 * users.forEach(e->System.out.println(e));
		 */
		//userRepo.deleteById(2);
		/*
		 * Iterable<User> users=userRepo.findByName("Kavin");
		 * users.forEach(e->System.out.println(e)); Iterable<User>
		 * users2=userRepo.findByNameAndCity("Ishan Srivastava","Noida");
		 * users2.forEach(e->System.out.println(e)); 
		 */
		Iterable<User>users3=userRepo.allsql();
		users3.forEach(e->System.out.println(e));

	}

}
