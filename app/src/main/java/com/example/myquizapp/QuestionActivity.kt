package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var pgBar : ProgressBar? = null
    private var pg : TextView? = null
    private var mcp : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedop : Int = 0
    private var tvQuestion : TextView? = null
    private var image : ImageView? = null
    private var correctAnswers : Int = 0
    private var opOne : TextView? = null
    private var opTwo : TextView? = null
    private var opThree : TextView? = null
    private var opFour : TextView? = null
    private var userName : String? = null
    private var submit : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        userName = intent.getStringExtra(Constants.USER_NAME)
        pgBar = findViewById(R.id.pg)
        pg = findViewById(R.id.tv_pg)
        tvQuestion = findViewById(R.id.displayQuestion)
        image = findViewById(R.id.image)
        opOne = findViewById(R.id.op_one)
        opTwo = findViewById(R.id.op_two)
        opThree = findViewById(R.id.op_three)
        opFour = findViewById(R.id.op_four)
        submit = findViewById(R.id.submit)
        mQuestionList = Constants.getQuestions()
        opOne?.setOnClickListener(this)
        opTwo?.setOnClickListener(this)
        opThree?.setOnClickListener(this)
        opFour?.setOnClickListener(this)
        submit?.setOnClickListener(this)
        setQuestion()
    }

    private fun setQuestion() {
        defaultOp()
        val question: Question = mQuestionList!![mcp - 1]
        pgBar?.progress = mcp
        pg?.text = "$mcp / ${pgBar?.max}"
        tvQuestion?.text = question.question
        opOne?.text = question.optionOne
        opTwo?.text = question.optionTwo
        opThree?.text = question.optionThree
        opFour?.text = question.optionFour
        image?.setImageResource(question.image)
        if(mcp == mQuestionList!!.size){
            submit?.text="FINISH"
        }
        else{
            submit?.text="SUBMIT" // remove
        }
    }
    private fun defaultOp(){
        val options = ArrayList<TextView>()
        opOne?.let { options.add(0, it) }
        opTwo?.let { options.add(1, it) }
        opThree?.let { options.add(2, it) }
        opFour?.let { options.add(3, it) }
        for(op in options){
            op.setTextColor(Color.parseColor("#7A8089"))
            op.typeface = Typeface.DEFAULT
            op.background = ContextCompat.getDrawable(this,
            R.drawable.default_option_border_bg)
        }
    }
    private fun selectedOp(select : TextView, selectedOp :Int){
        defaultOp()
        mSelectedop = selectedOp
        select.setTextColor(Color.parseColor("#363A43"))
        select.setTypeface(select.typeface,Typeface.BOLD)
        select.background = ContextCompat.getDrawable(this,
        R.drawable.selected_option_border_bg)
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.op_one ->{
                opOne?.let { selectedOp(it,1) }
            }
            R.id.op_two ->{
                opTwo?.let { selectedOp(it,2) }
            }
            R.id.op_three ->{
                opThree?.let { selectedOp(it,3) }
            }
            R.id.op_four ->{
                opFour?.let { selectedOp(it,4) }
            }
            R.id.submit ->{
                  if(mSelectedop == 0){
                      mcp++
                      when{
                          mcp<=mQuestionList!!.size ->{
                              setQuestion()
                          }
                          else ->{
                              val intent = Intent(this,ResultActivity::class.java)
                              intent.putExtra(Constants.USER_NAME,userName)
                              intent.putExtra(Constants.CORRECT_ANSWER,correctAnswers)
                              intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList?.size)
                              startActivity(intent)
                              finish()
                          }
                      }
                  }
                else{
                    val question = mQuestionList?.get(mcp-1)
                      if(question!!.correctAnswer != mSelectedop){
                          answerView(mSelectedop,R.drawable.wrong_option_bg)
                      }
                      else{
                          correctAnswers++
                      }
                      answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                  }
                if(mcp == mQuestionList!!.size){
                    submit?.text = "FINISH"
                }
                else{
                    submit?.text = "GO TO NEXT QUESTION"
                }
                mSelectedop =0
            }
        }

    }
    private fun answerView(ans : Int, drawableView: Int){
        when(ans){
            1 ->{
                opOne?.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 ->{
                opTwo?.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 ->{
                opThree?.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 ->{
                opFour?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}