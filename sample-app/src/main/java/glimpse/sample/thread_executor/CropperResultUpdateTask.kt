package glimpse.sample.thread_executor

import android.graphics.Bitmap
import android.widget.ImageView

class CropperResultUpdateTask(val imageView: ImageView) : Runnable {
    private var bitmap: Bitmap? = null

    fun setBackgroundBitmap(bitmap: Bitmap) {
        this.bitmap = bitmap
    }

    override fun run() {
        bitmap?.let { imageView.setImageBitmap(bitmap) }
    }
}
