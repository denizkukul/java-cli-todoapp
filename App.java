import java.util.ArrayList;
import java.util.Scanner;

public class App {

    ArrayList<Todo> todos;
    Message message;
    Controller controller;
    Display display;

    App() {
        this.todos = new ArrayList<Todo>();
        this.message = new Message();
        this.display = new Display(this.todos, this.message);
        this.controller = new Controller(this.todos, this.message);
    }

    public static void main(String[] args) {

        App app = new App();
        Scanner scanner = new Scanner(System.in);

        do {
            app.display.update();
            app.controller.run(scanner.nextLine());
        } while (app.controller.waitingCommand);

        scanner.close();
    }
}
