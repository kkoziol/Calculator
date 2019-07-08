package pl.c2p.jft.kk.calc.memory;

public class CalcModel {

    public double a = 0, b = 0;
    public double result;

    private boolean firstOperand;
    private boolean secondOperand;
    String operator = "";

    public void reset(){
        a = 0;
        b = 0;
        result = 0;
        operator = "";
        firstOperand = false;
        secondOperand = false;

    }

    public boolean isFirstOperand() {
        return firstOperand;
    }

    public boolean isSecondOperand() {
        return secondOperand;
    }

    public void setFirstOperand(boolean firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(boolean secondOperand) {
        this.secondOperand = secondOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
