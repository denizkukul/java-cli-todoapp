public class Command {
    String name;
    int target;
    String arg;
    Message message;

    Command(String input, Message message) {
        String[] inputArr = input.split(" ");

        this.name = inputArr[0];
        this.message = message;

        switch (this.name) {
            case "add":
                this.arg = joinFromIndex(inputArr, 1);
                break;
            case "delete":
            case "complete":
                this.target = parseId(inputArr[1]);
                break;
            case "edit":
                this.target = parseId(inputArr[1]);
                this.arg = joinFromIndex(inputArr, 2);
                break;
            case "exit":
                break;
        }

    }

    private int parseId(String str) {
        int id;
        try {
            id = Integer.parseInt(str);
        } catch (Exception e) {
            message.set("Invalid id: " + str);
            id = -1;
        }
        return id;
    }

    private String joinFromIndex(String[] arr, int index) {
        String result = "";
        for (int i = index; i < arr.length; i++) {
            result = result.concat(arr[i]);
            if (i + 1 < arr.length) {
                result = result.concat(" ");
            }
        }
        return result;
    }
}
