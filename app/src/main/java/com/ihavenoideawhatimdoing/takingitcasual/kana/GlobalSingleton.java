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

    private String testvar;

    public void set_testvar(String s) {
        testvar = s;
    }
    public String get_testvar() {
        return testvar;
    }
}
