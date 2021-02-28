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
package com.example.androiddevchallenge.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FmdGood
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.navigation.Routes
import com.example.androiddevchallenge.providers.PuppiesProvider
import com.example.androiddevchallenge.ui.theme.backgroundColor
import com.example.androiddevchallenge.ui.theme.bannerColor
import com.example.androiddevchallenge.ui.theme.iconColor

@Composable
fun HomeScreen(puppies: List<Puppy>, navController: NavController) {
    Column(
        Modifier
            .background(backgroundColor)
            .fillMaxSize()
    ) {

        Header(modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.available_title),
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(16.dp))
        PuppyList(puppies, navController)
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row {
            Column(
                modifier = Modifier
                    .background(bannerColor)
                    .width(160.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(text = stringResource(id = R.string.banner_text), fontSize = 18.sp)
            }
            Column(
                modifier = Modifier
                    .background(bannerColor)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    painterResource(id = R.drawable.poster_5),
                    contentDescription = "",
                )
            }
        }
    }
}

@Composable
fun PuppyList(puppies: List<Puppy>, navController: NavController) {
    LazyColumn {
        items(count = puppies.size) { index ->
            PuppyItem(puppy = puppies[index]) {
                navController.navigate(route = "${Routes.PUPPY_DETAIL}/$index")
            }
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        elevation = 1.dp
    ) {
        Row(Modifier.clickable(onClick = onClick)) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .width(110.dp)
                    .height(110.dp)
            ) {
                Surface(shape = RoundedCornerShape(8.dp)) {
                    Image(
                        painterResource(id = puppy.imageResource),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = puppy.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        imageVector = Icons.Filled.FmdGood,
                        contentDescription = "",
                        tint = iconColor
                    )
                    Text(text = puppy.location, modifier = Modifier.padding(start = 4.dp))
                }
                Row(modifier = Modifier.padding(vertical = 2.dp)) {
                    Text(
                        stringResource(id = R.string.origin_text),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = puppy.origin)
                }
                Row(modifier = Modifier.padding(vertical = 2.dp)) {
                    Text(text = puppy.gender.value)
                    Text(text = puppy.age, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun HeaderPreview() {
    Header()
}

@Preview
@Composable
fun PetItemPreview() {
    val puppies = PuppiesProvider.getPuppies()
    PuppyList(puppies, rememberNavController())
}
