package com.example.geoquiz
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geoquiz.databinding.ActivityCheatBinding

private const val EXTRA_TRUE = "com.example.geoquiz.ans_true"

private var answerIsTrue = false

class CheatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        answerIsTrue = intent.getBooleanExtra(EXTRA_TRUE,false)

        binding.showAnswerButton.setOnClickListener{
            val answerText = when {
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            binding.answerTextView.setText(answerText)
        }
    }
    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_TRUE, answerIsTrue)
            }
        }
    }
}