package com.andreisingeleytsev.playingquizapp.ui.utils

sealed class UIEvent{
    data object OnBack: UIEvent()
    data class OnNavigate(val route: String): UIEvent()
}
