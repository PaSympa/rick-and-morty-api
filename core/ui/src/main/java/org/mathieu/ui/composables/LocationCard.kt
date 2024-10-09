package org.mathieu.ui.composables

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.mathieu.domain.models.location.LocationPreview

@Composable
fun LocationCard(
    location: LocationPreview,
    onClick: () -> Unit // action to perform when the card is clicked
) {

    val context = LocalContext.current

    // Card that displays the location information
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                // Vibrates the device when the card is clicked
                vibrateDevice(context)

                onClick()
           },
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(
            modifier = Modifier.padding(PaddingValues(16.dp))
        ) {
            // Display the name of the location
            Text(
                text = location.name,
                fontWeight = FontWeight.Bold
            )

            // Display the type of the location
            Text(
                text = location.type,
                fontWeight = FontWeight.Light
            )
        }
    }
}

// Function to trigger device vibration
private fun vibrateDevice(context: Context) {
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    // Use different vibration effects depending on the API level
    val vibrationEffect = VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE)
    vibrator.vibrate(vibrationEffect)
}