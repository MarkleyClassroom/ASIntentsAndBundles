package edu.otc.lifecycle

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextPizzaCount = findViewById<EditText>(R.id.editTextPizzaCount)
        val spinnerPizzaType = findViewById<Spinner>(R.id.spinnerPizzaType)
        val checkBoxCheese = findViewById<CheckBox>(R.id.checkBoxCheese)
        val checkBoxPepperoni = findViewById<CheckBox>(R.id.checkBoxPepperoni)
        val checkBoxMushrooms = findViewById<CheckBox>(R.id.checkBoxMushrooms)
        val buttonOrder = findViewById<Button>(R.id.buttonOrder)

        // Set up dropdown with pizza types
        val pizzaTypes = arrayOf("Margherita", "Pepperoni", "BBQ Chicken", "Veggie")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pizzaTypes)
        spinnerPizzaType.adapter = adapter

        buttonOrder.setOnClickListener {
            val userName = editTextName.text.toString().trim()
            val pizzaCount = editTextPizzaCount.text.toString().toIntOrNull() ?: 0
            val selectedPizzaType = spinnerPizzaType.selectedItem.toString()

            val selectedToppings = mutableListOf<String>()
            if (checkBoxCheese.isChecked) selectedToppings.add("Extra Cheese")
            if (checkBoxPepperoni.isChecked) selectedToppings.add("Pepperoni")
            if (checkBoxMushrooms.isChecked) selectedToppings.add("Mushrooms")

//            val intent = Intent(this, SecondActivity::class.java).apply {
//                putExtra("UserName", userName)  // String
//                putExtra("PizzaCount", pizzaCount)  // Int
//                putExtra("PizzaType", selectedPizzaType)  // String
//                putStringArrayListExtra("Toppings", ArrayList(selectedToppings))  // ArrayList<String>
//            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("UserName", userName)
            intent.putExtra("PizzaCount", pizzaCount)
            intent.putExtra("PizzaType", selectedPizzaType)
            intent.putStringArrayListExtra("Toppings", ArrayList(selectedToppings))
            startActivity(intent)
        }
    }
}
