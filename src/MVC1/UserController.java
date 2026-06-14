package MVC1;


import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<User> users = new ArrayList<>();
    private UserView view;

    public UserController(UserView view) {
        this.view = view;
    }

    public void start() {
        int choice;

        do {
            choice = view.showMenu();

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    showUsers();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    login();
                    break;
                case 0:
                    view.showMessage("Au revoir !");
                    break;
                default:
                    view.showMessage("Choix invalide !");
            }

        } while (choice != 0);
    }

    private void addUser() {
        int id = view.getUserId();
        String name = view.getUserName();
        String login = view.getLogin();
        String password = view.getPassword();

        users.add(new User(id, name, login, password));
        view.showMessage("Utilisateur ajouté !");
    }

    private void showUsers() {
        view.displayUsers(users);
    }

    private void updateUser() {
        int id = view.getUserId();

        for (User user : users) {
            if (user.getId() == id) {
                String name = view.getUserName();
                String login = view.getLogin();
                String password = view.getPassword();

                user.setName(name);
                user.setLogin(login);
                user.setPassword(password);

                view.showMessage("Utilisateur modifié !");
                return;
            }
        }

        view.showMessage("Utilisateur non trouvé !");
    }

    private void login() {
        String login = view.getLogin();
        String password = view.getPassword();

        for (User user : users) {
            if (user.getLogin().equals(login) &&
                    user.getPassword().equals(password)) {

                view.showMessage("Connexion réussie ! Bienvenue " + user.getName());
                return;
            }
        }

        view.showMessage("Échec de connexion !");
    }
}