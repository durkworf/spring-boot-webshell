package com.test.sp;

public class U extends ClassLoader{
    U(ClassLoader c){
        super(c);
    }
    public Class g(byte []b){
        return super.defineClass(b,0,b.length);
    }
}
