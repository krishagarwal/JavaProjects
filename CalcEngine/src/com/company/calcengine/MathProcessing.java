package com.company.calcengine;

public interface MathProcessing {

    String SEPARATOR = " ";

    String getKeyWord();
    char getSymbol();
    double doCalculation(double leftVal, double rightVal);
}
