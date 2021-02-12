package com.example.internship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.graphics.Color
import com.example.internship.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var r = 0
    private var g = 0
    private var b = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listOf(binding.seekBarRed, binding.seekBarGreen, binding.seekBarBlue).forEach {
            setupSeekBar(it)
        }
    }

    private fun setupSeekBar(seekBar: SeekBar) {
        seekBar.progress = SEEK_BAR_PROGRESS
        seekBar.max = SEEK_BAR_MAX
        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    when (seekBar) {
                        binding.seekBarRed -> r = progress
                        binding.seekBarGreen -> g = progress
                        binding.seekBarBlue -> b = progress
                    }
                    binding.viewColorPanel.setBackgroundColor(Color.rgb(r, g, b))
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                }
            })
    }

    companion object {
        private const val SEEK_BAR_PROGRESS = 0
        private const val SEEK_BAR_MAX = 255
    }
}
