package ch.heigvd.iict.daa.template.part1

import android.widget.Button
import android.widget.TextView
import android.os.Bundle
import ch.heigvd.iict.daa.template.R

/**
 * Activité principale de la partie 1 de l'application
 * Fonctionnalités :
 * - Affichage d'un message de bienvenue personnalisé ou anonyme
 * - Gestion de l'édition du nom d'utilisateur via une autre activité
 * - Sauvegarde et restauration de l'état lors des changements de configuration
 *
 * @author Duruz Florian
 * @author Ferreira Silva Sven
 * @author Richard Aurélien
 */
class MainActivityPart1 : BaseActivityPart1()
{
    private lateinit var welcomeLabel: TextView;
    private lateinit var editBtn: Button;

    private var username: String? = null;

    companion object
    {
        const val STATE_KEY_USERNAME = "@part1Welcome/username";
    }

    /**
     * Contrat pour lancer l'activité d'édition et récupérer le résultat
     *
     * Sortie : Met à jour le nom d'utilisateur avec la valeur retournée
     */
    private val editActivityIntent = registerForActivityResult(UsernameEditContract())
    {
        username = it;
        updateUsername();
    }

    /**
     * Initialisation de l'activité
     *
     * Entrée : savedInstanceState - Bundle contenant l'état précédemment sauvegardé
     * Sortie : Interface utilisateur initialisée avec les données sauvegardées ou par défaut
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_part1);
        welcomeLabel = findViewById(R.id.text_view_welcome_message);
        editBtn = findViewById(R.id.button_edit_name);
        username = savedInstanceState?.getString(STATE_KEY_USERNAME);
        updateUsername();
        editBtn.setOnClickListener { editActivityIntent.launch(username); }
    }

    /**
     * Sauvegarde de l'état de l'activité avant sa destruction
     *
     * Entrée : outState - Bundle dans lequel sauvegarder l'état
     * Sortie : Bundle contenant le nom d'utilisateur sauvegardé
     */
    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_KEY_USERNAME, username);
    }

    /**
     * Restauration de l'état de l'activité après sa recréation
     *
     * Entrée : savedInstanceState - Bundle contenant l'état précédemment sauvegardé
     * Sortie : Nom d'utilisateur restauré et interface mise à jour
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle)
    {
        super.onRestoreInstanceState(savedInstanceState);
        username = savedInstanceState.getString(STATE_KEY_USERNAME);
        updateUsername();
    }

    /**
     * Met à jour le texte de bienvenue en fonction du nom d'utilisateur
     *
     * Sortie : TextView welcomeLabel mis à jour avec le message approprié
     *
     * Comportement :
     * - Affiche un message anonyme si le nom est null ou vide
     * - Affiche un message personnalisé avec le nom d'utilisateur sinon
     */
    private fun updateUsername()
    {
        welcomeLabel.text = when (username)
        {
            null -> getString(R.string.welcome_anonymous_message_part1);
            "" -> getString(R.string.welcome_anonymous_message_part1);
            else -> getString(R.string.welcome_message_part1, username);
        }
    }
}