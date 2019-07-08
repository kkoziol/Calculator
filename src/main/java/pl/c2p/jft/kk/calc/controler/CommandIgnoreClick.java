package pl.c2p.jft.kk.calc.controler;

public class CommandIgnoreClick implements ClickableCommand {
    @Override
    public void doClick() {
        System.out.println("klikaj");
    }
}
