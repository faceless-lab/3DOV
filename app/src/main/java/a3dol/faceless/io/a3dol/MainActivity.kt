package a3dol.faceless.io.a3dol

import android.graphics.Canvas
import android.os.Bundle
import com.google.vr.sdk.base.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.microedition.khronos.egl.EGLConfig
import android.R.attr.y
import android.R.attr.x
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Path.FillType
import android.graphics.Point


class MainActivity : GvrActivity(), GvrView.StereoRenderer {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gvr_view.setRenderer(this)

        gvrView = gvr_view
    }

    override fun onNewFrame(head: HeadTransform?) {
        val canvas = Canvas()
        val p1 = Point(0, 0)
        val pointX = gvrView.width / 2
        val pointY = gvrView.height

        val p2 = Point(pointX, pointY)
        val p3 = Point(gvrView.width, 0)


        val path = Path()
        path.fillType = Path.FillType.EVEN_ODD
        path.moveTo(p1.x.toFloat(), p1.y.toFloat())
        path.lineTo(p2.x.toFloat(), p2.y.toFloat())
        path.lineTo(p3.x.toFloat(), p3.y.toFloat())
        path.close()
        canvas.drawPath(path, Paint(Paint.ANTI_ALIAS_FLAG))
        gvrView.draw(canvas)
    }

    override fun onSurfaceChanged(p0: Int, p1: Int) {
        TODO("not implemented")
    }

    override fun onSurfaceCreated(conf: EGLConfig?) {
        TODO("not implemented")
    }

    override fun onDrawEye(eye: Eye?) {
        TODO("not implemented")
    }

    override fun onFinishFrame(port: Viewport?) {
        TODO("not implemented")
    }

    override fun onRendererShutdown() {
        TODO("not implemented")
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
