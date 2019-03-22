package controller;

import configuration.HibernateConfiguration;
import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class UserController {

  public void addUser(String email, String password, RoleEnum role, boolean enable, LocalDate date_added, String secred_code) {
    //otwieramy sesję - transakcję

    Session session = HibernateConfiguration.getSessionFactory().openSession();
    //rozpoczęcie transakcji
    Transaction transaction = session.beginTransaction();
    //wykonanie polecenie SQL
    User user = new User(email, password, role, enable, date_added, secred_code);
    //insert into user value (default, email, password, role, enable, date_added
    session.save(user);
    //zatwierdzenie transakcji
    transaction.commit();
    //zamknięcie połączenia z sesją
    session.close();
  }

  public Role1 getRoleById(int id) {
    Session session = HibernateConfiguration.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    //zapytanie SELECT

    String hqlQuery;
    Query query = session.createQuery("SELECT r FROM Role1 r WHERE r.id_r=:id");
    query.setInteger("id", id);
    query.setMaxResults(1);
    Role1 role = (Role1) query.uniqueResult();
    //zatwierdzenie transakcji

    transaction.commit();
    //zamknięcie połączenia z sesją
    session.close();
    return role;
  }


  public void addUser1(String email, String password) {
    Session session = HibernateConfiguration.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    //utworzenie obiektu użytkownika
    User1 user1 = new User1(email, password);
    //przypisanie aktywności
    user1.setEnable(true);
    //przypisanie daty
    user1.setDate_added(LocalDate.now());
    //przypisanie roli wprowadzenie obiektu Role1 do zbioru rół użytkwnika

    user1.addRoleToSet(getRoleById(1));
    //session.save(user);
    session.save(user1); //zwraca wartość
    //session.persist(user1); nie zwraca wartości
    //zatwierdzenie transakcji
    transaction.commit();
    //zamknięcie połączenia z sesją
    session.close();
  }

  public User1 getUserById(int id){
    Session session=HibernateConfiguration.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    //zapytanie SELECT
     Query query = session.createQuery("SELECT r FROM User1 r WHERE r.id_u=:id");
    query.setInteger("id", id);
    query.setMaxResults(1);
    User1 user1 = (User1) query.uniqueResult();
    //zatwierdzenie transakcji

    transaction.commit();
    //zamknięcie połączenia z sesją
    session.close();
    return user1;

  }

  public void addPostByUser(String title, String content, int id_u){
    Session session=HibernateConfiguration.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Post1 post1=new Post1(title, content, getUserById(id_u));
    session.save(post1);
    transaction.commit();
    session.close();
  }

  public Post1 getPostById(int id){
    Session session=HibernateConfiguration.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    //zapytanie SELECT
    Query query = session.createQuery("SELECT r FROM Post1 r WHERE r.id_p=:id");
    query.setInteger("id", id);
    query.setMaxResults(1);
    Post1 post1 = (Post1) query.uniqueResult();
    //zatwierdzenie transakcji

    transaction.commit();
    //zamknięcie połączenia z sesją
    session.close();
    return post1;

  }

  public void deletePostById(int id_p){
    Session session=HibernateConfiguration.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.delete(getPostById(id_p));
    transaction.commit();
    session.close();

  }

  public void updatePostTitleByPostIn(int id_p, String newTitle){
    Session session=HibernateConfiguration.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Post1 post1=getPostById(id_p);
    post1.setTitle(newTitle);
    session.saveOrUpdate(post1);
    transaction.commit();
    session.close();
  }

}
