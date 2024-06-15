package dev.artenes.template.app.samples.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint
import dev.artenes.template.core.interfaces.Notifications
import dev.artenes.template.core.models.CountDownTimer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class TimerService : Service() {

    @Inject
    lateinit var scope: CoroutineScope

    @Inject
    lateinit var notifications: Notifications

    private lateinit var timer: TimerWithNotificationAndSoundModel

    override fun onCreate() {
        super.onCreate()
        timer = TimerWithNotificationAndSoundModel(scope, CountDownTimer(), notifications)
        Timber.d("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder = LocalBinder()

    inner class LocalBinder : Binder() {

        fun getTimer() = timer

    }

    override fun onDestroy() {
        Timber.d("onDestroy")
        scope.cancel("onDestroy")
    }

}