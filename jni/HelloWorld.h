#include <jni.h>
/* Header for class HelloWorld */
#ifndef _Included_HelloWorld
#define _Included_HelloWorld
#ifdef __cplusplus
extern "C" {
#endif
/*
* Class: HelloWorld
* Method: print
* Signature: ()V
*/
JNIEXPORT void JNICALL Java_HelloWorld_print
   (JNIEnv *, jobject);
#ifdef __cplusplus
}
#endif
#endif
