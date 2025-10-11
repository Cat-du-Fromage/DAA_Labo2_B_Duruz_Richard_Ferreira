package ch.heigvd.iict.daa.template.part1
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import ch.heigvd.iict.daa.template.R

/**
 * Activity 1 : Welcome Section that welcome the user with the username saved
 * @author Duruz Florian
 * @author Ferreira Silva Sven
 * @author Richard Aurélien
 */

class InputNameActivity: BaseActivityPart1()
{

    private lateinit var usernameInput: EditText;
    private lateinit var saveButton: Button;

    companion object
    {
        const val USERNAME_KEY = "@part1Edit/username";
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_part1);
        usernameInput = findViewById(R.id.edit_text_name);
        saveButton = findViewById(R.id.button_save);
        usernameInput.setText(intent.getStringExtra(USERNAME_KEY));
        saveButton.setOnClickListener { close(); }
    }

    /**
     * Close the activity and return the username to the previous activity
     */
    private fun close()
    {
        val data = Intent();
        data.putExtra(USERNAME_KEY, getUsername());
        setResult(RESULT_OK, data);
        finish();
    }

    private fun getUsername(): String
    {
        return usernameInput.text.toString().trim();
    }

}
