package com.worker8.dagger_android

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

class DemoActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_android)
    }
}
