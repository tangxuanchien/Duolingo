package com.example.duolingo

import android.util.Log

private const val BASE_TAG = "APP"

fun Any.log(message: String) {
    val tag = "$BASE_TAG: [${this::class.java.simpleName}]"
    Log.d(tag, message)
}