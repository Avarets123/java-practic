package org.spring;

import org.spring.services.UsersServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    UsersServiceImpl usersService = context.getBean(UsersServiceImpl.class);

    usersService.signUp("marsel@marsel.com", "qwertyu199");
  }
}

