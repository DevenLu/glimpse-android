package glimpse.core

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

object Glimpse : LifecycleObserver {
    internal lateinit var client: Application

    @JvmStatic
    fun init(app: Application) {
        client = app

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppOpened() {
        intpreter = newInterpreter()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppClosed() {
        intpreter?.close()
    }
}