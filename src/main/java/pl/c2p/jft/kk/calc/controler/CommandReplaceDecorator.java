package pl.c2p.jft.kk.calc.controler;

class CommandReplaceDecorator implements ClickableCommand {
    private CalcController controller;
    private ClickableCommand command;

    public CommandReplaceDecorator(CalcController controller, ClickableCommand command) {
        this.controller = controller;
        this.command = command;
    }

    @Override
    public void doClick() {
        System.out.println("r");
        controller.calcWindow.setDisplay("");
        command.doClick();
    }
}
