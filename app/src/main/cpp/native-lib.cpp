#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_a3dol_faceless_io_a3dol_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
