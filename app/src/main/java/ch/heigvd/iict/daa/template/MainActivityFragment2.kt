package ch.heigvd.iict.daa.template

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivityFragment2 : AppCompatActivity() {
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

        var step = 0

        // Set the fragment
        supportFragmentManager.beginTransaction()
            .add(R.id.center, StepperFragment.newInstance(step))
            .addToBackStack(null)
            .commit()

        // Define events
        backButton.setOnClickListener {
            if (step == 0) {
                this.finish()
            } else {
                supportFragmentManager.popBackStack()
                --step
            }
        }

        closeButton.setOnClickListener {
            this.finish()
        }

        nextButton.setOnClickListener {
            // Hide the current fragment
            val fragment = supportFragmentManager.findFragmentById(R.id.center)
            if (fragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.center, StepperFragment.newInstance(++step))
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}