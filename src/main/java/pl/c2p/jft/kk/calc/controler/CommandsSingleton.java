package pl.c2p.jft.kk.calc.controler;

import java.util.HashMap;

public class CommandsSingleton {

    private static CommandsSingleton instance = new CommandsSingleton();

    HashMap<String, ClickableCommand> commands = new HashMap<>();

    private CommandsSingleton() {
        System.out.println("Komenty robie!!!");
    }

    public static CommandsSingleton getInstance(){
        return instance;
    }

    public void put(String key, ClickableCommand command) {
        commands.put(key,command);
    }

    public ClickableCommand get(String key) {
        return commands.get(key);
    }
}
