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
package com.example.androiddevchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.androiddevchallenge.features.detail.DetailScreen
import com.example.androiddevchallenge.features.home.HomeScreen
import com.example.androiddevchallenge.features.viewmodels.PuppyListViewModel

@Composable
fun Navigator(viewModel: PuppyListViewModel, navController: NavHostController) {
    val puppies = viewModel.puppies.observeAsState(emptyList())
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(route = Routes.HOME) {
            HomeScreen(puppies = puppies.value, navController = navController)
        }
        composable(
            route = Routes.PUPPY_DETAIL_WITH_ARGS,
            arguments = listOf(navArgument(Routes.Args.ARG_PUPPY_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val position =
                backStackEntry.arguments?.getInt(Routes.Args.ARG_PUPPY_ID) ?: return@composable
            DetailScreen(puppy = puppies.value[position])
        }
    }
}
