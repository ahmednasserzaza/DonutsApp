package com.fighter.donutsapp.ui.screens.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.navigation.DonutDetailArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

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

    fun updatePrice(counter: Int) {
        val price = state.value.price.toInt()
        _state.update {
            it.copy(price = (counter * price).toString())
        }
    }


    private fun getDonutDetails(donutId: String) {
        when (donutId) {
            "Chocolate Cherry" -> _state.update {
                it.copy(
                    image = R.drawable.donut_1,
                    name = "Chocolate Cherry",
                    description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                    price = "16"
                )
            }

            "Strawberry Rain" -> _state.update {
                it.copy(
                    image = R.drawable.donut_2,
                    name = "Strawberry Rain",
                    description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                    price = "18"
                )
            }

            "Strawberry donut" -> _state.update {
                it.copy(
                    image = R.drawable.donut_3,
                    name = "Strawberry donut",
                    description = "The Red Velvet donut is a visually stunning treat with its vibrant red hue and a rich cocoa flavor.",
                    price = "25"
                )
            }

            "Strawberry Wheel" -> _state.update {
                it.copy(
                    image = R.drawable.offer_one,
                    name = "Strawberry Wheel",
                    description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                    price = "16"
                )
            }

            "Chocolate Glaze" -> _state.update {
                it.copy(
                    image = R.drawable.offer_two,
                    name = "Chocolate Glaze",
                    description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                    price = "18"
                )
            }

            "Craze Donut" -> _state.update {
                it.copy(
                    image = R.drawable.d4,
                    name = "Craze Donut",
                    description = "The Red Velvet donut is a visually stunning treat with its vibrant red hue and a rich cocoa flavor. It's often topped with a cream cheese frosting.",
                    price = "25"
                )
            }
            "Raspberry Filled" -> _state.update {
                it.copy(
                    image = R.drawable.d5,
                    name = "Raspberry Filled",
                    description = "Donuts filled with tangy raspberry preserves, balancing sweetness with a zesty twist.",
                    price = "25"
                )
            }

            else -> _state.update {
                it.copy(
                    image = R.drawable.d8,
                    name = "Chocolate Cherry",
                    description = "The Red Velvet donut is a visually stunning treat with its vibrant red hue and a rich cocoa flavor. It's often topped with a cream cheese frosting.",
                    price = "25"
                )
            }
        }
    }

}