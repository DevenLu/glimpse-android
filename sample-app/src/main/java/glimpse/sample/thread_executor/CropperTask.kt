package glimpse.sample.thread_executor

import android.graphics.Bitmap
import glimpse.core.crop
import glimpse.core.findCenter

class CropperTask(private val original: Bitmap, private val resultUpdateTask: CropperResultUpdateTask) : Runnable {

    override fun run() {
        val (x, y) = original.findCenter()
        val cropped = original.crop(x, y, resultUpdateTask.imageView.width, resultUpdateTask.imageView.height)

        resultUpdateTask.setBackgroundBitmap(cropped)
        CropperManager.mainThreadExecutor.execute(resultUpdateTask)
    }
}
