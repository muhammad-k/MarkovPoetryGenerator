package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<String> temp = new HashSet<>();


        temp.add("hello");
        temp.add("temp");
        temp.add("world");

        int temp2 = (int)((temp.size() * Math.random()));
        System.out.println(temp2);



        Map<String,Set<String>> songMap = (loadMap(sanitizeCorpus("The gal dem Schillaci, Sean da Paul\n" +
                "So me give it to, so me give to, so me give it to, to all girls\n" +
                "Five million and forty naughty shorty,\n" +
                "Baby girl, all my girls, all my girls Sean da Paul sey,\n" +
                "Well woman the way the time cold I wanna be keepin' you warm\n" +
                "I got the right temperature to shelter you from the storm\n" +
                "Oh lord, gal I got the right tactics to turn you on, and girl I,\n" +
                "Wanna be the Papa, You can be the Mom, oh oh!\n" +
                "Make I see the gal them bruk out pon the floor\n" +
                "From you don't want no worthless performer\n" +
                "From you don't want no man wey\n" +
                "Can't turn you on gal make I see your hand them up on ya\n" +
                "Can't tan pon it long, naw eat no yam, no steam fish, nor no green banana\n" +
                "But down in Jamaica we give it to you hot like a sauna\n" +
                "Well woman the way the time cold I wanna be keepin' you warm\n" +
                "I got the right temperature to shelter you from the storm\n" +
                "Oh lord, gal I got the right tactics to turn you on, and girl I,\n" +
                "Wanna be the Papa, You can be the Mom, oh oh!\n" +
                "Bumper exposed and gal you got your chest out\n" +
                "But you no wasters cause gal you impress out,\n" +
                "And if you des out a me you fi test out,\n" +
                "Cause I got the remedy to make you de-stress out\n" +
                "Me haffi flaunt it because me God Bless out,\n" +
                "And girl if you want it you haffi confess out,\n" +
                "A no lie weh we need set speed a fi test the mattress out\n" +
                "Well woman the way the time cold I wanna be keepin' you warm\n" +
                "I got the right temperature to shelter you from the storm\n" +
                "Oh lord, gal I got the right tactics to turn you on, and girl I,\n" +
                "Wanna be the Papa, You can be the Mom, oh oh!\n" +
                "Gal don't say me crazy now, this Strangelove it a no Bridgette and Flava show\n" +
                "Time fi a make baby now so stop gwaan like you a act shady yo,\n" +
                "Woman don't play me know, cause a no Fred Sanford nor Grady yo,\n" +
                "My lovin' is the way to go, my lovin' is the way to go\n" +
                "Well woman the way the time cold I wanna be keepin' you warm\n" +
                "I got the right temperature to shelter you from the storm\n" +
                "Oh lord, gal I got the right tactics to turn you on, and girl I,\n" +
                "Wanna be the Papa, You can be the Mom, oh oh!\n" +
                "When you roll with a player like me,\n" +
                "With a bredda like me girl there is no other\n" +
                "No need to talk it right here just park it right here keep it undercover\n" +
                "From me love how you fit inna you blouse\n" +
                "And you fat inna you jeans and mi waan discover\n" +
                "Everything out you baby girl can you hear when me utter,\n" +
                "Well woman the way the time cold I wanna be keepin' you warm\n" +
                "I got the right temperature to shelter you from the storm\n" +
                "Oh lord, gal I got the right tactics to turn you on, and girl I,\n" +
                "Wanna be the Papa, You can be the Mom, oh oh!")));

        randomKey(songMap);


        for(Map.Entry<String, Set<String>> entry : songMap.entrySet()){
            System.out.println("KEY: " + entry.getKey());
            System.out.println("VALUES: " + entry.getValue());
            System.out.println("-------------------------");
        }



    }

    private static String[] sanitizeCorpus(String corpus){

        //Takes corpus, turns it lowercase, removes punctuation and then replaces the line break with a ""
        corpus = corpus.toLowerCase().replaceAll("\\p{Punct}","").replaceAll("\n", " ");

        //Turning the entire string into single word arrays for easier traversal
        String[] corpusArray = corpus.split(" ");

        return corpusArray;
    }

    private static Map loadMap(String[]  corpusArray){

        //This is what holds all the values, a map where each key is a unique word
        //I used a set because we do not want the following words to repeat
        Map<String,Set<String>> songMap = new HashMap<>();

        for(int i = 0; i < corpusArray.length - 1; i++){

            //Here we check if the key is contained within the map,
            //if it is we add the value to the set
            if(songMap.containsKey(corpusArray[i]))
                songMap.get(corpusArray[i]).add(corpusArray[i+1]);
            //Otherwise, we create a new key and then
            else{
                Set<String> valList = new HashSet<>();
                valList.add(corpusArray[i+1]);
                songMap.put(corpusArray[i], valList);
            }

        }

        return songMap;
    }

    //Returns a random key from the keyset
    private static String randomKey(Map corpusPairs){

        List<String> keysAsArray = new ArrayList<>(corpusPairs.keySet());

        return keysAsArray.get((int)((keysAsArray.size() * Math.random())));
    }


    private static String writeLine(Map corpusPairs, int length){

        String line = "";

        for(int i = 0; i < length; i++){

            String randomString = randomKey(corpusPairs);

            //---------------------------LAST EDIT  HERE---------------------
            String temp = corpusPairs.get(randomString).toString();

        }

        return "";
    }


}

