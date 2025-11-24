package com.prac;

import java.util.HashMap;

public class FreqCount1 {
    HashMap<String,Integer> map1= new HashMap<>();
    HashMap<String,Integer> map2= new HashMap<>();
    HashMap<String,Integer> map3 = new HashMap<>();
    HashMap<String,Integer> map4 = new HashMap<>();


    //find frequency of a particular word
    public void findFreqOfWord(String sentence){

        for (String word : sentence.toLowerCase().split(" ")){
            map1.put(word,map1.getOrDefault(word,0)+1);
        }


        for (String word : map1.keySet()){
            System.out.println("Word : " + word + " - Frequency : " + map1.get(word));
        }

        System.out.println("The frequency of 'to' is " + map1.get("to") );
    }


    public void findFreqOfParagraph(String paragraph){
        for (String para : paragraph.toLowerCase().split(" ")){
            map2.put(para,map2.getOrDefault(para,0)+1);
        }

        for (String para : map2.keySet()){
            System.out.println("Word : " + para + " - Frequency : " + map2.get(para));
        }
        System.out.println("The ferquency of 'paranoid' is " + map2.get("paranoid"));
    }


    //remove duplicate words and print all the words only once
    public void removeDuplicates(String sentence){
        StringBuilder removeDup = new StringBuilder();
        for (String para : sentence.toLowerCase().split(" ")){
            map3.put(para,map3.getOrDefault(para,0)+1);
        }

        for (String word:sentence.toLowerCase().split(" ")){
            if (map3.get(word)>0){
                removeDup.append(word).append(" ");
                map3.put(word, 0); // mark as printed so it won't print again
            }
        }
        System.out.println(removeDup.toString());
    }


    //print only the words which are unique
    public void onlyUnique(String sentence){
        StringBuilder onlyUnique = new StringBuilder();

        for (String word : sentence.toLowerCase().split(" ")){
            map4.put(word,map4.getOrDefault(word,0)+1);
        }


        for (String word : sentence.toLowerCase().split(" ")){
            if (map4.get(word)==1){
                onlyUnique.append(word).append(" ");
            }
        }

        System.out.println(onlyUnique.toString());
    }




    public static void main(String[] args) {
        FreqCount1 fc = new FreqCount1();
        fc.findFreqOfWord("To be or not to be");
        fc.findFreqOfParagraph("Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations");
        fc.removeDuplicates("To be or not to be");
        fc.onlyUnique("To be or not to be");
    }
}
