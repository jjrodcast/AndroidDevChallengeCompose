/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.providers

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Gender
import com.example.androiddevchallenge.models.Owner
import com.example.androiddevchallenge.models.PetDetails
import com.example.androiddevchallenge.models.Puppy

object PuppiesProvider {

    fun getPuppies() = listOf(
        Puppy(
            id = 1, imageResource = R.drawable.puppy_1, name = "Bobby", gender = Gender.MALE, location = "Lima",
            origin = "Lima", age = "8 months", height = "20 cm", weight = "9 Kg",
            owner = getOwners()[0], details = PetDetails(getRandomDescription("Bobby"))
        ),
        Puppy(
            id = 2, imageResource = R.drawable.puppy_2, name = "Bella", gender = Gender.FEMALE, location = "Trujillo",
            origin = "Lima", age = "7 months", height = "17 cm", weight = "8 Kg",
            owner = getOwners()[1], details = PetDetails(getRandomDescription("Bella"))
        ),
        Puppy(
            id = 3, imageResource = R.drawable.puppy_3, name = "Brady", gender = Gender.MALE, location = "Lima",
            origin = "Ica", age = "10 months", height = "25 cm", weight = "10 Kg",
            owner = getOwners()[2], details = PetDetails(getRandomDescription("Brady"))
        ),
        Puppy(
            id = 4, imageResource = R.drawable.puppy_4, name = "Buddy", gender = Gender.MALE, location = "Lima",
            origin = "Lima", age = "6 months", height = "20 cm", weight = "7 Kg",
            owner = getOwners()[3], details = PetDetails(getRandomDescription("Buddy"))
        ),
        Puppy(
            id = 5, imageResource = R.drawable.puppy_5, name = "Daisy", gender = Gender.FEMALE, location = "Piura",
            origin = "Piura", age = "8 months", height = "20 cm", weight = "9 Kg",
            owner = getOwners()[4], details = PetDetails(getRandomDescription("Daisy"))
        ),
        Puppy(
            id = 6, imageResource = R.drawable.puppy_6, name = "Dolly", gender = Gender.FEMALE, location = "Chiclayo",
            origin = "Lima", age = "7 months", height = "20 cm", weight = "7 Kg",
            owner = getOwners()[5], details = PetDetails(getRandomDescription("Dolly"))
        ),
        Puppy(
            id = 7, imageResource = R.drawable.puppy_7, name = "Eliot", gender = Gender.MALE, location = "Anchash",
            origin = "Anchash", age = "8 months", height = "20 cm", weight = "8 Kg",
            owner = getOwners()[6], details = PetDetails(getRandomDescription("Eliot"))
        ),
        Puppy(
            id = 8, imageResource = R.drawable.puppy_8, name = "Gia", gender = Gender.FEMALE, location = "Ica",
            origin = "Lima", age = "6 months", height = "20 cm", weight = "6 Kg",
            owner = getOwners()[7], details = PetDetails(getRandomDescription("Gia"))
        ),
        Puppy(
            id = 9, imageResource = R.drawable.puppy_9, name = "Loki", gender = Gender.MALE, location = "Lima",
            origin = "Lima", age = "8 months", height = "20 cm", weight = "9 Kg",
            owner = getOwners()[8], details = PetDetails(getRandomDescription("Loki"))
        ),
        Puppy(
            id = 10, imageResource = R.drawable.puppy_10, name = "Milo", gender = Gender.MALE, location = "Tumbes",
            origin = "Tumbes", age = "7 months", height = "20 cm", weight = "8 Kg",
            owner = getOwners()[9], details = PetDetails(getRandomDescription("Milo"))
        ),
        Puppy(
            id = 11, imageResource = R.drawable.puppy_11, name = "Yogi", gender = Gender.MALE, location = "Lima",
            origin = "Cusco", age = "10 months", height = "20 cm", weight = "11 Kg",
            owner = getOwners()[10], details = PetDetails(getRandomDescription("Yogi"))
        ),
    )

    private fun getOwners() = listOf(
        Owner(id = 1, imageResource = R.drawable.woman_photo, fullName = "Carol Martinez", location = "Lima", phoneNumber = "+5195231244"),
        Owner(id = 2, imageResource = R.drawable.men_photo, fullName = "José Binotto", location = "Trujillo", phoneNumber = "+5192309864"),
        Owner(id = 3, imageResource = R.drawable.men_2_photo, fullName = "Jorge Castro", location = "Lima", phoneNumber = "+5197653092"),
        Owner(id = 4, imageResource = R.drawable.woman_2_photo, fullName = "Maria Espinoza", location = "Lima", phoneNumber = "+5199110045"),
        Owner(id = 5, imageResource = R.drawable.woman_3_photo, fullName = "Mercedes Gutierrez", location = "Piura", phoneNumber = "+5190983931"),
        Owner(id = 6, imageResource = R.drawable.men_3_photo, fullName = "Carlos Ramirez", location = "Chiclayo", phoneNumber = "+51911020566"),
        Owner(id = 7, imageResource = R.drawable.men_4_photo, fullName = "Diego Castillo", location = "Anchash", phoneNumber = "+5195201144"),
        Owner(id = 8, imageResource = R.drawable.men_5_photo, fullName = "Felipe Sánchez", location = "Ica", phoneNumber = "+5195751214"),
        Owner(id = 9, imageResource = R.drawable.woman_4_photo, fullName = "Manuela Pino", location = "Lima", phoneNumber = "+5191807609"),
        Owner(id = 10, imageResource = R.drawable.men_6_photo, fullName = "Ernesto Chang", location = "Tumbes", phoneNumber = "+51944409811"),
        Owner(id = 11, imageResource = R.drawable.men_7_photo, fullName = "Felipe Izquierdo", location = "Lima", phoneNumber = "+51987609414"),
    )

    private fun getRandomDescription(name: String): String {
        return "$name is a super smart amazing dog with so much love to give. " +
            "$name  is well trained knows all commands sit, heal, go to your bed, " +
            "stay on your bed, go to your crate, paw she knows it all. $name  is " +
            "very protective and so loving g she needs a experienced owner who " +
            "keeps her in check and loves her."
    }
}
