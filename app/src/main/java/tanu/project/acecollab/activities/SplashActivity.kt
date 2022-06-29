package tanu.project.acecollab.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_splash.*
import tanu.project.acecollab.R
import tanu.project.acecollab.firebase.FirestoreClass

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
            )

        val typeface:Typeface= Typeface.createFromAsset(assets,"montserrat.ttf")
        tv_app_name.typeface=typeface

        Handler().postDelayed({
            var currentUserID=FirestoreClass().getCurrentUserID()

            if(currentUserID.isNotEmpty()){
                startActivity(Intent(this,MainActivity::class.java))
            }
            else{
                startActivity(Intent(this,IntroActivity::class.java))
            }
            finish()
        },2500)

    }
}