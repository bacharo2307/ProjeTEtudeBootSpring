package MVC1;

import java.util.Scanner;
import java.util.List;

public class UserView {

    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Ajouter utilisateur");
        System.out.println("2. Afficher utilisateurs");
        System.out.println("3. Modifier utilisateur");
        System.out.println("4. Connexion");
        System.out.println("0. Quitter");
        System.out.print("Choix : ");
        return scanner.nextInt();
    }

    public int getUserId() {
        System.out.print("ID utilisateur : ");
        return scanner.nextInt();
    }

    public String getUserName() {
        System.out.print("Nom : ");
        return scanner.next();
    }

    public String getLogin() {
        System.out.print("Login : ");
        return scanner.next();
    }

    public String getPassword() {
        System.out.print("Mot de passe : ");
        return scanner.next();
    }

    public void displayUsers(List<User> users) {
        System.out.println("\nListe des utilisateurs :");
        for (User user : users) {
            System.out.println("ID: " + user.getId()
                    + " | Nom: " + user.getName()
                    + " | Login: " + user.getLogin());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
