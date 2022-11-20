package org.spring;

import org.spring.config.AppConfig;
import org.spring.services.UsersServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    UsersServiceImpl usersService = context.getBean(UsersServiceImpl.class);

    usersService.signUp("gasanov@gmail.com", "password123");


  }
}
