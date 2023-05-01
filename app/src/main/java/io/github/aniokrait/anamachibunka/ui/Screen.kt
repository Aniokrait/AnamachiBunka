package io.github.aniokrait.anamachibunka.ui

import androidx.annotation.StringRes
import io.github.aniokrait.anamachibunka.R

sealed class Screen (val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("home", R.string.home)
    object Account : Screen("account", R.string.account)
    object HeritageDetail: Screen("heritageDetail/{heritageId}", R.string.heritageDetail)
}