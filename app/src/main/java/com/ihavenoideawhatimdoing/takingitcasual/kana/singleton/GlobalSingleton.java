package com.ihavenoideawhatimdoing.takingitcasual.kana.singleton;

@SuppressWarnings("WeakerAccess")
public class GlobalSingleton {

    private static GlobalSingleton singletonObject;
    /** A private Constructor prevents any other class from instantiating. */
    private GlobalSingleton() {
        kanaMode = MODE_HIRAGANA;
        hideObsolete = true;
        hideDiacritics = false;
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
    private boolean hideObsolete;
    private boolean hideDiacritics;

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
    public void set_hideObsolete(boolean b){
        hideObsolete = b;
    }
    public boolean get_hideObsolete(){
        return hideObsolete;
    }
    public void set_hideDiacritics(boolean b){
        hideDiacritics = b;
    }
    public boolean get_hideDiacritics(){
        return hideDiacritics;
    }

    public String IndexToSound(int index){
        return Hiragana.IndexToSound(index);
    }
    public String IndexToHex(int index){
        return Hiragana.IndexToHex(index);
    }
    public String SoundToHex(String sound){
        return Hiragana.SoundToHex(sound);
    }
}
