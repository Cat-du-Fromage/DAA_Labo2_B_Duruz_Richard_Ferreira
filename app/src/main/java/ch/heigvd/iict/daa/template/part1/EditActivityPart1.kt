package ch.heigvd.iict.daa.template.part1
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import ch.heigvd.iict.daa.template.R

/**
 * Activité d'édition du nom d'utilisateur pour la partie 1 de l'application
 *
 * Fonctionnalités :
 * - Saisie et modification du nom d'utilisateur
 * - Validation et retour du résultat à l'activité parente
 * - Pré-remplissage du champ avec le nom d'utilisateur existant
 * @author Duruz Florian
 * @author Ferreira Silva Sven
 * @author Richard Aurélien
 */
class EditActivityPart1: BaseActivityPart1()
{
    private lateinit var usernameInput: EditText;
    private lateinit var saveBtn: Button;

    companion object
    {
        const val USERNAME_KEY = "@part1Edit/username";
    }

    /**
     * Initialisation de l'activité d'édition
     *
     * Entrée : savedInstanceState - Bundle pour la restauration d'état (non utilisé ici)
     * Sortie : Interface d'édition configurée avec le nom d'utilisateur actuel
     *
     * Comportement :
     * - Prépare le champ de saisie avec la valeur reçue de l'activité parente
     * - Configure le bouton de sauvegarde pour valider et fermer l'activité
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_part1);
        usernameInput = findViewById(R.id.edit_text_name);
        saveBtn = findViewById(R.id.button_save);
        usernameInput.setText(intent.getStringExtra(USERNAME_KEY));
        saveBtn.setOnClickListener { close(); }
    }

    /**
     * Ferme l'activité et retourne le résultat à l'activité parente
     *
     * Sortie :
     * - Intent contenant le nouveau nom d'utilisateur
     * - Code résultat RESULT_OK
     * - Activité terminée
     */
    private fun close()
    {
        val data = Intent();
        data.putExtra(USERNAME_KEY, getUsername());
        setResult(RESULT_OK, data);
        finish();
    }

    /**
     * Récupère et nettoie le nom d'utilisateur saisi
     *
     * Sortie : String - Le nom d'utilisateur nettoyé (sans espaces superflus)
     *
     * Traitement :
     * - Convertit le texte en String
     * - Supprime les espaces en début et fin de chaîne
     */
    private fun getUsername(): String
    {
        return usernameInput.text.toString().trim();
    }
}
