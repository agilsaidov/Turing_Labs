package turing;

public class RomanToInteger {
    public int romanToInt(String s) {
        char[] roman = new char[] {'I','V','X','L','C','D','M'};
        int[] integers = new int[] {1,5,10,50,100,500,1000};

        int result = 0;
        int pre = 0;
        for(int i =s.length()-1; i>=0;i--){
            int value = 0;
            for(int j = 0;j<roman.length;j++){
                if(s.charAt(i)==roman[j]){
                    value = integers[j];
                    break;
                }
            }
            if(pre>value){
                result -= value;
            }else{
                result += value;
                pre = value;
            }
        }
        return result;

    }
}
