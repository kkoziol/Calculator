package pl.c2p.jft.kk.calc.controler;

class CommandSubstract implements ClickableCommand {
    private CalcController controller;

    public CommandSubstract(CalcController controller) {
        this.controller = controller;
    }

    @Override
    public void doClick() {
        System.out.println("-");
        controller.calcModel.setFirstOperand(Double.parseDouble(controller.calcWindow.readDisplay()));
        controller.calcModel.setOperator("-");
        controller.calcWindow.setDisplay("");
    }
}
