package pl.c2p.jft.kk.calc.controler;

class CommandDoNothing implements ClickableCommand {

    private CalcController controller;

    public CommandDoNothing(CalcController controller) {
        this.controller = controller;
    }

    @Override
    public void doClick() {
    }
}
