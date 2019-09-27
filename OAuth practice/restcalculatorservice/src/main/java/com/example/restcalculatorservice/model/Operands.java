package com.example.restcalculatorservice.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Operands {


    @NotEmpty(message = "Operand 1 cannot be empty")
    private Integer operand1;

    @NotNull(message = "Operand 2 cannot be empty")
    private Integer operand2;

    public Integer getOperand1() {
        return operand1;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }
}
