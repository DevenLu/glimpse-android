package glimpse.sample.thread_executor

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


object CropperManager {
    private const val CORE_POOL_SIZE = 5
    private const val MAX_POOL_SIZE = 5
    private const val KEEP_ALIVE_TIME = 150

    private val downaloadWorkQueue = LinkedBlockingQueue<Runnable>()
    private val downloadThreadPool = ThreadPoolExecutor(
        CORE_POOL_SIZE,
        MAX_POOL_SIZE,
        KEEP_ALIVE_TIME.toLong(),
        TimeUnit.MILLISECONDS,
        downaloadWorkQueue
    )

    val mainThreadExecutor = MainThreadExecutor()

    fun runDownloadFile(task: Runnable) {
        downloadThreadPool.execute(task)
    }
}