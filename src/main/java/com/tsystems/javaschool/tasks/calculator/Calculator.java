package com.tsystems.javaschool.tasks.calculator;

import java.util.*;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */

    public String evaluate(String statement) {

        if (statement == null || statement.isEmpty())
            return null;

        Stack<Token> opStack = new Stack<>();
        List<Token> prefixTokenList = new ArrayList<>();
        List<Token> tokenList = new ArrayList<>();

        String st = statement.replaceAll("\\s+", "");
        String regex = "((?<=-)|(?=-)|" +
                "(?<=\\+)|(?=\\+)|" +
                "(?<=/)|(?=/)|" +
                "(?<=\\*)|(?=\\*))|" +
                "(?<=\\()|(?=\\()|" +
                "(?<=\\)|(?=\\)))";

        List<String> stringTokens = Arrays.asList(st.split(regex));

        for (String token : stringTokens) {
            tokenList.add(new Token(token));
        }

        try {
            for (Token token : tokenList) {
                if (token.isType()) {
                    prefixTokenList.add(token);
                } else if (token.getPriority() == 0)
                    opStack.push(token);
                else if (token.getPriority() == 1) {
                    Token topToken = opStack.pop();
                    while (topToken.getPriority() != 0) {
                        prefixTokenList.add(topToken);
                        topToken = opStack.pop();
                    }
                } else {
                    while (!opStack.isEmpty() && (opStack.peek().getPriority() >= token.getPriority())) {
                        prefixTokenList.add(opStack.pop());
                    }
                    opStack.push(token);
                }
            }
        } catch (EmptyStackException e) {
            return null;
        }

        while (!opStack.isEmpty()) {
            prefixTokenList.add(opStack.pop());
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
                    } catch (NullPointerException e) {
                        return null;
                    }
                    stack.push(result);
                } else
                    stack.push(token.getValue());
            }
        } catch (EmptyStackException e) {
            return null;
        }

        result = stack.pop();
        if ((result == Math.floor(result)) && !Double.isInfinite(result))
            return String.valueOf((int) result);
        else {
            String.valueOf(roundOff(result));
            return String.valueOf(roundOff(result));
        }

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
                if (B == 0)
                    return null;
                result = A / B;
        }
        return result;
    }

    private double roundOff(double value) {

        if (String.valueOf(value).split("\\.")[1].length() > 5)
            return (double) Math.round(value * 10000) / 10000;
        else
            return value;
    }

}