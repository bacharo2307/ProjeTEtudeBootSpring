package MVC2;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private Scanner scanner = new Scanner(System.in);

    public int menu() {
        System.out.println("\n1. Ajouter");
        System.out.println("2. Afficher");
        System.out.println("3. Login");
        System.out.println("0. Quitter");
        System.out.print("Choix: ");
        return scanner.nextInt();
    }

    public String getName() {
        System.out.print("Nom: ");
        return scanner.next();
    }

    public String getLogin() {
        System.out.print("Login: ");
        return scanner.next();
    }

    public String getPassword() {
        System.out.print("Password: ");
        return scanner.next();
    }

    public void display(List<User> users) {
        for (User u : users) {
            System.out.println(u.getId() + " - " + u.getName() + " - " + u.getLogin());
        }
    }

    public void message(String msg) {
        System.out.println(msg);
    }
}
