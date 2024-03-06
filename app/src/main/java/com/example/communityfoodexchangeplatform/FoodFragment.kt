package com.example.communityfoodexchangeplatform

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class FoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food, container, false)

        // Find the donate and request buttons by their IDs
        val donateButton = view.findViewById<Button>(R.id.donateButton)
        val requestButton = view.findViewById<Button>(R.id.requestButton)

        // Set click listeners for the donate and request buttons
        donateButton.setOnClickListener {
            // Start DonateFoodActivity
            startActivity(Intent(requireContext(), DonateFoodActivity::class.java))
        }

        requestButton.setOnClickListener {
            // Start RequestFoodActivity
            startActivity(Intent(requireContext(), RequestFoodActivity::class.java))
        }

        return view
    }
}
