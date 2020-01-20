package com.worker8.learningdagger

fun Any.identityHashCode() = "0x" + Integer.toHexString(System.identityHashCode(this))