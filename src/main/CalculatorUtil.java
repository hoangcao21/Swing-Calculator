/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.math.BigDecimal;

/**
 *
 * @author Hoang Cao
 */
public class CalculatorUtil {

    public String doCalculation(String num1, String oper, String num2) {
        String result = null;

        switch (oper) {
            case "+":
                result = (Double.valueOf(num1) + Double.valueOf(num2)) + "";
                break;
            case "-":
                result = (Double.valueOf(num1) - Double.valueOf(num2)) + "";
                break;
            case "x":
                result = (Double.valueOf(num1) * Double.valueOf(num2)) + "";
                break;
            case "/":
                if (num1.equals("0") && num2.equals("0")) {
                    result = "ERROR";
                    return result;
                }
                result = (Double.valueOf(num1) / Double.valueOf(num2)) + "";
                break;
        }
        result = checkDotZero(result);
        try {
            result = new BigDecimal(result).toPlainString();
        } catch (Exception ex) {
            result = "ERROR";
        }
        System.out.println("result: " + result);
        return result;
    }

//    public String doMemory(String num, String oper, String mem) {
//        String result = null;
//        switch (oper) {
//            case "M+":
//                result = (Double.valueOf(num) + Double.valueOf(mem)) + "";
//                break;
//            case "M-":
//                result = (Double.valueOf(mem) - Double.valueOf(num)) + "";
//                break;
//        }
//        result = checkDotZero(result);
//        result = new BigDecimal(result).toPlainString();
//        System.out.println("result: " + result);
//        return result;
//    }

    public String checkDotZero(String str) {
        if (str.matches("^-?\\d+\\.0+$")) {
            
            System.out.println("str = " + str);
            String[] splits = str.split("[.]");
            str = splits[0];
            System.out.println("Check dot zero = " + str);
        }
        return str;
    }
}
