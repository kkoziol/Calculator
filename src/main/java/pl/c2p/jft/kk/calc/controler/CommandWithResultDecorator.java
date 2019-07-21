package pl.c2p.jft.kk.calc.controler;

class CommandWithResultDecorator implements ClickableCommand {
    private CalcController controller;
    private ClickableCommand command;

    public CommandWithResultDecorator(CalcController controller, ClickableCommand command) {
        this.controller = controller;
        this.command = command;
    }

    @Override
    public void doClick() {
        controller.commands.get("=").doClick();
        double result = controller.calcModel.getResult();
        command.doClick();
        controller.calcWindow.setDisplay("" + result);
    }
}
