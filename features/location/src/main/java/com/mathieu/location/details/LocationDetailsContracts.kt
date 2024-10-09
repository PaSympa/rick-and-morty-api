package com.mathieu.location.details

import androidx.compose.runtime.Immutable
import org.mathieu.domain.models.location.Location

/**
 * Contracts defining the state, actions and events of the location details page.
 * These contracts are used by the ViewModel to manage the UI state and user interactions.
 */
interface LocationDetailsContracts {

    /**
     * Represents the state of the location details UI.
     * This state is used to display data in the UI and react to user actions.
     *
     * @param isLoading True if the data is loading, false otherwise.
     * @param location The location to display.
     * @param error An error message to display.
     * @see Action
     * @see Event
     */
    @Immutable
    data class State(
        val isLoading: Boolean = true,
        val location: Location? = null,
        val error: String? = null
    )

    /**
     * Actions representing user interactions.
     * These actions are used by the ViewModel to react to user actions.
     *
     * @see Event
     */
    sealed interface Action {
    }

    /**
     * Events are used to trigger asynchronous actions or changes in the UI.
     *
     * @see Action
     */
    sealed interface Event

}


