//
// Created by Administrator on 2020/2/22 0022.
//

#include <jni.h>

jstring cstr2jstring(JNIEnv *env, const char *pat);

char *jstring2cstr(JNIEnv *env, jstring jstr);