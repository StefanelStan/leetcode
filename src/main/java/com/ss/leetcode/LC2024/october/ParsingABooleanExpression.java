package com.ss.leetcode.LC2024.october;

import java.util.LinkedList;

public class ParsingABooleanExpression {
    // https://leetcode.com/problems/parsing-a-boolean-expression
    /** Algorithm
        1. Use two linkedLists or stacks: operands (t,f,( ) and operators (&, |, ! ) . We ignore the commas
        2. Traverse the expression and if current char is t,f ( add it to operands, else if it's & | ! - add it to operators.
        3. If you encounter a ) , pop / remove from operands until you encounter an opening parentheses, applying the operation from the top of operators stack.
        4. After applying the operation, put the result back on operands stack. (Also remove the open parenthesis)
     */
    public boolean parseBoolExpr(String expression) {
        LinkedList<Character> operands = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();
        char currentChar;
        for (int i = 0; i < expression.length(); i++) {
            currentChar = expression.charAt(i);
            switch(currentChar) {
                case ')' -> popAndEvaluate(operands, operators);
                case '!', '|', '&' -> operators.addLast(currentChar);
                case 't','f','(' -> operands.addLast(currentChar);
            }
        }
        return operands.pop() == 't';
    }

    private void popAndEvaluate(LinkedList<Character> operands, LinkedList<Character> operators) {
        boolean result = operands.peekLast() == 't', nextOperand;
        char operator = operators.isEmpty() ? '|' : operators.removeLast();
        while (!operands.isEmpty() && operands.peekLast() != '(') {
            nextOperand = operands.removeLast() == 't';
            result = operator == '&' ? result & nextOperand : operator == '!' ? !result : result | nextOperand;
        }
        if (!operands.isEmpty() && operands.peekLast() == '(') {
            operands.removeLast();
        }
        operands.addLast(result ? 't' : 'f');
    }
}
