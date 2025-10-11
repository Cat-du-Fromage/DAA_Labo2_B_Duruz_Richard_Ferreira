package ch.heigvd.iict.daa.template.part1

import android.widget.Button
import android.widget.TextView
import android.os.Bundle
import androidx.activity.viewModels
import ch.heigvd.iict.daa.template.R

class MainActivityPart1 : BaseActivityPart1()
{
    private lateinit var welcomeLabel: TextView;
    private lateinit var editButton: Button;

    private var username: String? = null;

    private val userViewModel: UserViewModel by viewModels()

    companion object
    {
        //const val STATE_KEY_USERNAME = "@welcome/username";
        const val STATE_KEY_USERNAME = "@part1Welcome/username";
    }

    private val editActivityIntent = registerForActivityResult(UsernameInputContract())
    {
        username = it;
        updateUsername();
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_part1);

        welcomeLabel = findViewById(R.id.text_view_welcome_message);
        editButton = findViewById(R.id.button_edit_name);

        username = savedInstanceState?.getString(STATE_KEY_USERNAME);
        updateUsername();
        //Use to edit name
        editButton.setOnClickListener { editActivityIntent.launch(username); }
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_KEY_USERNAME, username);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle)
    {
        super.onRestoreInstanceState(savedInstanceState);
        username = savedInstanceState.getString(STATE_KEY_USERNAME);
        updateUsername();
    }

    private fun updateUsername()
    {
        welcomeLabel.text = when (username)
        {
            null -> getString(R.string.welcome_anonymous_message_part1);
            else -> getString(R.string.welcome_message_part1, username);
        }
    }

}