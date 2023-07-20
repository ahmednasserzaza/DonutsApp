package com.fighter.donutsapp.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fighter.donutsapp.ui.data.FakeData
import com.fighter.donutsapp.ui.navigation.DonutDetailArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle):ViewModel() {

    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()

    private val args = DonutDetailArgs(savedStateHandle)

    init {
        getDonutDetails(args.donutId)
    }

    fun increment() {
        _state.update {
            val updatedCounter = it.counter + 1
            it.copy(counter = updatedCounter)
        }
    }

    fun decrement() {
        _state.update {
            val updatedCounter = if (it.counter > 1) it.counter - 1 else 1
            it.copy(counter = updatedCounter)
        }
    }

    private fun getDonutDetails(donutName: String) {
        val donut = FakeData.getDonutByName(donutName).let { it!! }
        _state.update {
            it.copy(
                image = donut.image, price = donut.price, description = donut.description,
            )
        }
    }

}