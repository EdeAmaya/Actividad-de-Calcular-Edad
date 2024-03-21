package edenilson.amaya.edad_edenilson

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtañoAct = findViewById<EditText>(R.id.txtAñoActual)
        val txtfechaN = findViewById<EditText>(R.id.txtFechaNacimiento)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtedad = findViewById<TextView>(R.id.txtEdad)


        val objCalcEdad = CalcEdad()
        btnCalcular.setOnClickListener {
            val result = objCalcEdad.restar(txtañoAct.text.toString().toInt(),txtfechaN.text.toString().toInt())
            println("El resultado es: $result" )
            txtedad.text = "El resultado es $result"
        }

    }



}