package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException
import kotlin.math.PI
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    var chk = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //General default settings
        tvInput.movementMethod=ScrollingMovementMethod()
        tvInput.isActivated = true
        tvInput.isPressed = true

        var text:String

        tvOne.setOnClickListener {
            text=tvInput.text.toString()+"1"
            tvInput.text=text
            result(text)
        }

        tvTwo.setOnClickListener {
            text=tvInput.text.toString()+"2"
            tvInput.text=text
            result(text)
        }
        tvThree.setOnClickListener {
            text=tvInput.text.toString()+"3"
            tvInput.text=text
            result(text)
        }
        tvFour.setOnClickListener {
            text=tvInput.text.toString()+"4"
            tvInput.text=text
            result(text)
        }
        tvFive.setOnClickListener {
            text=tvInput.text.toString()+"5"
            tvInput.text=text
            result(text)
        }
        tvSix.setOnClickListener {
            text=tvInput.text.toString()+"6"
            tvInput.text=text
            result(text)
        }
        tvSeven.setOnClickListener {
            text=tvInput.text.toString()+"7"
            tvInput.text=text
            result(text)
        }
        tvEight.setOnClickListener {
            text=tvInput.text.toString()+"8"
            tvInput.text=text
            result(text)
        }
        tvNine.setOnClickListener {
            text=tvInput.text.toString()+"9"
            tvInput.text=text
            result(text)
        }
        tvZero.setOnClickListener {
            text=tvInput.text.toString()+"0"
            tvInput.text=text
            result(text)
        }

        tvZeroZero.setOnClickListener {
            text=tvInput.text.toString()+"00"
            tvInput.text=text
            result(text)
        }

        tvDot.setOnClickListener {
            text=tvInput.text.toString()+"."
            tvInput.text=text
            result(text)
        }


        //Operations

        tvPlus.setOnClickListener {
            text=tvInput.text.toString()+"+"
            tvInput.text=text
            chk++
        }

        tvMinus.setOnClickListener {
            text=tvInput.text.toString()+"-"
            tvInput.text=text
            chk++
        }

        tvMultiply.setOnClickListener {
            text=tvInput.text.toString()+"*"
            tvInput.text=text
            chk++
        }

        tvDivide.setOnClickListener {
            text=tvInput.text.toString()+"/"
            tvInput.text=text
            chk++
        }

        tvPercent.setOnClickListener {
            text=tvInput.text.toString()+"%"
            tvInput.text=text
            chk++
        }

        //Equal Button
        tvEqual.setOnClickListener {
            text=tvOutput.text.toString()
            tvInput.text=""
            tvOutput.text=text
        }

        //Clear Button
        tvClear.setOnClickListener {
            tvInput.text=""
            tvOutput.text="Answer"
        }


        //Backspace
        tvBack.setOnClickListener {
            var BackSpace:String?=null
            if(tvInput.text.isNotEmpty()){
                val StringBuilder:StringBuilder=StringBuilder(tvInput.text)
                val find=tvInput.text.toString()
                val find2=find.last()

                if(find2=='+' || find2=='-' || find2=='/' || find2=='*' || find2=='%')chk--

                StringBuilder.deleteCharAt(tvInput.text.length-1)
                BackSpace=StringBuilder.toString()
                tvInput.text=BackSpace

                result(BackSpace)
            }
        }
    }

    private fun result(text: String) {
        val engine:ScriptEngine=ScriptEngineManager().getEngineByName("rhino")

        try{
            val result:Any=engine.eval(text)
            var mainResult =result.toString()

            if(chk==0){
                tvOutput.text=null
            }
            else{
                tvOutput.text=mainResult
            }
        }catch (e:ScriptException){
            Log.d("Error","Error in Script")
        }
    }
}