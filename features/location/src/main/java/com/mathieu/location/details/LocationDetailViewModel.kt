package com.mathieu.location.details

import android.app.Application
import com.mathieu.location.details.LocationDetailsContracts.Action
import com.mathieu.location.details.LocationDetailsContracts.State
import org.koin.core.component.inject
import org.mathieu.domain.repositories.LocationRepository
import org.mathieu.ui.ViewModel

class LocationDetailViewModel (application: Application) : ViewModel<State>(State(), application)
{
    private val locationRepository: LocationRepository by inject()

    /**
     * Gère les actions de l'utilisateur pour mettre à jour l'état de l'UI.
     * Chaque action représente une interaction utilisateur comme la saisie du nom ou de la description.
     *
     * @param action L'action à traiter pour mettre à jour l'état de l'UI.
     *
     * @see Action
     */
    fun handleAction(action: Action) {

    }
}
