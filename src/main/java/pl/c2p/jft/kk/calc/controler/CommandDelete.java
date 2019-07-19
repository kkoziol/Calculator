package pl.c2p.jft.kk.calc.controler;

class CommandDelete implements ClickableCommand {
    private CalcController controller;

    public CommandDelete(CalcController controller) {

        this.controller = controller;
    }

    @Override
    public void doClick() {
        String s = controller.calcWindow.readDisplay();
        StringBuilder sb = new StringBuilder();
        String toDisplay = s.substring(0, s.length() - 1);
        controller.calcWindow.setDisplay(toDisplay);
    }
}
