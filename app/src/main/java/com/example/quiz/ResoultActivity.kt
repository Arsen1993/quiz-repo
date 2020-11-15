package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resoult.*


class ResoultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resoult)

        val username = intent.getStringExtra(Constants.USER_NAME)
        val scorredPoints = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalPoints = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        finishActivityNameTV.text = username.toString()
        scoreTV.text = "you have scorred $scorredPoints from $totalPoints"

        finishButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}