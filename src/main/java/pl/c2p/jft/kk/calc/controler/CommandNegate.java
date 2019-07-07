package pl.c2p.jft.kk.calc.controler;

class CommandNegate implements ClickableCommand {

    private CalcController controller;

    public CommandNegate(CalcController controller) {
        this.controller = controller;
    }

    @Override
    public void doClick() {
        controller.calcWindow.setDisplay(controller.calcWindow.readDisplay().concat("-"));
    }
}
