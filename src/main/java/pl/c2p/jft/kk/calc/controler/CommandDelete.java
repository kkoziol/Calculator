package pl.c2p.jft.kk.calc.controler;

class CommandDelete implements ClickableCommand {
    private CalcController controller;

    public CommandDelete(CalcController controller) {

        this.controller = controller;
    }

    @Override
    public void doClick() {
        String s = controller.calcWindow.readDisplay();
        controller.calcWindow.setDisplay("");
        for (int i = 0; i < s.length() - 1; i++)
            controller.calcWindow.setDisplay(controller.calcWindow.readDisplay() + s.charAt(i));
    }
}
