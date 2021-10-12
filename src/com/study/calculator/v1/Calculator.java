package com.study.calculator.v1;

public class Calculator {

    private CustomSeperator customSeperator;

    public Calculator(CustomSeperator customSeperator) {
        this.customSeperator = customSeperator;
    }

    public int add(String str) {

        if(isBlank(str)){
            return 0;
        }


        int sum = 0;
        String sep = customSeperator.getSeperator(str);
        String target = customSeperator.getTarget(str);

        String[] split = target.split("["+sep+"]");
        for( String s : split) {
            try {
                int result = Integer.parseInt(s);
                if(result < 0 ) {
                    throw new RuntimeException();
                }
                sum += result;
            }
            catch (NumberFormatException ex){
                throw new NumberFormatException();
            }
        }
        return sum;
    }

    private boolean isBlank(String str) {
        if(str == null ||  str.isEmpty() ){
            return true;
        }
        return false;
    }
}
