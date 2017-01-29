package com.ihavenoideawhatimdoing.takingitcasual.kana;

@SuppressWarnings("WeakerAccess")
public class GlobalSingleton {

    private static GlobalSingleton singletonObject;
    /** A private Constructor prevents any other class from instantiating. */
    private GlobalSingleton() {
        //	 Optional Code
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

    public void set_testvar(String s) {
        testvar = s;
    }
    public String get_testvar() {
        return testvar;
    }
    public void set_kanaMode(int n) { kanaMode = n; }
    public int get_kanaMode() { return kanaMode; }
    public void set_hideObsolete(boolean n) { hideObsolete = n; }
    public boolean get_hideObsolete() { return hideObsolete; }
    public void set_hideDiacritics(boolean n) { hideDiacritics = n; }
    public boolean get_hideDiacritics() { return hideDiacritics; }
}
