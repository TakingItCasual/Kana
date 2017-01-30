package com.ihavenoideawhatimdoing.takingitcasual.kana.singleton;

class Katakana {

    private static final String[][] kataMain = {
            {"a", "30a2"},
            {"i", "30a4"},
            {"u", "30a6"},
            {"e", "30a8"},
            {"o", "30aa"},

            {"ka", "30ab"},
            {"ki", "30ad"},
            {"ku", "30af"},
            {"ke", "30b1"},
            {"ko", "30b3"},

            {"ga", "30ac"},
            {"gi", "30ae"},
            {"gu", "30b0"},
            {"ge", "30b2"},
            {"go", "30b4"},

            {"sa", "30b5"},
            {"shi", "30b7"},
            {"su", "30b9"},
            {"se", "30bb"},
            {"so", "30bd"},

            {"za", "30b6"},
            {"ji", "30b8"},
            {"zu", "30ba"},
            {"ze", "30bc"},
            {"zo", "30be"},

            {"ta", "30bf"},
            {"chi", "30c1"},
            {"tsu", "30c4"},
            {"te", "30c6"},
            {"to", "30c8"},

            {"da", "30c0"},
            {"di", "30c2"},
            {"du", "30c5"},
            {"de", "30c7"},
            {"do", "30c9"},

            {"na", "30ca"},
            {"ni", "30cb"},
            {"nu", "30cc"},
            {"ne", "30cd"},
            {"no", "30ce"},

            {"ha", "30cf"},
            {"hi", "30d2"},
            {"fu", "30d5"},
            {"he", "30d8"},
            {"ho", "30db"},

            {"ba", "30d0"},
            {"bi", "30d3"},
            {"bu", "30d6"},
            {"be", "30d9"},
            {"bo", "30dc"},

            {"pa", "30d1"},
            {"pi", "30d4"},
            {"pu", "30d7"},
            {"pe", "30da"},
            {"po", "30dd"},

            {"ma", "30de"},
            {"mi", "30df"},
            {"mu", "30e0"},
            {"me", "30e1"},
            {"mo", "30e2"},

            {"ya", "30e4"},
            {"", "0000"},
            {"yu", "30e6"},
            {"", "0000"},
            {"yo", "30e8"},

            {"ra", "30e9"},
            {"ri", "30ea"},
            {"ru", "30eb"},
            {"re", "30ec"},
            {"ro", "30ed"},

            {"wa", "30ef"},
            {"wi", "30f0"},
            {"", "0000"},
            {"we", "30f1"},
            {"wo", "30f2"},

            {"n", "30f3"},
            {"vu", "30f4"},
            {"", "0000"},
            {"", "0000"},
            {"", "0000"},
    };

    static final String[][] kataMini = {
            {"a", "30a1"},
            {"i", "30a3"},
            {"u", "30a5"},
            {"e", "30a7"},
            {"o", "30a9"},

            {"ya", "30e3"},
            {"", "0000"},
            {"yu", "30e5"},
            {"", "0000"},
            {"yo", "30e7"},

            {"tsu", "30c3"},
            {"", "0000"},
            {"", "0000"},
            {"", "0000"},
            {"", "0000"},
    };

    static String IndexToSound(int index){
        return kataMain[index][0];
    }
    static String IndexToHex(int index){
        return kataMain[index][1];
    }
    static String SoundToHex(String sound){
        for(String[] kana : kataMain){
            if(sound.equals(kana[0])){
                return kana[1];
            }
        }
        return "0000";
    }
}
