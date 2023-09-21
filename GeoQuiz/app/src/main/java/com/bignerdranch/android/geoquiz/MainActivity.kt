package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    private  lateinit var questionTextView: TextView

    private val questionBank = listOf (
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex = 0

    private var percentCorrect = 0

    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_buttton)
        questionTextView = findViewById(R.id.question_text_view)


        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)

            enabledButton(false)
        }

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)

            enabledButton(false)
        }

        nextButton.setOnClickListener { view: View ->
            currentIndex = (currentIndex + 1) % questionBank.size

            enabledButton(true)

            if (currentIndex == questionBank.size - 1) {
                Toast.makeText(
                    this,
                    (round(percentCorrect.toDouble() / questionBank.size * 100)).toString() +
                    "% correct answer",
                    Toast.LENGTH_SHORT
                ).show()

                percentCorrect = 0
            }

            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun enabledButton(isEnable: Boolean) {
        trueButton.isEnabled = isEnable
        falseButton.isEnabled = isEnable
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId: Int
        if (userAnswer == correctAnswer) {
            messageResId = R.string.correct_toast
            
            if (percentCorrect != questionBank.size) {
                ++percentCorrect
            }
        } else {
            messageResId = R.string.incorrect_toast
        }

        Log.i(TAG, "percentCorrect: " + percentCorrect)

        Toast.makeText(
            this,
            messageResId,
            Toast.LENGTH_SHORT
        ).show()
    }
}