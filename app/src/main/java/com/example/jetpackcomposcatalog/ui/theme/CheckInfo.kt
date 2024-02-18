package com.example.jetpackcomposcatalog.ui.theme

data class CheckInfo(
    val tittle: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
) {

}