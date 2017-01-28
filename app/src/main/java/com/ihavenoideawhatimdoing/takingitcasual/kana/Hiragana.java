package com.ihavenoideawhatimdoing.takingitcasual.kana;

public class Hiragana {

    public static final String[][] hiraTable = {
            {"a", "3042"},
            {"i", "3044"},
            {"u", "3046"},
            {"e", "3048"},
            {"o", "304a"},

            {"ka", "304b"},
            {"ki", "304d"},
            {"ku", "304f"},
            {"ke", "3051"},
            {"ko", "3053"},

            {"ga", "304c"},
            {"gi", "304e"},
            {"gu", "3050"},
            {"ge", "3052"},
            {"go", "3054"},

            {"sa", "3055"},
            {"shi", "3057"},
            {"su", "3059"},
            {"se", "305b"},
            {"so", "305d"},

            {"za", "3056"},
            {"ji", "3058"},
            {"zu", "305a"},
            {"ze", "305c"},
            {"zo", "305e"}
    };

    public static String IndexToSound(int index){
        return hiraTable[index][0];
    }
    public static String IndexToHex(int index){
        return hiraTable[index][1];
    }
    public static String SoundToHex(String sound){
        for(String[] kana : hiraTable){
            if(sound.equals(kana[0])){
                return kana[1];
            }
        }
        return "fail";
    }

}
