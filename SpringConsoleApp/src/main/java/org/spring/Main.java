package org.spring;

import org.spring.config.AppConfig;
import org.spring.services.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    UsersService usersService = context.getBean(UsersService.class);

    System.out.println(usersService.getAllUsers());

  }
}