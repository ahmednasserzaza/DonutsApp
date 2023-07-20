package com.fighter.donutsapp.ui.screens.home

import androidx.lifecycle.ViewModel
import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.data.FakeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()


    init {
        getDonuts()
        getDonutOffers()
    }

    private fun getDonuts() {
        _state.update { it.copy(donuts = FakeData.getRandomOfferDonuts()) }
    }

    private fun getDonutOffers() {
        return _state.update { it.copy(donuts = FakeData.getRandomDonuts()) }
    }
}