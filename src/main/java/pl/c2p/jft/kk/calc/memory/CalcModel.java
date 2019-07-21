package pl.c2p.jft.kk.calc.memory;

public class CalcModel {

    private double a = 0, b = 0;
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
    public double getFirstOperand() {
        return a;
    }

    public void setFirstOperand(double a) {
        this.firstOperand = true;
        this.a = a;
    }
    public double getSecondOperand() {
        return b;
    }

    public void setSecondOperand(double b) {
        this.secondOperand = true;
        this.b = b;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }
}
