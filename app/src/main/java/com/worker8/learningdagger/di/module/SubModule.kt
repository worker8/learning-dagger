package com.worker8.learningdagger.di.module

import com.worker8.learningdagger.di.SubComponentA
import dagger.Module

@Module(subcomponents = [SubComponentA::class])
class SubModule