package com.tsystems.javaschool.tasks.calculator;

import java.util.*;

public class Calculator {

    public String evaluate(String statement) {

        if (statement == null || statement.isEmpty())
            return null;

        Stack<Token> opStack = new Stack<>();
        List<Token> prefixTokenList = new ArrayList<>();
        List<Token> tokenList = new ArrayList<>();

        String st = statement.replaceAll("\\s+", "");
        String delims = "((?<=-)|(?=-)|" +
                "(?<=\\+)|(?=\\+)|" +
                "(?<=/)|(?=/)|" +
                "(?<=\\*)|(?=\\*))|" +
                "(?<=\\()|(?=\\()|" +
                "(?<=\\)|(?=\\)))";

        List<String> stringTokens = Arrays.asList(st.split(delims));

        for (String token : stringTokens) {
            tokenList.add(new Token(token));
        }


        try {
            for (Token token : tokenList) {
                if (token.isType()) {
                    prefixTokenList.add(token);
                } else if (token.getPrec() == 0)
                    opStack.push(token);
                else if (token.getPrec() == 1) {
                    Token topToken = opStack.pop();
                    while (topToken.getPrec() != 0) {
                        prefixTokenList.add(topToken);
                        topToken = opStack.pop();
                    }
                } else {
                    while (!opStack.isEmpty() && (opStack.peek().getPrec() >= token.getPrec())) {
                        prefixTokenList.add(opStack.peek());
                    }
                    opStack.push(token);
                }
            }
        } catch (EmptyStackException e) {
            return null;
        }

        while (!opStack.isEmpty()) {
            prefixTokenList.add(opStack.peek());
        }

        return calculator(prefixTokenList);
    }

    private String calculator(List<Token> prefixTokenList) {
        Stack<Double> stack = new Stack<>();
        double A, B, result;


        try {
            for (Token token : prefixTokenList) {

                if (!token.isType()) {
                    B = stack.pop();
                    A = stack.pop();
                    try {
                        result = basicOperation(token.getOp(), A, B);
                        stack.push(result);
                    } catch (NullPointerException e) {
                        return null;
                    }

                } else
                    stack.push(token.getValue());
            }
        } catch (EmptyStackException e) {
            return null;
        }

        result = stack.pop();
        if ((result == Math.floor(result)) && !Double.isInfinite(result))
            return String.valueOf((int) result);
        else
            return String.valueOf(result);

    }

    private Double basicOperation(char op, double A, double B) {

        Double result = 0.0;

        switch (op) {
            case '+':
                result = A + B;
                break;
            case '-':
                result = A - B;
                break;
            case '*':
                result = A * B;
                break;
            case '/':
                if (B == 0.0)
                    return null;
                result = A / B;
        }
        return result;
    }
}