package org.mathieu.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import org.mathieu.data.remote.responses.LocationPreviewResponse

internal class LocationPreviewApi(private val client: HttpClient) {

        /**
        * Fetches the details of a location with the given ID from the service.
        *
        * @param id The unique identifier of the location to retrieve.
        * @return The [LocationPreviewResponse] representing the details of the location.
        * @throws HttpException if the request fails or if the status code is not [HttpStatusCode.OK].
        */
        suspend fun getLocationPreview(id: Int): LocationPreviewResponse? = client
            .get("location/$id")
            .accept(HttpStatusCode.OK)
            .body()
}
