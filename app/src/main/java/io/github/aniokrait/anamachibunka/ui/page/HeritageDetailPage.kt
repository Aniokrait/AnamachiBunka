package io.github.aniokrait.anamachibunka.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import io.github.aniokrait.anamachibunka.logic.dataclass.HeritageUiModel
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HeritageDetailPage(
    heritageId: String?,
    getHeritageInfo: (Int) -> Unit,
    heritageInfoState: StateFlow<HeritageUiModel>
) {
    LaunchedEffect(heritageId) {
        getHeritageInfo(heritageId!!.toInt())
    }
    Column {
        val heritageInfo = heritageInfoState.collectAsState().value
        Text(text = "名称: ${heritageInfo.name}")
        Text(text = "緯度: ${heritageInfo.latitude}")
        Text(text = "経度: ${heritageInfo.longitude}")
    }
}