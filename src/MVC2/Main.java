package MVC2;

public class Main {
    public static void main(String[] args) {

        UserView view = new UserView();
        UserController controller = new UserController(view);

        controller.start();
    }
}