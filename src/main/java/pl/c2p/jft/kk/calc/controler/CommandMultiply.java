package pl.c2p.jft.kk.calc.controler;

public class CommandMultiply implements ClickableCommand {
    private CalcController controller;

    public CommandMultiply(CalcController controller) {
        this.controller = controller;
    }

    @Override
    public void doClick() {
        System.out.println("*");
        controller.calcModel.setFirstOperand(Double.parseDouble(controller.calcWindow.readDisplay()));
        controller.calcModel.setOperator("*");
        controller.calcWindow.setDisplay("");
    }
}
