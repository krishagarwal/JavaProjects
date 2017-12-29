package com.company.myapp;

import com.company.calcengine.PowerOf;
import com.company.calcengine.CalculateBase;
import com.company.calcengine.CalculateHelper;
import com.company.calcengine.DynamicHelper;
import com.company.calcengine.InvalidStatementException;
import com.company.calcengine.MathEquation;
import com.company.calcengine.Divider;
import com.company.calcengine.Adder;
import com.company.calcengine.MathProcessing;
import com.company.calcengine.Subtracter;
import com.company.calcengine.Multiplier;

public class Main {

    public static void main(String[] args) {

//        useMathEquation();
//        useCalculatorBase();
//        useCalculateHelper();

        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0"
        };


        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });

        for(String statement : statements){
            String output = helper.process(statement);
            System.out.println(output);
        }

    }

    static void useCalculateHelper(){

        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addX 0.0 0.0",
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();


        for (String statement : statements){
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("   Original exception: " + e.getCause().getMessage());
                }
            }
        }
    }

    static void useMathEquation(){

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100, 50);
        equations[1] = new MathEquation('a', 25,92);
        equations[2] = new MathEquation('s', 225, 17);
        equations[3] = new MathEquation('m', 11, 3);

        for(MathEquation equation : equations){
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("result = " + equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.println("result = " + equationOverload.getResult());

        equationOverload.execute((double)leftInt, rightInt);
        System.out.println("result = " + equationOverload.getResult());
    }

    static void useCalculatorBase(){

        System.out.println();
        System.out.println("using Inheritance");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for (CalculateBase calculator : calculators){
            calculator.calculate();
            System.out.println("result = " + calculator.getResult());
        }
    }
}
