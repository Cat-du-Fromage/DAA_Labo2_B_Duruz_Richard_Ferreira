package ch.heigvd.iict.daa.template.part1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity 1 : Permet le Log des divers événements de AppCompatActivity
 * @author Duruz Florian
 * @author Ferreira Silva Sven
 * @author Richard Aurélien
 */
abstract class BaseActivityPart1 : AppCompatActivity()
{
    // gets the simple name of the actual activity instance
    private val originName: String get() = this::class.java.simpleName;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d(originName, "onCreate Invoked");
        super.onCreate(savedInstanceState);
    }

    override fun onStart()
    {
        Log.d(originName, "onStart Invoked");
        super.onStart();
    }

    override fun onResume()
    {
        Log.d(originName, "onResume Invoked");
        super.onResume();
    }

    override fun onPause()
    {
        Log.d(originName, "onPause Invoked");
        super.onPause();
    }

    override fun onStop()
    {
        Log.d(originName, "onStop Invoked");
        super.onStop();
    }

    override fun onDestroy()
    {
        Log.d(originName, "onDestroy Invoked");
        super.onDestroy();
    }
}