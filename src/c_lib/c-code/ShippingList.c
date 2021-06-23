#include<stdio.h>
#include<stdlib.h>
#include "ShippingList.h"
#include "TDALista.h"

JNIEXPORT jdouble JNICALL Java_c_1lib_ShippingjList_ShippingList
    (JNIEnv *env, jclass this, jdoubleArray inJNIArray){
    // To get Values from Java
    jdouble *inCArray = (*env)->GetDoubleArrayElements(env, inJNIArray, NULL);
    /*if (NULL == inCArray) return NULL;*/
    jsize length = (*env)->GetArrayLength(env, inJNIArray);

    //Trabalhando com uma Lista de Struct
    struct TipoLista lista;
    struct TipoLista lista_nova;

    Inicializa(&lista);
    Inicializa(&lista_nova);

    // insere todos os valores doubles em uma lista
    int i;
    for (i = 0; i < length; i++) {
        if(i % 2 == 0 ){
            Insere(inCArray[i], inCArray[i+1], &lista);
        }
    }

    jdouble menordistancia = BuscaMenorDistancia(&lista);

    return menordistancia;

}
