package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User Kostya = new User("Kostya", "Smirnov", "Kostya@mail.ru");
      User Anna = new User("Anna", "Petrova", "AnnaPet@mail.ru");
      User Nadya = new User("Nadya", "Simonova", "NadyaS@mail.ru");
      User Roma = new User("Roma", "Kim", "KimR@mail.ru");

      Car Kia = new Car(1, "Rio");
      Car BMV = new Car(7, "X6");
      Car Mers = new Car(6, "GlS");
      Car Lada = new Car(1, "Vesta");

      Roma.setCar(Kia);
      userService.add(Roma);
      Kostya.setCar(Lada);
      userService.add(Kostya);
      Nadya.setCar(BMV);
      userService.add(Nadya);
      Anna.setCar(Mers);
      userService.add(Anna);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }

      try {
         System.out.println(userService.getUserByCar("Long", 7));
      } catch (NoResultException e) {
         System.out.println("Не существуют такого Юзера");
      }

      context.close();
   }
}