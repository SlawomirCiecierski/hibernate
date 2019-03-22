package controller;

import configuration.HibernateConfiguration;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class UserController {

  public void addUser(String email, String password, String role, boolean enable, LocalDate date_added){
    //otwieramy sesję - transakcję

    Session session= HibernateConfiguration.getSessionFactory().openSession();
    //rozpoczęcie transakcji
    Transaction transaction= session.beginTransaction();
    //wykonanie polecenie SQL
    User user=new User(email, password, role, enable, date_added);
    //insert into user value (default, email, password, role, enable, date_added
    session.save(user);
    //zatwierdzenie transakcji
    transaction.commit();
    //zamknięcie połączenia z sesją
    session.close();

  }
}
