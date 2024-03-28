// https://codeforces.com/contest/527/problem/A 
// playing with paper

import java.util.Scanner;

class PlayingWithStick
{
    public static void main(String[] args){
        Long a, b, c, sb, b2;
        Long count = 0L;
        Scanner scan = new Scanner(System.in);
        a = scan.nextLong();
        b = scan.nextLong();
        
        while(true)
        {
            if (b == 0)
            {
                break;
            }
            if ( b==1 )
            {
                count += a;
                break;
            }
            b2 = a / b;
            sb = a % b;
            count += b2;

            if (sb > b)
            {
                a = sb;
            }
            else
            {
                a = b;
                b = sb;
            }
            // count++;
            // c = a-b;
            // System.out.println("a: " + a);
            // System.out.println("b: " + b);
            // System.out.println("c: " + c);
            // System.out.println();
            
            // if(c > b)
            // {
            //     a = c;
            // }
            // else
            // {
            //     a = b;
            //     b = c;
            // }
        }
        System.out.println(count);
    }
}