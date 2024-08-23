package com.example.geoquiz
import androidx.lifecycle.ViewModel
class QuizViewModel: ViewModel() {
    private val questionBank = listOf (
        Question(R.string.question_australia,true),
        Question(R.string.question_asia,true),
        Question(R.string.question_americas,true),
        Question(R.string.question_oceans,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_africa,false)
    )
    //   private val questionActive = BooleanArray(questionBank.size)
    private var currentIndex = 0
    var ans = questionBank[currentIndex].answer
    val questionText: Int
        get() = questionBank[currentIndex].textResId
    fun moveToNext(){
        currentIndex = (currentIndex+1).mod(questionBank.size)
    }
    fun moveToPrev(){
        currentIndex = (currentIndex-1).mod(questionBank.size)
    }
}