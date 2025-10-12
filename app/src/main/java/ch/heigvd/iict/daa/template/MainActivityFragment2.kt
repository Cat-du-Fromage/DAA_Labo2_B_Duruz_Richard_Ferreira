/*
MainActivityFragment2.kt
* This file models the activity regarding the part 3
Authors:
* Duruz Florian
* Ferreira Silva Sven
* Richard Aurélien
 */
package ch.heigvd.iict.daa.template

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

var STEPPER_KEY = "stepper"

// Activity class
class MainActivityFragment2 : AppCompatActivity() {

    // Will serve to keep track of the current step value
    private var step = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // depuis android 15 (sdk 35), le mode edge2edge doit être activé
        enableEdgeToEdge()

        // on spécifie le layout à afficher
        setContentView(R.layout.activity_main_fragment2)

        // comme edge2edge est activé, l'application doit garder un espace suffisant pour la barre système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // la barre d'action doit être définie dans le layout, on la lie à l'activité
        setSupportActionBar(findViewById(R.id.toolbar))


        // Get the buttons
        val backButton = findViewById<Button>(R.id.f_back)
        val closeButton = findViewById<Button>(R.id.f_close)
        val nextButton = findViewById<Button>(R.id.f_next)

        // Fetch step value directly, to prevent unwanted instantiation right after
        if (savedInstanceState != null) {
            step = savedInstanceState.getInt(STEPPER_KEY)
        }

        // Set the fragment, if step is 0 (prevents instantiating on rotation)
        if (step == 0) {
            supportFragmentManager.beginTransaction()
                .add(R.id.center, StepperFragment.newInstance(step))
                .addToBackStack(null)
                .commit()
        }

        // Define events
        // Back button
        backButton.setOnClickListener {
            if (step == 0) {
                this.finish()
            } else {
                supportFragmentManager.popBackStack()
                --step
            }
        }

        // Close button
        closeButton.setOnClickListener {
            this.finish()
        }

        // Next button
        nextButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.center, StepperFragment.newInstance(++step))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save the stepper value
        outState.putInt(STEPPER_KEY, step)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Retrieve the stepper value. Technically counts as double definition, but defining this method for the sake of completeness
        step = savedInstanceState.getInt(STEPPER_KEY, 0)
    }
}