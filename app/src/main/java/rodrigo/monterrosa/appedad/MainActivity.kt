package rodrigo.monterrosa.appedad

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtNacimiento = findViewById<EditText>(R.id.txtNacimiento)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtEdad = findViewById<TextView>(R.id.txtEdad)

        val objCalcEdad = CalcEdad()

        btnCalcular.setOnClickListener {

            val resul = objCalcEdad.restar(txtNacimiento.text.toString().toInt())
            println("Su edas entonces es de $resul jaja tas viejo")
            txtEdad.text = "El resultado es $resul ni modo, ya te vas a morir xddd"


        }
    }
}