package com.fighter.donutsapp.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.navigation.DonutDetailArgs
import com.fighter.donutsapp.ui.screens.home.HomeUiState
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

    private fun getDonutDetails(donutId: Int) {
        when(donutId){
            0 -> _state.update {
                it.copy(
                    image = R.drawable.offer_one,
                    name = "Strawberry Wheel",
                    description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                    price = "$16"
                )
            }
            1 -> _state.update {
                it.copy(
                    image = R.drawable.offer_two,
                    name = "Chocolate Glaze",
                    description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                    price = "$18"
                )
            }
            2 -> _state.update {
                it.copy(
                    image = R.drawable.offer_one,
                    name = "Craze Donut",
                    description = "The Red Velvet donut is a visually stunning treat with its vibrant red hue and a rich cocoa flavor. It's often topped with a cream cheese frosting, adding a tangy and creamy element to the sweet donut.",
                    price = "$25"
                )
            }
            3 -> _state.update {
                it.copy(
                    image = R.drawable.donut_1,
                    name = "Chocolate Cherry",
                    description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                    price = "$16"
                )
            }
            4 -> _state.update {
                it.copy(
                    image = R.drawable.donut_2,
                    name = "Chocolate Glaze",
                    description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                    price = "$18"
                )
            }
            5 -> _state.update {
                it.copy(
                    image = R.drawable.donut_3,
                    name = "Craze Donut",
                    description = "The Red Velvet donut is a visually stunning treat with its vibrant red hue and a rich cocoa flavor. It's often topped with a cream cheese frosting, adding a tangy and creamy element to the sweet donut.",
                    price = "$25"
                )
            }
            else -> _state.update {
                it.copy(
                    image = R.drawable.donut_1,
                    name = "Chocolate Cherry",
                    description = "The Red Velvet donut is a visually stunning treat with its vibrant red hue and a rich cocoa flavor. It's often topped with a cream cheese frosting, adding a tangy and creamy element to the sweet donut.",
                    price = "$25"
                )
            }
        }
    }

}