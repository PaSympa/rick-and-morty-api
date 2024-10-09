package org.mathieu.data.remote.responses

import kotlinx.serialization.Serializable
import org.mathieu.data.repositories.tryOrNull
import org.mathieu.domain.models.character.Character
import org.mathieu.domain.models.character.CharacterGender
import org.mathieu.domain.models.character.CharacterStatus

/**
 * Represents detailed information about a character, typically received from an API response.
 *
 * @property id The unique identifier for the character.
 * @property name The name of the character.
 * @property status The life status of the character - can be 'Alive', 'Dead', or 'unknown'.
 * @property species The species to which the character belongs.
 * @property type The specific subspecies or type of the character.
 * @property gender The gender of the character - can be 'Female', 'Male', 'Genderless', or 'unknown'.
 * @property origin Information about the character's origin, including name and link to the origin location.
 * @property location Information about the character's last known location, including name and link.
 * @property image A URL pointing to an image of the character. Typically 300x300px, suitable for use as an avatar.
 * @property episode A list of episodes in which the character has appeared.
 * @property url The unique URL endpoint specifically for this character.
 * @property locationPreview A preview of the location where the character is currently located.
 * @property created The timestamp indicating when the character was added to the database.
 */
@Serializable
internal data class CharacterResponse(
    val id:	Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterLocationResponse,
    val location: CharacterLocationResponse,
    val image: String,
    val episode: List<String>,
    val url: String,
    val locationPreview: LocationPreviewResponse? = null,
    val created: String
)

@Serializable
internal data class CharacterLocationResponse(val name: String, val url: String)

/**
 * Converts the [CharacterResponse] object to a [Character] model object.
 *
 * @return The [Character] model object representing the character.
 */
internal fun CharacterResponse.toModel() : Character = Character(
    id = id,
    name = name,
    status = when (status) {
        "Alive" -> CharacterStatus.Alive
        "Dead" -> CharacterStatus.Dead
        else -> CharacterStatus.Unknown
    },
    species = species,
    type = type,
    gender = when (gender) {
        "Female" -> CharacterGender.Female
        "Male" -> CharacterGender.Male
        "Genderless" -> CharacterGender.Genderless
        else -> CharacterGender.Unknown
    },
    origin = Pair(origin.name, tryOrNull { origin.url.split("/").last().toInt() } ?: -1),
    location = Pair(location.name, tryOrNull { location.url.split("/").last().toInt() } ?: -1),
    locationPreview = locationPreview?.toModel(),
    avatarUrl = image
)