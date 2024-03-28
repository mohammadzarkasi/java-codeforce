import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class ZuhairString2 
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

        var listHuruf = new ArrayList<Integer>();
        var listFreq = new ArrayList<Integer>();
        var setHuruf = new HashSet<Integer>();

        for(var i = 0; i<n; i++)
        {
            var c = str.charAt(i);
            // var freq = 1;
            var i2 = i+1;
            while(i2 < n)
            {
                var c2 = str.charAt(i2);
                if(c2 == c)
                {
                    // freq++;
                    i2++;
                }
                else
                {
                    break;
                }
            }
            var freq = i2-i;
            i += freq-1;
            listHuruf.add(c-'a');
            listFreq.add(freq);
            setHuruf.add(c-'a');
        }

        if(isDebug)
        {   
            for(var i = 0; i<listHuruf.size(); i++)
            {
                System.out.println("huruf: " + listHuruf.get(i) + " freq: " + listFreq.get(i));
            }
        }

        var highestFreq = 0;
        for(var item : setHuruf)
        {
            if(isDebug)
            {
                System.out.println("hitung freq untuk huruf: " + item);
            }
            var currFreq = 0;
            for(var i = 0; i < listHuruf.size(); i++)
            {
                var huruf = listHuruf.get(i);
                if(isDebug)
                {
                    System.out.println("huruf sedang dicek: " + huruf);
                }
                if(huruf == item)
                {
                    var freq = listFreq.get(i);
                    currFreq += freq/k;
                }
            }
            if(isDebug)
            {
                System.out.println("freq: " + currFreq);
            }
            if(highestFreq < currFreq)
            {
                highestFreq = currFreq;
            }
        }
        System.out.println(highestFreq);
    }    
}