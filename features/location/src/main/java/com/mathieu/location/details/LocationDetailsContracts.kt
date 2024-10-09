package com.mathieu.location.details

import androidx.compose.runtime.Immutable
import org.mathieu.domain.models.location.Location

/**
 * Contrats définissant l'état, les actions et les événements de la page de détails de localisation.
 * Ces contrats sont utilisés par le ViewModel pour gérer l'état de l'UI et les interactions utilisateur.
 */
interface LocationDetailsContracts {

    /**
     * Etat de l'UI de la page de détails de localisation.
     * Cet état est utilisé pour afficher les données dans l'UI et réagir aux actions de l'utilisateur.
     * @param location La localisation à afficher.
     * @param error Message d'erreur à afficher.
     * @see Action
     * @see Event
     */
    @Immutable
    data class State(
        val location: Location? = null,
        val error: String? = null
    )

    /**
     * Actions représentant les interactions utilisateur.
     * Ces actions sont utilisées par le ViewModel pour réagir aux agissements de l'utilisateur.
     *
     * @see Event
     */
    sealed interface Action {
    }

    /**
     * Les événements sont utilisés pour déclencher des actions asynchrones ou des changements dans l'UI.
     *
     * @see Action
     */
    sealed interface Event

}


