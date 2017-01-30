package com.ihavenoideawhatimdoing.takingitcasual.kana.singleton;

@SuppressWarnings("WeakerAccess")
public class GlobalSingleton {

    private static GlobalSingleton singletonObject;
    /** A private Constructor prevents any other class from instantiating. */
    private GlobalSingleton() {
        kanaMode = MODE_KATAKANA;
        showObsolete = false;
        showDiacritics = true;
    }
    public static synchronized GlobalSingleton getSingletonObject() {
        if (singletonObject == null) {
            singletonObject = new GlobalSingleton();
        }
        return singletonObject;
    }
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public final int MODE_HIRAGANA = 0;
    public final int MODE_KATAKANA = 1;

    private String testvar;
    private int kanaMode;
    private boolean showObsolete;
    private boolean showDiacritics;

    public void set_testvar(String s){
        testvar = s;
    }
    public String get_testvar(){
        return testvar;
    }
    public void set_kanaMode(int n){
        kanaMode = n;
    }
    public int get_kanaMode(){
        return kanaMode;
    }
    public void set_showObsolete(boolean b){
        showObsolete = b;
    }
    public boolean get_showObsoletee(){
        return showObsolete;
    }
    public void set_showDiacritics(boolean b){
        showDiacritics = b;
    }
    public boolean get_showDiacritics(){
        return showDiacritics;
    }

    public String IndexToSound(int index){
        if(kanaMode == MODE_HIRAGANA) {
            return Hiragana.IndexToSound(index);
        }else if(kanaMode == MODE_KATAKANA){
            return Katakana.IndexToSound(index);
        }
        return "Invalid kanaMode";
    }
    public String IndexToHex(int index){
        if(kanaMode == MODE_HIRAGANA) {
            return Hiragana.IndexToHex(index);
        }else if(kanaMode == MODE_KATAKANA){
            return Katakana.IndexToHex(index);
        }
        return "Invalid kanaMode";
    }
    public String SoundToHex(String sound){
        if(kanaMode == MODE_HIRAGANA) {
            return Hiragana.SoundToHex(sound);
        }else if(kanaMode == MODE_KATAKANA){
            return Katakana.SoundToHex(sound);
        }
        return "Invalid kanaMode";
    }
}
