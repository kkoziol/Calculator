package pl.c2p.jft.kk.calc.controler;

public class CommandDivide implements ClickableCommand {
    private CalcController controller;

    public CommandDivide(CalcController controller) {
        this.controller = controller;
    }

    @Override
    public void doClick() {
        controller.calcModel.a = Double.parseDouble(controller.calcWindow.readDisplay());
        controller.calcModel.setOperator("/");
        controller.calcWindow.setDisplay("");
    }
}
