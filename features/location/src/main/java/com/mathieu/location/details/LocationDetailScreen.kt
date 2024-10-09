package com.mathieu.location.details

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.mathieu.domain.models.location.Location
import org.mathieu.ui.composables.CharacterCard

private typealias UIState = LocationDetailsContracts.State

/**
 * Composable function to display the location details screen
 *
 * @param navController The navigation controller
 * @param id The id of the location to display
 */
@Composable
fun LocationDetailsScreen(
    navController: NavController,
    id: Int
) {
    val viewModel: LocationDetailViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    // Initialize the ViewModel with the location id
    viewModel.init(locationId = id)

    // Display the location details content
    LocationDetailsContent(
        state = state,
        onClickBack = navController::popBackStack
    )
}

/**
 * Composable function to display the location details content
 *
 * @param state The state of the location details screen
 * @param onClickBack The action to perform when the back button is clicked
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
fun LocationDetailsContent(
    state: UIState = UIState(),
    onClickBack: () -> Unit
) = Scaffold(topBar = {

    Row(
        modifier = Modifier
            .background(org.mathieu.ui.theme.Purple40)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(16.dp)
                .clickable(onClick = onClickBack),
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            colorFilter = ColorFilter.tint(Color.White)
        )

        Text(
            text = state.location?.name ?: "",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}) { paddingValues ->
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues), contentAlignment = Alignment.Center) {

        AnimatedContent(targetState = state.isLoading || state.error != null, label = "") {
            when {
                state.isLoading -> {
                    // Display a loading indicator
                    CircularProgressIndicator()
                }
                state.error != null -> {

                    // Display an error message
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = state.error,
                        textAlign = TextAlign.Center,
                        color = Color.Red,
                        fontSize = 20.sp
                    )
                }
                state.location != null -> {
                    LocationDetails(location = state.location)
                }
            }
        }
    }
}

/**
 * Composable function to display the location details
 *
 * @param location The location to display
 */
@Composable
fun LocationDetails(location: Location) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Display the location details
        Text(text = "Type: ${location.type}", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        // Display the location type
        Text(text = "Dimension: ${location.dimension}", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(16.dp))

        // Display the residents
        Text(text = "Residents", fontSize = 20.sp, fontWeight = FontWeight.Medium)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(location.residents) { resident ->
                CharacterCard(
                    modifier = Modifier
                        .padding(8.dp),
                    character = resident
                )
            }
        }
    }
}
