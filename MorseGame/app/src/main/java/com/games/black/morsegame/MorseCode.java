package com.games.black.morsegame;


import java.util.HashMap;
import java.util.Set;

public class MorseCode {
    HashMap morseCharacters;
    MorseCode(){
        HashMap hashMap = new HashMap();
        hashMap.put("A", "._");
        hashMap.put("B", "_...");
        hashMap.put("C", "_._.");
        hashMap.put("D", "_..");
        hashMap.put("E", ".");
        hashMap.put("F", ".._.");
        hashMap.put("G", "__.");
        hashMap.put("H", "....");
        hashMap.put("I", "..");
        hashMap.put("J", ".___");
        hashMap.put("K", "_._");
        hashMap.put("L", "._..");
        hashMap.put("M", "__");
        hashMap.put("N", "_.");
        hashMap.put("O", "___");
        hashMap.put("P", ".__.");
        hashMap.put("Q", "__._");
        hashMap.put("R", "._.");
        hashMap.put("S", "...");
        hashMap.put("T", "_");
        hashMap.put("U", ".._");
        hashMap.put("V", "..._");
        hashMap.put("W", ".__");
        hashMap.put("X", "_.._");
        hashMap.put("Y", "_.__");
        hashMap.put("Z", "__..");
        morseCharacters=hashMap;
    }

    public HashMap getMorseCharacters() {
        return morseCharacters;
    }

    Set getKeys(){
        return morseCharacters.keySet();
    }
}
