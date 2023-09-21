package com.bignerdranch.android.nestedlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var buttonRoll: Button
    private lateinit var textViewLinearLayoutHor1: TextView
    private lateinit var textViewLinearLayoutHor2: TextView
    private lateinit var textViewLinearLayoutHor3: TextView
    private lateinit var textViewLinearLayoutVer1: TextView
    private lateinit var textViewLinearLayoutVer2: TextView
    private lateinit var textViewLinearLayoutVer3: TextView
    private lateinit var textViewConstraintLayout1: TextView
    private lateinit var textViewConstraintLayout2: TextView
    private lateinit var textViewConstraintLayout3: TextView

    private var currentIndex = 0

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRoll = findViewById(R.id.buttonRoll)

        textViewLinearLayoutHor1 = findViewById(R.id.textViewLinearLayoutHor1)
        textViewLinearLayoutHor2 = findViewById(R.id.textViewLinearLayoutHor2)
        textViewLinearLayoutHor3 = findViewById(R.id.textViewLinearLayoutHor3)

        textViewLinearLayoutVer1 = findViewById(R.id.textViewLinearLayoutVer1)
        textViewLinearLayoutVer2 = findViewById(R.id.textViewLinearLayoutVer2)
        textViewLinearLayoutVer3 = findViewById(R.id.textViewLinearLayoutVer3)

        textViewConstraintLayout1 = findViewById(R.id.textViewConstraintLayout1)
        textViewConstraintLayout2 = findViewById(R.id.textViewConstraintLayout2)
        textViewConstraintLayout3 = findViewById(R.id.textViewConstraintLayout3)

        buttonRoll.setOnClickListener() { view: View ->
            if (currentIndex == 0) {
                Log.i(TAG, "ZASHEEEEEEL")

                textViewLinearLayoutHor2.setText((textViewLinearLayoutHor1.text.toString().toInt() + 1).toString())
                textViewLinearLayoutVer2.setText((textViewLinearLayoutVer1.text.toString().toInt() + 1).toString())
                textViewConstraintLayout2.setText((textViewConstraintLayout1.text.toString().toInt() + 1).toString())

                textViewLinearLayoutHor1.setText("")
                textViewLinearLayoutVer1.setText("")
                textViewConstraintLayout1.setText("")

                ++currentIndex
            } else if (currentIndex == 1) {
                textViewLinearLayoutHor3.setText((textViewLinearLayoutHor2.text.toString().toInt() + 1).toString())
                textViewLinearLayoutVer3.setText((textViewLinearLayoutVer2.text.toString().toInt() + 1).toString())
                textViewConstraintLayout3.setText((textViewConstraintLayout2.text.toString().toInt() + 1).toString())

                textViewLinearLayoutHor2.setText("")
                textViewLinearLayoutVer2.setText("")
                textViewConstraintLayout2.setText("")

                ++currentIndex
            } else if (currentIndex == 2) {
                textViewLinearLayoutHor1.setText((textViewLinearLayoutHor3.text.toString().toInt() + 1).toString())
                textViewLinearLayoutVer1.setText((textViewLinearLayoutVer3.text.toString().toInt() + 1).toString())
                textViewConstraintLayout1.setText((textViewConstraintLayout3.text.toString().toInt() + 1).toString())

                textViewLinearLayoutHor3.setText("")
                textViewLinearLayoutVer3.setText("")
                textViewConstraintLayout3.setText("")

                currentIndex = 0
            }
        }
    }
}