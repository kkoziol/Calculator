package pl.c2p.jft.kk.calc.controler;

class CommandDecimalPoint implements ClickableCommand {

    private CalcController controller;

    public CommandDecimalPoint(CalcController controller) {
        this.controller = controller;
    }

    @Override
    public void doClick() {
        System.out.println(".");
        controller.calcWindow.setDisplay(controller.calcWindow.readDisplay().concat("."));
    }
}
