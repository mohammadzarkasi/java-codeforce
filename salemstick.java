// https://codeforces.com/contest/1105/problem/A
// salem and sticks

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SalemSticks
{
    public static void main(String[] args)
    {
        int nStick, v;
        Scanner scan = new Scanner(System.in);
        HashMap<Integer,Integer> mymap = new HashMap<Integer,Integer>();

        nStick = scan.nextInt();
        for(int i = 0; i < nStick; i++)
        {
            v = scan.nextInt();
            if(mymap.containsKey(v) == true)
            {
                int oldV = mymap.get(v);
                mymap.replace(v, oldV+1);
            }
            else
            {
                mymap.put(v, 1);
            }
        }


        int minimumCost = Integer.MAX_VALUE;
        int tMinimum = -1;

        for(int i = 1; i <= 100; i++)
        {
            int cost = hitungCost(mymap, i);
            if(minimumCost > cost)
            {
                minimumCost = cost;
                tMinimum = i;
            }
        }

        System.out.println(tMinimum + " " + minimumCost);

        // // hitung frekuensi
        // int vWithHighestFreq = 0;
        // int highestFreq = -1;
        // for(var item : mymap.entrySet())
        // {
        //     if(item.getValue() > highestFreq)
        //     {
        //         vWithHighestFreq = item.getKey();
        //         highestFreq = item.getValue();
        //     }
        // }

        // int batasAtas = vWithHighestFreq + 1;
        // int batasBawah = vWithHighestFreq - 1;


    }

    public static int hitungCost(HashMap<Integer, Integer> mymap, int i) {
        int batasAtas = Math.min(i + 1, 100);
        int batasBawah = Math.max(i - 1, 0);
        int cost = 0;
        for(Map.Entry<Integer,Integer> item : mymap.entrySet())
        {
            int v = item.getValue();
            int k = item.getKey();
            if(k < batasBawah)
            {
                cost += Math.abs(k-batasBawah) * v;
            }
            else if(k > batasAtas)
            {
                cost += Math.abs(k-batasAtas) * v;
            }
        }
        return cost;
    }
}