package com.tuhin.javapreps.strings;

/**
 * Created by tuhinmandal on 18/07/16.
 */
public class IsPalindrome {


    public boolean isPalindrome(String str) {
        if(str == null) {
            return false;
        }

        int length = str.length();
        for(int i =0; i < length/2; i++) {
            if(str.charAt(i) != str.charAt(length -i -1)) {
                return false;
            }
        }
        return true;
    }

    public static  void main(String args[]) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean isIt = isPalindrome.isPalindrome("abcba");
        System.out.println(isIt);
    }
}
