package ch.heigvd.iict.daa.template.part1

import android.widget.Button
import android.widget.TextView
import android.os.Bundle
import ch.heigvd.iict.daa.template.R

class MainActivityPart1 : BaseActivityPart1()
{
    private lateinit var welcomeLabel: TextView;
    private lateinit var editButton: Button;

    private var username: String? = null;

    companion object
    {
        const val STATE_KEY_USERNAME = "@welcome/username";
    }
    /*
    private val editActivityIntent = registerForActivityResult(UsernameInputContract()) {
        username = it
        updateWelcomeLabel()
    }
    */
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_part1);

        welcomeLabel = findViewById(R.id.text_view_welcome_message);
        editButton = findViewById(R.id.button_edit_name);

        username = savedInstanceState?.getString(STATE_KEY_USERNAME);
        updateWelcomeLabel();
        //Use to edit name
        //editButton.setOnClickListener { editActivityIntent.launch(username) }
    }

    private fun updateWelcomeLabel()
    {
        welcomeLabel.text = when (username)
        {
            null -> getString(R.string.welcome_anonymous_message_part1);
            //TODO Change welcome_message_part1 to a version with input
            else -> getString(R.string.welcome_message_part1, username);
        }
    }

}