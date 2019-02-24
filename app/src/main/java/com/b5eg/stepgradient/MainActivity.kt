package com.b5eg.stepgradient

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pink = Colar(245, 9, 253)
        val lime = Colar(0, 253, 32)

        from_color.setBackgroundColor(Color.rgb(pink.r, pink.g, pink.b))
        to_color.setBackgroundColor(Color.rgb(lime.r, lime.g, lime.b))

        lp_1.colors = (pink toColor lime).run {
            gradient0 { 0 upTo 3 }
        }

        lp_2.colors = (pink toColor lime).run {
            gradient0 { 0 upTo 9 }
        }

        lp_3.colors = (pink toColor lime).run {
            gradient0 { 3 upTo 9}
        }


    }
}
