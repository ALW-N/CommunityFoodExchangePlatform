import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.communityfoodexchangeplatform.FoodFragment
import com.example.communityfoodexchangeplatform.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Find the button by its ID
        val foodButton = view.findViewById<Button>(R.id.foodButton)

        // Set click listener for the button
        foodButton.setOnClickListener {
            // Navigate to FoodFragment
            navigateToFoodFragment()
        }

        return view
    }

    private fun navigateToFoodFragment() {
        // Instantiate the FoodFragment
        val foodFragment = FoodFragment()

        // Get the FragmentManager
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        // Begin a FragmentTransaction
        val transaction = fragmentManager.beginTransaction()

        // Replace the fragment_container with the FoodFragment
        transaction.replace(R.id.fragment_container, foodFragment)

        // Add the transaction to the back stack
        transaction.addToBackStack(null)

        // Commit the transaction
        transaction.commit()
    }
}
