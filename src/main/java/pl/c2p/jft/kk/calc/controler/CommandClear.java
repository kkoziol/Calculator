package pl.c2p.jft.kk.calc.controler;

class CommandClear implements ClickableCommand {
    private CalcController controller;

    public CommandClear(CalcController controller) {
        this.controller = controller;
    }

    @Override
    public void doClick() {
        controller.calcWindow.setDisplay("");
        controller.calcModel.reset();
    }
}
