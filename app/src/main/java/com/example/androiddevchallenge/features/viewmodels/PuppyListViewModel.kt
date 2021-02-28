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
package com.example.androiddevchallenge.features.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.features.utils.io
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.providers.PuppiesProvider
import kotlinx.coroutines.launch

class PuppyListViewModel : ViewModel() {

    private val _state = MutableLiveData<List<Puppy>>(emptyList())
    val puppies: LiveData<List<Puppy>> get() = _state

    fun getPuppies() {
        viewModelScope.launch {
            io {
                val puppies = PuppiesProvider.getPuppies()
                Log.d("Puppies", puppies.toString())
                _state.postValue(puppies)
            }
        }
    }
}
