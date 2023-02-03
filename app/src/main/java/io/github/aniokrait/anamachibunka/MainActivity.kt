package io.github.aniokrait.anamachibunka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import dagger.hilt.android.AndroidEntryPoint
import io.github.aniokrait.anamachibunka.logic.hilt.data.Heritage
import io.github.aniokrait.anamachibunka.logic.viewmodel.HeritageViewModel
import io.github.aniokrait.anamachibunka.ui.theme.AnamachiBunkaTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: HeritageViewModel = hiltViewModel()
            AnamachiBunkaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //SampleMap()
                    Column() {
                        Dbkakunin()
                        Button(onClick = {
                            val heritage = Heritage(id = 1, "テスト遺産")
                            viewModel.insertTestDate(heritage)
                        }) {
                            Text(text = "insert")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SampleMap(){
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = singapore),
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
}

@Composable
fun Dbkakunin() {
    val viewModel: HeritageViewModel = hiltViewModel()
    viewModel.getHeritages()

    Column() {
        val heritage = viewModel.uiState.collectAsState().value.heritages
        if(heritage.isNotEmpty()) {
            Text(text = heritage[0].name)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun previewSampleMap() {
    SampleMap()
}