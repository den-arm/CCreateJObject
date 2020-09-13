package com.example.ccreatejobject;

abstract public class CounterNative {
    private int numb;
    static{
        System.loadLibrary("MyCounter");
    }
    public CounterNative(){
        numb = getN();
        nativeSetup();
    }
    abstract protected int getN();
    private native void nativeSetup();
}
