package model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity     //adnotacja tworząca tablekę user w DB
public class User1 {
  @Id //adnotacja determinująca PrimaryKey
  @GeneratedValue(strategy = GenerationType.AUTO) //determinująca AutoIncrement
  private int id_u;
  @Column(unique = true)
  private String email;
  private String password;

  //CascadeType.All np. usuwanie kaskadowe (np. z relacjami
  //FetchType.Eager przy tworzeniu encji mamy dostęp do powiązań
  //FetchType.Lazy przy utworzeniu encji musimy ręcznie wywołać powiązania

  @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
  Set<Role1> roles=new HashSet<>(); //użytkownik może mieć wiele ról
  //??role
  private RoleEnum role;
  private boolean enable;
  private LocalDate date_added;
  @Transient // adnotacja wyłaczająca pole ptzy mapowaniu
  private String secrete_code;
    //relacja 1:n
  @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "user1")
  List<Post1> posts=new ArrayList<>();



  public User1() {
  }

  public User1(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public int getId_u() {
    return id_u;
  }

  public void setId_u(int id_u) {
    this.id_u = id_u;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role1> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role1> roles) {
    this.roles = roles;
  }

  public void addRoleToSet(Role1 role1){
    this.roles.add(role1);
  }

  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public boolean isEnable() {
    return enable;
  }

  public void setEnable(boolean enable) {
    this.enable = enable;
  }

  public LocalDate getDate_added() {
    return date_added;
  }

  public void setDate_added(LocalDate date_added) {
    this.date_added = date_added;
  }

  public String getSecrete_code() {
    return secrete_code;
  }

  public void setSecrete_code(String secrete_code) {
    this.secrete_code = secrete_code;
  }

  public List<Post1> getPosts() {
    return posts;
  }

  public void setPosts(List<Post1> posts) {
    this.posts = posts;
  }
}
