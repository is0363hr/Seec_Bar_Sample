package com.example.internship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.view.View
import android.graphics.Color

class MainActivity : AppCompatActivity(){

    private var r = 0
    private var g = 0
    private var b = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBarRed: SeekBar = findViewById(R.id.seekBarRed)
        val seekBarGreen: SeekBar = findViewById(R.id.seekBarGreen)
        val seekBarBlue: SeekBar = findViewById(R.id.seekBarBlue)

        setupSeekBar(seekBarRed, "r")
        setupSeekBar(seekBarGreen, "g")
        setupSeekBar(seekBarBlue, "b")
    }

    private fun setupSeekBar(seekBar: SeekBar, colorFlag:String)
    {
        seekBar.progress = 0
        seekBar.max = 255
        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    when(colorFlag){
                        "r" -> r = progress
                        "g" -> g = progress
                        "b" -> b = progress
                    }

                    val colorView: View = findViewById(R.id.colorView)
                    colorView.setBackgroundColor(Color.rgb(r, g, b))
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                }
            })
    }
}
