package com.example.myapplication2

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication2.IMCcalculator.IMCActivity
import com.example.myapplication2.TODOapp.TODOActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO= findViewById<Button>(R.id.btnTODO)
        btnSaludApp.setOnClickListener{navigateToSaludApp()}
        btnIMCApp.setOnClickListener {navigateToImcApp()}
        btnTODO.setOnClickListener {navigateTODO()}
    }

    private fun navigateToSaludApp() {
        TODO("Not yet implemented")
    }

    private fun navigateToImcApp() {
        val intent = Intent(this,IMCActivity::class.java)
        startActivity(intent)
    }

        private fun navigateTODO() {
        val intent = Intent(this,TODOActivity::class.java)
        startActivity(intent)
    }


}