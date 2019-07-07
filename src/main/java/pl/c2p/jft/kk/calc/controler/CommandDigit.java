package pl.c2p.jft.kk.calc.controler;

class CommandDigit implements ClickableCommand {

    private CalcController controller;
    private String digit;

    public CommandDigit(CalcController controller, String digit) {
        this.controller = controller;
        this.digit = digit;
    }

    @Override
    public void doClick() {
        controller.calcWindow.setDisplay(controller.calcWindow.readDisplay().concat(digit));
    }
}
