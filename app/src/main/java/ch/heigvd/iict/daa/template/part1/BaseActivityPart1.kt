package ch.heigvd.iict.daa.template.part1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivityPart1 : AppCompatActivity()
{
    // gets the simple name of the actual activity instance
    private val tag: String get() = this::class.java.simpleName;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d(tag, "onCreate Invoked");
        super.onCreate(savedInstanceState);
    }

    override fun onStart()
    {
        Log.d(tag, "onStart Invoked");
        super.onStart();
    }

    override fun onResume()
    {
        Log.d(tag, "onResume Invoked");
        super.onResume();
    }

    override fun onPause()
    {
        Log.d(tag, "onPause Invoked");
        super.onPause();
    }

    override fun onStop()
    {
        Log.d(tag, "onStop Invoked");
        super.onStop();
    }

    override fun onDestroy()
    {
        Log.d(tag, "onDestroy Invoked");
        super.onDestroy();
    }
}