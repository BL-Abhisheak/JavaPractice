package com.practice;

public class BiggestOf3Num {

    public String biggestNum(Integer a, Integer b, Integer c ){
        Integer max = a;

        if (b.compareTo(max)>0) 
            max=b;
        if (c.compareTo(max)>0)
            max=c;

        return "The biggest number is " + max;
    }

    public String floatBiggestNum(Float a, Float b, Float c ){
        Float max = a;

        if (b.compareTo(max)>0)
            max=b;
        if (c.compareTo(max)>0)
            max=c;

        return "The biggest Floating point number is " + max;
    }



    public String stringBiggest(String a, String b, String c ){
        String max = a;

        if (b.compareTo(max)>0)
            max=b;
        if (c.compareTo(max)>0)
            max=c;

        return "The biggest String is " + max;
    }


    public <T extends Comparable<T>> T genericBiggest(T a, T b, T c){
        T max = a;

        if (b.compareTo(max)>0)
            max=b;
        if (c.compareTo(max)>0)
            max=c;

        return (T) ("The biggest String is " + max);
    }



    public <T extends Comparable<T>> T genericBiggestUnlimitedArgs(T... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("At least one value required");
        }

        T max = values[0];

        for (T val : values) {
            if (val.compareTo(max) > 0) {
                max = val;
            }
        }

        return max;
    }




    public static void main(String[] args) {
        BiggestOf3Num big = new BiggestOf3Num();

        System.out.println(big.biggestNum(200000,50,1000000000));

        System.out.println(big.floatBiggestNum(5.7f,5.8f,5.4f));

        System.out.println(big.stringBiggest("Apple","Banana", "Camel"));

        System.out.println(big.genericBiggest(10,50,8));
        System.out.println(big.genericBiggest(5.7f, 22.6f,8.9f));
        System.out.println(big.genericBiggest("zenin", "toji", "fushigro"));

        System.out.println(big.genericBiggestUnlimitedArgs(10,40));
        System.out.println(big.genericBiggestUnlimitedArgs(200,40,56,88));
        System.out.println(big.genericBiggestUnlimitedArgs("Eren", "Itachi", "Light", "Gojo"));


    }
}
