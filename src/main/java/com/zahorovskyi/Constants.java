package com.zahorovskyi;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
     public static final List<Character> DICTIONARY = new ArrayList<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '));

     public static final List<Character> SIGN = new ArrayList<>(Arrays.asList(
             '.', ',', '«', '»', '"', '\'', ':', '!', '?'));

     public static final String DECRYPT = "DECRYPT";
     public static final String ENCRYPT = "ENCRYPT";
     public static final String BRUTE_FORCE = "BRUTE_FORCE";
}
