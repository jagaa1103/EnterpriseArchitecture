package edu.mum.main;


import java.util.Date;
import java.util.List;

import edu.mum.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources/context/applicationContext.xml");
        applicationContext.getBean(Main.class).runCode(applicationContext);
    }

    private void runCode(ApplicationContext applicationContext){
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("djohn@miu.edu");
        user.setAdmin(true);
        user.setRating(1);
        user.setVersion(1);
        user.setLastLogin(new Date());
        try{
            userService.save(user);
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            User u = userService.findByEmail("djohn@miu.edu");
            System.out.println("******** User ********");
            System.out.println(u.getFirstName() + " " + u.getLastName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
  
 }