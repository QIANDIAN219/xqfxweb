package cn.edu.guet;

import cn.edu.guet.JDBC.MyConnection;
import cn.edu.guet.been.User;
import cn.edu.guet.dao.impl.UserDaoImpl;

public class test {
    public static void main(String[] args) {
        int n = 10;
        int t = 0;
        int k = 0;
        int[] arry = {23, 89, 2, 5, 50, 8, 10, 1, 25, 33};
/*        for(int i = 0; i < n-1; i++){
            for(int j = 8; j >= i; j--) {
                if(arry[j] > arry[j+1]) {
                    t = arry[j];
                    arry[j] = arry[j+1];
                    arry[j+1] = t;
                }

            }
            for(int c = 0; c < arry.length; c++) {
                System.out.print(" " + arry[c]);
            }
            System.out.println("");
        }*/
/*        for(int i = 0; i < arry.length; i++) {
            k = i;
            for(int j = i+1; j < arry.length; j++) {
                if(arry[j]<arry[k]) {
                    k = j;
                }
            }
            if(k != i) {
                t = arry[i];
                arry[i] = arry[k];
                arry[k] = t;
            }
            for(int c = 0; c < arry.length; c++) {
                System.out.print(" " + arry[c]);
            }
            System.out.println("");
        }*/
        System.out.println(gcd1(60, 24));
        System.out.println(gcd2(60, 24));
    }

    static int gcd1(int m, int n) {
        while (n != 0) {
            int mod = m%n;
            m = n;
            n = mod;
        }
        return m;
    }
    static int gcd2(int m, int n) {
        int min = Math.min(m, n);
        while(n%min != 0) {
            if(m%min != 0) {
                min--;
            } else if(n%min != 0) {
                min--;
            } else {
                return min;
            }
        }
        return min;
    }
}
