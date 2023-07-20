package com.fighter.donutsapp.ui.data

import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.screens.details.DetailsUiState
import com.fighter.donutsapp.ui.screens.home.DonutUiState
import com.fighter.donutsapp.ui.screens.home.toDetailsUiState
import java.util.Random

object FakeData {

    private val donuts = listOf(
        DonutUiState(
            donutImage = R.drawable.offer_one,
            donutTitle = "Strawberry Wheel",
            description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
            donutPrice = "16",
        ),
        DonutUiState(
            donutImage = R.drawable.offer_two,
            donutTitle = "Chocolate Glaze",
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
            donutPrice = "18",
        ),
        DonutUiState(
            donutImage = R.drawable.d4,
            donutTitle = "Craze Donut",
            description = "Delicious and Juicy baked chocolate donuts full of Craze Tasty.",
            donutPrice = "25",
        ),
        DonutUiState(
            donutImage = R.drawable.d5,
            donutTitle = "Raspberry Filled",
            description = "Donuts filled with tangy raspberry preserves, balancing sweetness with a zesty twist.",
            donutPrice = "16",
        ),
        DonutUiState(
            donutImage = R.drawable.donut_1,
            donutTitle = "Chocolate Cherry",
            donutPrice = "18",
            description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
        ),
        DonutUiState(
            donutImage = R.drawable.donut_2,
            donutTitle = "Strawberry Rain",
            donutPrice = "22",
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
        ),
        DonutUiState(
            donutImage = R.drawable.donut_3,
            donutTitle = "Strawberry donut",
            donutPrice = "12",
            description = "The Red Velvet donut is a visually stunning treat with its vibrant red hue and a rich cocoa flavor.",
        ),
        DonutUiState(
            donutImage = R.drawable.d5,
            donutTitle = "Jelly-Filled",
            donutPrice = "7",
            description = "The Red Velvet donut is a visually stunning treat with its vibrant red hue and a rich cocoa flavor. It's often topped with a cream cheese frosting.",
        ),
        DonutUiState(
            donutImage = R.drawable.d6,
            donutTitle = "Boston Cream",
            donutPrice = "9",
            description = "Donuts filled with tangy raspberry preserves, balancing sweetness with a zesty twist.",
        ),
        DonutUiState(
            donutImage = R.drawable.d7,
            donutTitle = "Maple Bar",
            donutPrice = "15",
            description = "The Red Velvet donut is a visually stunning treat with its vibrant red hue and a rich cocoa flavor. It's often topped with a cream cheese frosting.",
        ),
        DonutUiState(
            donutImage = R.drawable.d8,
            donutTitle = "Old-Fashioned",
            donutPrice = "48",
            description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
        ),
        DonutUiState(
            donutImage = R.drawable.d10,
            donutTitle = "Powdered Sugar",
            donutPrice = "3",
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
        ),
    )

    fun getRandomOfferDonuts(): List<DonutUiState> {
        return donuts.shuffled().take(8)
    }
    fun getRandomDonuts(): List<DonutUiState> {
        val random = Random()
        val randomDonuts = mutableListOf<DonutUiState>()

        while (randomDonuts.size < 10) {
            val randomIndex = random.nextInt(donuts.size)
            val randomDonut = donuts[randomIndex]
            if (!randomDonuts.contains(randomDonut)) {
                randomDonuts.add(randomDonut)
            }
        }

        return randomDonuts
    }


    fun getDonutByName(donutName: String): DetailsUiState? {
        return donuts.find { it.donutTitle == donutName }?.toDetailsUiState()
    }


}