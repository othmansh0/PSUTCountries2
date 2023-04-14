import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.psutcountriesapp.MainActivity
import com.example.psutcountriesapp.R

class CountryInfoDialogFragment : DialogFragment(R.layout.dialog_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val distanceRadioButton = view.findViewById<RadioButton>(R.id.distanceRadioButton)
        val currencyRadioButton = view.findViewById<RadioButton>(R.id.currencyRadioButton)
        val cancelButton = view.findViewById<Button>(R.id.cancel_button)
        val submitButton = view.findViewById<Button>(R.id.submit_button)

        cancelButton.setOnClickListener {
            dismiss()
        }

        submitButton.setOnClickListener {
            val selectedOption = view.findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)

            val countryName = arguments?.getString("country")
            val countryDistance = arguments?.getString("distance")
            val countryCurrency = arguments?.getString("currency")

            val m1: MainActivity = activity as MainActivity
//            m1.index

            val distanceText = "Distance from $countryName is $countryDistance km" // Example distance calculation
            val currencyText = "The currency of $countryName is $countryCurrency" // Example currency information

            val infoTextView = (activity as MainActivity).findViewById<TextView>(R.id.textView33)

            if (radioButton.id == distanceRadioButton.id) {
                // Display distance in infoTextView
                infoTextView.text = distanceText
            } else if (radioButton.id == currencyRadioButton.id) {
                // Display currency in infoTextView
                infoTextView.text = currencyText
            }


            dismiss()
        }
    }

    companion object {
        fun newInstance(country: String, distance: Int, currency:String): CountryInfoDialogFragment {
            val args = Bundle()
            args.putString("country", country)
            args.putString("distance", distance.toString())
            args.putString("currency",currency)
            val fragment = CountryInfoDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }
}