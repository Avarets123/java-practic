package org.spring1;

import org.spring1.services.UsersServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

//    EmailSimpleValidator emailSimpleValidator = (EmailSimpleValidator) context.getBean("emailSimpleValidator");
//    EmailSimpleValidator emailSimpleValidator1 = context.getBean(EmailSimpleValidator.class);

    UsersServiceImpl usersService = context.getBean(UsersServiceImpl.class);

    usersService.signUp("ffff@gmail.com", "password123");


  }
}
