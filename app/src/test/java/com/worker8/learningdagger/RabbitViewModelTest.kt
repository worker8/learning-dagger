package com.worker8.learningdagger

import com.worker8.learningdagger.multibinding.RabbitViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class RabbitViewModelTest {
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
            assertEquals(1, viewModelUnderTest.count)
//            Thread.sleep(1000)
            assertEquals(
                "Test UI thread",
                viewModelUnderTest.threadName1 + ":" + viewModelUnderTest.threadName2
            )
//            assertEquals("Test UI thread", viewModelUnderTest.threadName2)
//            assertEquals(true, viewModelUnderTest.threadName1.contains("Test UI thread"))
        }
    }
}
