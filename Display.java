import java.util.ArrayList;

public class Display {
    ArrayList<Todo> todos;
    Message message;

    Display(ArrayList<Todo> todos, Message message) {
        this.todos = todos;
        this.message = message;
    }

    public void update() {
        System.out.print("\033[H\033[2J");
        System.out.println(" ************* TODO LIST *************\n");
        System.out.println(" DONE   ID   TODO");
        for (int i = 0, n = this.todos.size(); i < n; i++) {
            Todo todo = this.todos.get(i);
            char done = todo.comleted ? '+' : '-';
            String id = String.valueOf(i + 1);
            String name = todo.name;
            // System.out.println(String.valueOf(i + 1) + ". " + this.todos.get(i).name);
            System.out.printf("   %c     %s   %s\n", done, id, name);
        }
        System.out.printf("\n\n\n");
        if (!this.message.value.isEmpty()) {
            System.out.println(" " + this.message.value);
        }
        System.out.printf(" -------------------------------------\n");
        System.out.printf(" Commands: add <name>, delete <id>, edit <id> <newname>, complete <id>, exit\n");
        System.out.printf(" ");
    }
}