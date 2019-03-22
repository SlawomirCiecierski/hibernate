package model;


import org.hibernate.annotations.*;


import javax.persistence.*;
import javax.persistence.Entity;

import java.time.LocalDate;

@Entity     //adnotacja tworząca tablekę user w DB
public class User {
  @Id //adnotacja determinująca PrimaryKey
  @GeneratedValue(strategy = GenerationType.AUTO) //determinująca AutoIncrement
  private int id_u;
  @Column(unique=true)
  private String email;
  private String password;
  @Enumerated
  private RoleEnum role;
  private boolean enable;
  private LocalDate date_added;
  @Transient // adnotyacja wyłaczająca pole ptzy mapowaniu
  private String secrete_code;



  public User(String email, String password, RoleEnum role, boolean enable, LocalDate date_added, String secred_code){

  }



}
