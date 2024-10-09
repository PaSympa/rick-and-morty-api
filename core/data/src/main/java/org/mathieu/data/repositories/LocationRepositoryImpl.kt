package org.mathieu.data.repositories

import org.mathieu.data.remote.LocationApi
import org.mathieu.data.remote.responses.toModel
import org.mathieu.domain.models.character.Character
import org.mathieu.domain.models.location.Location
import org.mathieu.domain.repositories.LocationRepository

internal class LocationRepositoryImpl (
    private val locationApi: LocationApi
) : LocationRepository{

    /**
     * Fetches the details of a specific location based on the provided ID.
     *
     * The function follows these steps:
     * 1. Fetch the location details from the API.
     * 2. Extract the list of resident URLs from the location response.
     * 3. For each resident URL, extract the resident ID and fetch the corresponding character details from the API.
     * 4. Map each resident's response to a domain model [Character].
     * 5. Map the locationResponse to the domain model [Location] adding with the list of residents.
     *
     * @param id The unique identifier of the location to be fetched.
     * @return Details of the specified location.
     */
    override suspend fun getLocation(id: Int): Location {
        val locationResponse = locationApi.getLocation(id) ?: throw Exception("Location not found")

        // Map the resident URLs to resident models
        val residents : List<Character> = locationResponse.residents.map { residentUrl ->
            val residentId = residentUrl.substringAfterLast("/").toInt()

            val residentResponse = locationApi.getResident(residentId) ?: throw Exception("Resident not found: $residentId")
            residentResponse.toModel()
        }

        // Map the location response to the domain model
        return locationResponse.toModel(residents)
    }

}