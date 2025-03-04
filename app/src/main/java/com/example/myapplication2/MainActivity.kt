package com.example.myapplication2

import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication2.IMCcalculator.IMCActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnSaludApp.setOnClickListener{navigateToSaludApp()}
        btnIMCApp.setOnClickListener {navigateToImcApp()}
    }

    private fun navigateToSaludApp() {
        TODO("Not yet implemented")
    }

    private fun navigateToImcApp() {
        val intent = Intent(this,IMCActivity::class.java)
        startActivity(intent)
    }


}