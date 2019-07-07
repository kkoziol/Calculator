package pl.c2p.jft.kk.calc.controler;

import pl.c2p.jft.kk.calc.controler.ClickableCommand;

public class CommandIgnoreClick implements ClickableCommand {
    @Override
    public void doClick() {
        System.out.println("klikaj");
    }
}
