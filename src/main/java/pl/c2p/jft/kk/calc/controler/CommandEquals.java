package pl.c2p.jft.kk.calc.controler;


public class CommandEquals implements ClickableCommand {
    private CalcController controller;

    public CommandEquals(CalcController controller) {

        this.controller = controller;
    }

    @Override
    public void doClick() {
        System.out.println("=");
        controller.calcModel.b = Double.parseDouble(controller.calcWindow.readDisplay());

        switch (controller.calcModel.getOperator()) {
            case "+":
                controller.calcModel.result = controller.calcModel.a + controller.calcModel.b;
                break;

            case "-":
                controller.calcModel.result = controller.calcModel.a - controller.calcModel.b;
                break;

            case "*":
                controller.calcModel.result = controller.calcModel.a * controller.calcModel.b;
                break;

            case "/":
                if (controller.calcModel.b == 0) {
                    controller.calcWindow.setDisplay("Error");
                    return;
                }
                controller.calcModel.result = controller.calcModel.a / controller.calcModel.b;
                break;
        }
        controller.calcWindow.setDisplay("" + controller.calcModel.result);
        controller.calcModel.reset();
    }
}
