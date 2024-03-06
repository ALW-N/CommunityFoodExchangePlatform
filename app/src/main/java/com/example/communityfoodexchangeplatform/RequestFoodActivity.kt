package com.example.communityfoodexchangeplatform

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RequestFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_food)

        val categoryTextView = findViewById<TextView>(R.id.categoryTextView)
        val foodNameTextView = findViewById<TextView>(R.id.foodNameTextView)
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
        val quantityTextView = findViewById<TextView>(R.id.quantityTextView)
        val expirationDateTextView = findViewById<TextView>(R.id.expirationDateTextView)

        val category = intent.getStringExtra("category")
        val foodName = intent.getStringExtra("foodName")
        val description = intent.getStringExtra("description")
        val quantity = intent.getStringExtra("quantity")
        val expirationDate = intent.getStringExtra("expirationDate")

        categoryTextView.text = "Category: $category"
        foodNameTextView.text = "Food Name: $foodName"
        descriptionTextView.text = "Description: $description"
        quantityTextView.text = "Quantity: $quantity"
        expirationDateTextView.text = "Expiration Date: $expirationDate"
    }
}
