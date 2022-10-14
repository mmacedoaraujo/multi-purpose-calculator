package com.mmacedo.calculator.multipurposecalculator.model.entities;

public class Calculator {

    private Double firstNumber;
    private Double currentNumber;
    private Double savedNumber;

    public Calculator() {
    }

    public Calculator(Double firstNumber, Double currentNumber, Double savedNumber) {
        this.firstNumber = firstNumber;
        this.currentNumber = currentNumber;
        this.savedNumber = savedNumber;
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Double getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Double currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Double getSavedNumber() {
        return savedNumber;
    }

    public void setSavedNumber(Double savedNumber) {
        this.savedNumber = savedNumber;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "firstNumber=" + firstNumber +
                ", currentNumber=" + currentNumber +
                ", savedNumber=" + savedNumber +
                '}';
    }
}
