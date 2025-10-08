package ch.heigvd.iict.daa.template.part1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivityPart1 : AppCompatActivity()
{
    // gets the simple name of the actual activity instance
    private val tag: String get() = this::class.java.simpleName;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        Log.d(tag, "onCreate Invoked");
    }

    override fun onStart()
    {
        super.onStart();
        Log.d(tag, "onStart Invoked");
    }

    override fun onResume()
    {
        super.onResume();
        Log.d(tag, "onResume Invoked");
    }

    override fun onPause()
    {
        super.onPause();
        Log.d(tag, "onPause Invoked");
    }

    override fun onStop()
    {
        super.onStop();
        Log.d(tag, "onStop Invoked");
    }

    override fun onDestroy()
    {
        super.onDestroy();
        Log.d(tag, "onDestroy Invoked");
    }
}