package com.mathieu.location.details

import android.app.Application
import com.mathieu.location.details.LocationDetailsContracts.State
import org.koin.core.component.inject
import org.mathieu.domain.repositories.LocationRepository
import org.mathieu.ui.ViewModel

/**
 * ViewModel for the location details screen
 *
 * @param application the application context
 *
 * @see ViewModel
 * @see State
 */
class LocationDetailViewModel (application: Application) : ViewModel<State>(State(), application)
{
    // Inject the location repository
    private val locationRepository: LocationRepository by inject()

    /**
     * Initialize the ViewModel with the location id
     *
     * @param locationId the id of the location to display
     */
    fun init (locationId: Int)
    {
        fetchData(
            source = { locationRepository.getLocation(locationId) }
        ) {
            onSuccess { location ->
                updateState {
                    copy(
                        isLoading = false,
                        location = location,
                        error = null
                    )
                }
            }

            onFailure {
                updateState { copy(error = it.toString()) }
            }

            updateState { copy(isLoading = false) }
        }
    }
}
