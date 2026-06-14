package MVC2;

import java.util.List;

public class UserController {

    private UserView view;
    private UserDAO dao;

    public UserController(UserView view) {
        this.view = view;
        this.dao = new UserDAO();
    }

    public void start() {
        int choice;

        do {
            choice = view.menu();

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    login();
                    break;
            }

        } while (choice != 0);
    }

    private void add() {
        String name = view.getName();
        String login = view.getLogin();
        String password = view.getPassword();

        dao.addUser(new User(0, name, login, password));
        view.message("Utilisateur ajouté");
    }

    private void list() {
        List<User> users = dao.getAllUsers();
        view.display(users);
    }

    private void login() {
        String login = view.getLogin();
        String password = view.getPassword();

        User u = dao.login(login, password);

        if (u != null) {
            view.message("Connexion réussie: " + u.getName());
        } else {
            view.message("Login ou mot de passe incorrect");
        }
    }
}
