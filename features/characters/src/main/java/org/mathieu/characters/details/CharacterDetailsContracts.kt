package org.mathieu.characters.details

import androidx.compose.runtime.Immutable
import org.mathieu.domain.models.location.LocationPreview

interface CharacterDetailsContracts {

    /**
     * Represents the state of the character details UI.
     * This state is used to display data in the UI and react to user actions.
     *
     * @param isLoading True if the data is loading, false otherwise.
     * @param avatarUrl The URL of the character's avatar image.
     * @param name The name of the character.
     * @param locationPreview A preview of the character's location.
     * @param error An error message to display.
     * @see Action
     * @see Event
     */
    @Immutable
    data class State(
        val isLoading: Boolean = true,
        val avatarUrl: String = "",
        val name: String = "",
        val locationPreview: LocationPreview? = null,
        val error: String? = null
    )

    /**
     * Actions representing user interactions.
     * These actions are used by the ViewModel to react to user actions.
     *
     * @see Event
     */
    sealed interface Action {
        data class SelectedLocation(val locationId: Int) : Action
    }

    /**
     * Events are used to trigger asynchronous actions or changes in the UI.
     *
     * @see Action
     */
    sealed interface Event
}