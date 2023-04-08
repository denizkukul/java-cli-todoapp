import java.util.ArrayList;

public class Controller {
    boolean waitingCommand;
    Message message;
    ArrayList<Todo> todos;

    Controller(ArrayList<Todo> todos, Message message) {
        this.todos = todos;
        this.message = message;
        this.waitingCommand = true;
    }

    public void run(String input) {
        Command command = new Command(input, message);
        message.set("");

        switch (command.name) {
            case "add":
                if (command.arg.isEmpty()) {
                    message.set("<name> must be provided.");
                } else {
                    todos.add(new Todo(command.arg, false));
                }
                break;
            case "delete":
                if (command.target != -1) {
                    try {
                        todos.remove(command.target - 1);
                    } catch (Exception e) {
                        message.set("Todo with id: " + command.target + " cannot be found.");
                    }
                }
                break;
            case "edit":
                if (command.target != -1) {
                    try {
                        todos.get(command.target - 1).name = command.arg;
                    } catch (Exception e) {
                        message.set("Todo with id: " + command.target + " cannot be found.");
                    }
                }
                break;
            case "complete":
                if (command.target != -1) {
                    try {
                        todos.get(command.target - 1).comleted = true;
                    } catch (Exception e) {
                        message.set("Todo with id: " + command.target + " cannot be found.");
                    }
                }
                break;
            case "exit":
                waitingCommand = false;
                break;
            default:
                message.set("Unknown command: " + command.name);
        }
    }
}