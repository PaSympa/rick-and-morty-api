package org.mathieu.characters.details

import android.app.Application
import org.koin.core.component.inject
import org.mathieu.domain.repositories.CharacterRepository
import org.mathieu.characters.details.CharacterDetailsContracts.State
import org.mathieu.characters.details.CharacterDetailsContracts.Action
import org.mathieu.ui.Destination
import org.mathieu.ui.ViewModel


class CharacterDetailsViewModel(application: Application) : ViewModel<State>(State(), application) {

    private val characterRepository: CharacterRepository by inject()

    fun init(characterId: Int) {
        fetchData(
            source = { characterRepository.getCharacter(id = characterId) }
        ) {

            onSuccess {
                updateState { copy(avatarUrl = it.avatarUrl, name = it.name, locationPreview =  it.locationPreview, error = null) }
            }

            onFailure {
                updateState { copy(error = it.toString()) }
            }

            updateState { copy(isLoading = false) }
        }
    }

    /**
     * Handle user actions to update the UI state.
     * Each action represents a user interaction like entering name or description.
     *
     * @param action The action to handle to update the UI state.
     *
     * @see Action
     */
    fun handleAction(action: Action) {
        when (action){
            is Action.SelectedLocation -> {
                sendEvent(
                    Destination.LocationDetails(locationId = action.locationId.toString())
                )
            }
        }
    }
}