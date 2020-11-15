package com.example.quiz

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition: Int = 1
    private var questionList: ArrayList<Questions>? = null
    private var selectedOptionPosition: Int = 0
    private var correctAnswer: Int = 0
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        questionList = Constants.getQuestion()

        userName = intent.getStringExtra(Constants.USER_NAME)

        setQuestion()

        optionOneTV.setOnClickListener(this)
        optionTwoTV.setOnClickListener(this)
        optionThreeTV.setOnClickListener(this)
        optionFourTV.setOnClickListener(this)
        submitID.setOnClickListener(this)
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun setQuestion() {

        setBackgroundDefault()

        if(currentPosition == questionList!!.size) {
            submitID.text = "FINISH"
        } else {
            submitID.text = "SUBMIT"
        }

        val progBarId = progBarId
        progBarId.max = questionList!!.size

        // TODO: 10/13/20 make randomazier for questions
        val question = questionList!![currentPosition - 1]

        questionTV.text = question.question
        flagImage.setImageResource(question.image)
        progBarId.progress = currentPosition
        progText.text = "$currentPosition" + "/" + progBarId.max
        optionOneTV.text = question.optionOne
        optionTwoTV.text = question.optionTwo
        optionThreeTV.text = question.optionThree
        optionFourTV.text = question.optionFour
    }

    private fun setBackgroundDefault() {

        val optionsTextView = ArrayList<TextView>()
        optionsTextView.add(0, optionOneTV)
        optionsTextView.add(1, optionTwoTV)
        optionsTextView.add(2, optionThreeTV)
        optionsTextView.add(3, optionFourTV)

        for( option in optionsTextView) {
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border)
        }
    }

    private fun setBackgroundSelected(tV: TextView, selectedOptionNumber: Int) {
        setBackgroundDefault()

        selectedOptionPosition = selectedOptionNumber

        tV.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)
        }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.optionOneTV -> {
                setBackgroundSelected(optionOneTV, 1)
            }
            R.id.optionTwoTV -> {
                setBackgroundSelected(optionTwoTV, 2)
            }
            R.id.optionThreeTV -> {
                setBackgroundSelected(optionThreeTV, 3)
            }
            R.id.optionFourTV -> {
                setBackgroundSelected(optionFourTV, 4)
            }
            R.id.submitID -> {
                if (selectedOptionPosition == 0) {
                    currentPosition++

                    when{
                        currentPosition <= questionList!!.size -> {
                            setQuestion()
                        } else -> {

                        val intent = Intent(this, ResoultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, userName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswer)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, questionList!!.size)
                        startActivity(intent)

                    }

                    }
                } else {
                    val question = questionList?.get(currentPosition - 1)

                    if(question!!.correctAnswer != selectedOptionPosition ) {
                        answerView(selectedOptionPosition, R.drawable.wrong_answer_mode)
                    } else {
                        correctAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_answer_mode)

                    if(currentPosition == questionList!!.size){
                        submitID.text = "Finish"


                    } else {
                        submitID.text = "Go to the next question"
                    }
                    selectedOptionPosition = 0
                }

            }
    }
}

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                optionOneTV.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                optionTwoTV.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                optionThreeTV.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                optionFourTV.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}