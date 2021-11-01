package com.tutorialjetpackcompose.ui.model

import androidx.annotation.DrawableRes

data class people(
    val name: String,
    val lastActivity: String,
    @DrawableRes val iconId:Int,
    @DrawableRes val postId:Int
)
