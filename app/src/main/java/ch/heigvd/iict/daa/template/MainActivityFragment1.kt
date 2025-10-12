/*
MainActivityFragment1.kt
* This file models the activity regarding the part 2
Authors:
* Duruz Florian
* Ferreira Silva Sven
* Richard Aurélien
 */
package ch.heigvd.iict.daa.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.iict.daa.template.fragments.ColorFragment
import ch.heigvd.iict.daa.template.fragments.CounterFragment


class MainActivityFragment1 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment1)

        setSupportActionBar(findViewById(R.id.toolbar))

// Manually set in the layout now
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.top, ColorFragment())
//                .replace(R.id.bottom, CounterFragment())
//                .commit()
//        }
    }


}