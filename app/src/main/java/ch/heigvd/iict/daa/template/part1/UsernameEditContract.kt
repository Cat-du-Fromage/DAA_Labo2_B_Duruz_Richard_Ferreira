package ch.heigvd.iict.daa.template.part1
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

/**
 * Contrat pour la gestion du résultat de l'activité d'édition du nom d'utilisateur
 *
 * Fonctionnalités :
 * - Définit le format des données d'entrée et de sortie pour l'activité d'édition
 * - Gère la création de l'Intent pour lancer l'activité d'édition
 * - Traite le résultat retourné par l'activité d'édition
 * @author Duruz Florian
 * @author Ferreira Silva Sven
 * @author Richard Aurélien
 */
class UsernameEditContract : ActivityResultContract<String?, String?>()
{
    /**
     * Crée l'Intent pour lancer l'activité d'édition du nom d'utilisateur
     *
     * Entrées :
     * - context : Contexte Android pour créer l'Intent
     * - input : String? - Le nom d'utilisateur actuel à pré-remplir dans l'activité d'édition
     * Sortie : Intent - Intent configuré pour lancer EditActivityPart1 avec les données d'entrée
     */
    override fun createIntent(context: Context, input: String?): Intent
    {
        val intent = Intent(context, EditActivityPart1::class.java);
        intent.putExtra(EditActivityPart1.USERNAME_KEY, input);
        return intent;
    }

    /**
     * Analyse et extrait le résultat retourné par l'activité d'édition
     *
     * Entrées :
     * - resultCode : Int - Code résultat de l'activité (RESULT_OK, RESULT_CANCELED, etc.)
     * - intent : Intent? - Intent contenant les données retournées par l'activité d'édition
     * Sortie : String? - Le nouveau nom d'utilisateur si sauvegardé, null si annulé ou erreur
     */
    override fun parseResult(resultCode: Int, intent: Intent?): String?
    {
        if (resultCode != Activity.RESULT_OK) return null;
        return intent?.getStringExtra(EditActivityPart1.USERNAME_KEY);
    }
}
