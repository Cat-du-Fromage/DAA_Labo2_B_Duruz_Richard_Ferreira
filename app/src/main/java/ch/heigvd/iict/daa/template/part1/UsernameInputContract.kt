package ch.heigvd.iict.daa.template.part1
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class UsernameInputContract : ActivityResultContract<String?, String?>()
{

    override fun createIntent(context: Context, input: String?): Intent
    {
        val intent = Intent(context, InputNameActivity::class.java);
        intent.putExtra(InputNameActivity.USERNAME_KEY, input);
        return intent;
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String?
    {
        if (resultCode != Activity.RESULT_OK)
        {
            return null;
        }

        return intent?.getStringExtra(InputNameActivity.USERNAME_KEY);
    }
}
