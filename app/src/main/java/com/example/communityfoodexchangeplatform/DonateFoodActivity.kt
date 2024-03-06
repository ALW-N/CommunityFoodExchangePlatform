package com.example.communityfoodexchangeplatform

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.communityfoodexchangeplatform.R

class DonateFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate_food)

        val foodNameEditText = findViewById<EditText>(R.id.foodNameEditText)
        val categorySpinner = findViewById<Spinner>(R.id.categorySpinner)
        val descriptionEditText = findViewById<EditText>(R.id.descriptionEditText)
        val quantityEditText = findViewById<EditText>(R.id.quantityEditText)
        val expirationDatePicker = findViewById<DatePicker>(R.id.expirationDatePicker)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            if (validateForm(foodNameEditText, descriptionEditText, quantityEditText)) {
                val foodName = foodNameEditText.text.toString()
                val category = categorySpinner.selectedItem.toString()
                val description = descriptionEditText.text.toString()
                val quantity = quantityEditText.text.toString()

                val day = expirationDatePicker.dayOfMonth
                val month = expirationDatePicker.month + 1
                val year = expirationDatePicker.year
                val expirationDate = "$year-$month-$day"

                val intent = Intent(this, RequestFoodActivity::class.java).apply {
                    putExtra("category", category)
                    putExtra("foodName", foodName)
                    putExtra("description", description)
                    putExtra("quantity", quantity)
                    putExtra("expirationDate", expirationDate)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateForm(foodNameEditText: EditText, descriptionEditText: EditText, quantityEditText: EditText): Boolean {
        var isValid = true

        if (foodNameEditText.text.toString().trim().isEmpty()) {
            foodNameEditText.error = "Required."
            isValid = false
        }

        if (descriptionEditText.text.toString().trim().isEmpty()) {
            descriptionEditText.error = "Required."
            isValid = false
        }

        val quantity = quantityEditText.text.toString().trim()
        if (quantity.isEmpty()) {
            quantityEditText.error = "Required."
            isValid = false
        } else if (!quantity.matches("^\\d+(\\.\\d+)?$".toRegex())) {
            quantityEditText.error = "Please enter a valid quantity (in kg)."
            isValid = false
        }

        return isValid
    }
}
