package edu.otc.lifecycle

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView = findViewById<TextView>(R.id.textView)

        // Retrieve data from Intent
        val userName = intent.getStringExtra("UserName") ?: "No name provided"
        val pizzaCount = intent.getIntExtra("PizzaCount", 0)
        val pizzaType = intent.getStringExtra("PizzaType") ?: "Unknown"
        val toppings = intent.getStringArrayListExtra("Toppings")

        val toppingsList = toppings?.joinToString(", ") ?: "No toppings"

        // Display order summary
        textView.text = """
            Order Summary:
            Name: $userName
            Pizzas Ordered: $pizzaCount
            Pizza Type: $pizzaType
            Toppings: $toppingsList
        """.trimIndent()
    }
}

