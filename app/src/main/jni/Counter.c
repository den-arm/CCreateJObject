#include <jni.h>

//
// Created by den on 2020/09/11.
//
jobject m_object,m_rv_object;
jfieldID m_fid;
jmethodID m_rv_mid;

JNIEXPORT void JNICALL
Java_com_example_ccreatejobject_CounterNative_nativeSetup(JNIEnv *env,jobject thiz){
    jclass clazz = (*env)->GetObjectClass(env,thiz);
    m_object = (jobject)(*env)->NewGlobalRef(env,thiz);
    m_fid = (*env)->GetFieldID(env,clazz,"numb","I");
    jclass rvClazz = (*env)->FindClass(env,"com/example/ccreatejobject/ResultValue");
    jmethodID constr = (*env)->GetMethodID(env,rvClazz,"<init>","()V");
    jobject ref = (*env)->NewObject(env,rvClazz,constr);
    m_rv_object = (jobject)(*env)->NewGlobalRef(env,ref);
    m_rv_mid = (*env)->GetMethodID(env,rvClazz,"setV","(I)V");
    return;
}

JNIEXPORT jobject JNICALL
Java_com_example_ccreatejobject_actNative_nativeExec(JNIEnv *env,jclass clazz){
    int n,i,sum=0;

    n = (int)(*env)->GetIntField(env,m_object,m_fid);

    for(i=0;i<=n;i++)
        sum+=i;

    (*env)->CallVoidMethod(env,m_rv_object,m_rv_mid,sum);

    return m_rv_object;
}