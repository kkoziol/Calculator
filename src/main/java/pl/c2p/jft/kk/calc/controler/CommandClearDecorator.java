package pl.c2p.jft.kk.calc.controler;

class CommandClearDecorator implements ClickableCommand {
    private CalcController controller;
    private ClickableCommand command;

    public CommandClearDecorator(CalcController controller, ClickableCommand command) {
        this.controller = controller;
        this.command = command;
    }

    @Override
    public void doClick() {
        controller.calcWindow.setDisplay("");
        controller.calcModel.reset();
        command.doClick();
    }
}
