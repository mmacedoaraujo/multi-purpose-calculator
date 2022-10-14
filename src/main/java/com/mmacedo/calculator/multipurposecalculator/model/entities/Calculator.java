package com.mmacedo.calculator.multipurposecalculator.model.entities;

public class Calculator {

    private Integer firstNumber;
    private Integer currentNumber;
    private Integer savedNumber;

    public Calculator() {
    }

    public Calculator(Integer firstNumber, Integer currentNumber, Integer savedNumber) {
        this.firstNumber = firstNumber;
        this.currentNumber = currentNumber;
        this.savedNumber = savedNumber;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Integer getSavedNumber() {
        return savedNumber;
    }

    public void setSavedNumber(Integer savedNumber) {
        this.savedNumber = savedNumber;
    }

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }
}
