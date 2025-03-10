package com.example.myapplication2.IMCcalculator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import org.w3c.dom.Text
import java.text.DecimalFormat
import com.example.myapplication2.R

class IMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true// si el usuario ha seleccionado hombre
    private var isFemaleSelected: Boolean = false   // si el usuario ha seleccionado mujer
    private var currentWeight: Int = 70   // peso actual del usuario (por defecto 70 kg)
    private var currentAge: Int = 30 // edad actual del usuario (por defecto 30 años)
    private var currentHeight: Int = 120  // altura actual del usuario (por defecto, 120 cm)

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button

    //que es lo de companion object
companion object {
const val IMC_KEY = "IMC_RESULT"
}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_imc_activity)  // asocia la actividad con su diseño XML

        // Llamamos a los metodos
        initComponents()   // inicializa los componentes de la interfaz
        initListeners() // configura los eventos de los botones
        initUI()  // ajusta la interfaz de usuario
    }


    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btncalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender() // alterna el género seleccionado
            setGenderColor() // cambia el color de las tarjetas de género
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##") // formatea el número con 2 decimales
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"  // muestra la altura seleccionada
        }
        btnPlusWeight.setOnClickListener {
            currentWeight += 1 // suma 1 kg
            setWeight() // actualiza la interfaz
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1  // resta 1 kg
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1  // suma 1 año
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1 // resta 1 año
            setAge()
        }

        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }

    }

    private fun navigateToResult(result:Double){
        //esto faltaría explicar
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY,result)
        startActivity(intent)
    }

//lo que hace la función calculateIMC
   private fun calculateIMC():Double{
       //esto es un formato decimal
       val df = DecimalFormat("#.##")
    //crea una variable llamada imc, que es resultado de calcular el porcentaje de dichos números
       val imc = currentWeight / (currentHeight.toDouble()/100*currentHeight.toDouble()/100)
    //crea una variable llamada resultado, que formatea el resultado para que tenga decimales
       return df.format(imc).toDouble()
    //crea un log en la consola para comprobar que va todo bien

   }


    private fun setAge() {
        tvAge.text = currentAge.toString() // muestra la edad actualizada en pantalla
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString() // muestra el peso actualizado
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected // invierte el valor actual (true/false)
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected // color para el seleccionado
        } else {
            R.color.background_component // color normal
        }

        return ContextCompat.getColor(this, colorReference)
    }


    private fun initUI() {
        setGenderColor() // ajusta los colores del género
        setWeight() // muestra el peso inicial
        setAge()  // muestra la edad inicial
    }
}
