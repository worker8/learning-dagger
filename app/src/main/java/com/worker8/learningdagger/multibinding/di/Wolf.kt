package com.worker8.learningdagger.multibinding.di

import com.worker8.learningdagger.multibinding.AbstractWolf
import javax.inject.Inject

class Wolf @Inject constructor() : AbstractWolf() {
    override fun howl() {
        // make noise...
    }
}
