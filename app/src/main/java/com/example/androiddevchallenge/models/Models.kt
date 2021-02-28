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
package com.example.androiddevchallenge.models

import androidx.annotation.DrawableRes

data class Puppy(
    val id: Int,
    @DrawableRes val imageResource: Int,
    val name: String,
    val gender: Gender,
    val location: String,
    val origin: String,
    val age: String,
    val height: String? = null,
    val weight: String? = null,
    val owner: Owner,
    val details: PetDetails? = null
)

data class PetDetails(
    val summary: String
)

data class Owner(
    val id: Int,
    @DrawableRes val imageResource: Int,
    val fullName: String,
    val location: String,
    val phoneNumber: String? = null
)

enum class Gender(val value: String) {
    MALE("Male"), FEMALE("Female")
}
