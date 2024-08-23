package com.example.geoquiz


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.geoquiz.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.trueButton.setOnClickListener{view: View ->
            if (quizViewModel.ans){
                Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show()
            }
        }
        binding.falseButton.setOnClickListener{view: View ->
            if (!quizViewModel.ans){
                Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show()
            }
        }
        binding.nextButton.setOnClickListener{view: View ->
            quizViewModel.moveToNext()
            updateQuestion()
        }
        binding.prevButton.setOnClickListener{view: View ->
            quizViewModel.moveToPrev()
            updateQuestion()
        }
        binding.cheatButton.setOnClickListener { view: View ->
            // Start CheatActivity
            val answerIsTrue = quizViewModel.ans
            val intent = CheatActivity.newIntent(this@MainActivity, answerIsTrue)

            startActivity(intent)
        }

        updateQuestion()
    }
    private fun updateQuestion(){
        binding.questionTextView.setText(quizViewModel.questionText)
    }
}