package com.worker8.learningdagger

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.worker8.learningdagger.multibinding.RabbitViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

class RabbitViewModelTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("Test Main UI thread")
    @Inject
    lateinit var viewModelUnderTest: RabbitViewModel
    val testComponent = DaggerTestViewModelComponent.builder().build()

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        testComponent.inject(this)
        viewModelUnderTest.viewActions = object : RabbitViewModel.ViewActions {
            override fun setProgressBarVisibility(visibility: Boolean) {
                // do nothing
            }
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun testFetchNames() {
        runBlockingTest {
            viewModelUnderTest.coroutineScope = this
            viewModelUnderTest.onCreate()
            assertEquals(2, viewModelUnderTest.listLiveData.getOrAwaitValue().count())
        }
    }
}
