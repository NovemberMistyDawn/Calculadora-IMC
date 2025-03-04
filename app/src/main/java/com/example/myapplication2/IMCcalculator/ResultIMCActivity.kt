package com.example.myapplication2.IMCcalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication2.IMCcalculator.IMCActivity.Companion.IMC_KEY
import com.example.myapplication2.R

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
    }

    private fun initUI(result: Double){

        tvIMC.text = result.toString()
        //esto hace que si está entre estos valores te salga esto
when(result){
    in 0.00..18.50 -> { //bajo peso
tvIMC
        tvResult
        tvDescription

    }
    in 18.51..24.99 ->{ //peso normal
        tvIMC
        tvResult
        tvDescription
    }

    in 25.00..29.99->{ //sobrepeso
        tvIMC
        tvResult
        tvDescription
    }
    in 30.00..99.00->{ //obesidad
        tvIMC
        tvResult
        tvDescription
    }

    else -> {//error
        tvIMC.text = getString(R.string.error)
        tvResult.text= getString(R.string.error)
        tvDescription.text= getString(R.string.error)
    }
}
    }
    private fun initComponents(){
tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
    }
}