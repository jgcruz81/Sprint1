package main.com.adventure;

import main.com.adventure.settings.Command;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GameInputProcessor {

    /**
     * Starts the prompt process to the user.
     * @return the response from the user.
     */
    public String prompt() {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Enter your next command:");
        String response = scanner.nextLine();
        return response;
    }

    /**
     * Inputs that come into this method represent single action with no object. When building the command, you'll want
     * to supply the first word as the verb and leave the objectName blank
     * @param input - the input from the user
     * @return - the Command object with the proper verb and blank object
     */
    private Command buildSimpleCommand(String input) {
        String[] inputs = input.split(" ");
        return new Command(inputs[0], "");
    }

    /**
     * Inputs that come into this method will have an object or objects that the action is acting on. You'll need to
     * include the object as part of the Command object.
     * @param input - the input from the user
     * @return - the Command object with the proper verb and object
     */
    private Command buildCommandWithObject(String input) {
        String[] inputs = input.split(" ");
        return new Command(inputs[0], inputs[1]);
    }


    /** DO NOT CHANGE ANYTHING BELOW THIS LINE. **/

    /**
     * Gets the next command from the user.
     * @return a command object
     */
    public Command getNextCommand() {
        String input = prompt();
        return processCommand(input);
    }

    private Command processCommand(String input) {
        if (input.contains(Command.MOVE) ||
                input.contains(Command.USE) ||
                input.contains(Command.TAKE) ||
                input.contains(Command.EXAMINE)
        ) {
            return buildCommandWithObject(input);
        } else {
            return buildSimpleCommand(input);
        }
    }

}
