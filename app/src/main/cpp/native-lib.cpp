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
Java_wang_tyrael_learnandroid_jni_JNI_stringFromJNI(JNIEnv *env, jobject instance) {

    // TODO

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}