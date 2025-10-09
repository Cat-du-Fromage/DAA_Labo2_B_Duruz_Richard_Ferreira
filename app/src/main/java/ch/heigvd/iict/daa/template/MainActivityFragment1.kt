package ch.heigvd.iict.daa.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.iict.daa.template.fragments.ColorFragment
import ch.heigvd.iict.daa.template.fragments.CounterFragment


class MainActivityFragment1 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment1)

        supportFragmentManager.beginTransaction()
            .replace(R.id.top, CounterFragment())
            .replace(R.id.bottom, ColorFragment())
            .commit()

        // Mise en place de la toolbar
        //setSupportActionBar(binding.topAppBar)
    }


}