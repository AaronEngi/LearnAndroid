#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_wang_tyrael_learnandroid_jni_NativeFunction_stringFromJNI(JNIEnv *env, jobject instance) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_wang_tyrael_learnandroid_jni_NativeFunction_sizeOfLong(JNIEnv *env, jobject instance) {
    return sizeof(long);
}

extern "C"
JNIEXPORT jint JNICALL
Java_wang_tyrael_learnandroid_jni_NativeFunction_sizeOfJlong(JNIEnv *env, jobject instance) {
    return sizeof(jlong);
}

extern "C"
JNIEXPORT void JNICALL
Java_wang_tyrael_learnandroid_jni_NativeFunction_testLong(JNIEnv *env, jobject instance, jlong l) {
    jclass javaMethodClass = env->FindClass("wang/tyrael/learnandroid/jni/JavaMethod");
    jmethodID javaMethodInit = env->GetMethodID(javaMethodClass, "<init>", "()V");
    jobject javaMethod = env->NewObject(javaMethodClass, javaMethodInit);
    jmethodID jmID = env->GetMethodID(javaMethodClass, "testLong", "(J)V");
    env->CallVoidMethod(javaMethod, jmID, l);
}