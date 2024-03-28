// Zuhair and Strings
// https://codeforces.com/contest/1105/problem/B

import java.util.Scanner;

class ZuhairString 
{
    public static void main(String[] args)
    {
        var scan = new Scanner(System.in);
        int n, k;
        String str;
        
        n = scan.nextInt();
        k = scan.nextInt();
        str = scan.next();
        var isDebug = false;

        var highestLevel = 0;
        for(var i = 0; i < n-k; i++)
        {
            var substr = str.substring(i, i+k);
            if(isDebug==true)
            {
                System.out.println("substr: " + substr + " at " + i + "," + (i+k));
            }
            var isSubstrQualified = checkSubstrQualified(substr, k);
            if(isDebug)
            {
                System.out.println("substr is qualified: " + isSubstrQualified);
            }
            if(isSubstrQualified == true)
            {
                var countSubstr = 1;
                for(var j = i+k+1; j < n-k; j++)
                {
                    var nextSubstr = str.substring(j, j+k);
                    if(isDebug)
                    {
                        System.out.println("next substr: " + nextSubstr + " at " + j + "," + (j+k));
                    }
                    if(nextSubstr.equals(substr) == true)
                    {
                        if(isDebug)
                        {   
                            System.out.println("next substr is match");
                        }
                        countSubstr++;
                        // i+=k-1;
                        j += k-1;
                    }
                    else
                    {

                    }
                }
                if(highestLevel < countSubstr)
                {
                    highestLevel = countSubstr;
                    if(isDebug)
                    {
                        System.out.println("current level: " + countSubstr);
                        System.out.println("highest level: " + highestLevel);
                    }
                }
            }
            if(isDebug)
            {
                System.out.println();
            }
        }
        System.out.println(highestLevel);
    }

    private static boolean checkSubstrQualified(String substr, int length) {
        var firstChar = substr.charAt(0);
        for(var i = 1; i<length;i++)
        {
            var currentChar = substr.charAt(i);
            if(currentChar != firstChar)
            {
                return false;
            }
        }
        return true;
    }
}