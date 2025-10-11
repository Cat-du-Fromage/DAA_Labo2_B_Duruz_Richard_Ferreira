package ch.heigvd.iict.daa.template

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_COUNTER = "param_counter"

class StepperFragment : Fragment() {

    private var stepper: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stepper = it.getInt(ARG_COUNTER)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // création de la vue à partir du xml
        return inflater.inflate(R.layout.fragment_stepper, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
            stepper = it.getInt(ARG_COUNTER, 0)
        }

        // linkage de la GUI
        val counterTv = view.findViewById<TextView>(R.id.f_counter)

        // initialisation de la vue
        counterTv.text = "$stepper"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_COUNTER, stepper)
    }

    companion object {
        @JvmStatic
        fun newInstance(counter: Int = 0) =
            StepperFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COUNTER, counter)
                }
            }
    }
}