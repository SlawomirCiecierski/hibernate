import controller.UserController;
import model.RoleEnum;

import java.time.LocalDate;

public class Main {

  public static void main(String[] args) {

    UserController userController = new UserController();
    //rejestracja user 1
    // userController.addUser("mk@mk.pl", "mk", RoleEnum.ROLE_USER,true , LocalDate.now(), "s");


    // - przetestowane metody:
    //userController.addUser1("mk@mk.pl", "mk");
    //userController.addPostByUser("tytuł 2","zawartość2",1);
    userController.updatePostTitleByPostIn(4, "nowy tytuł");
    //userController.deletePostById(2);



  }
}
