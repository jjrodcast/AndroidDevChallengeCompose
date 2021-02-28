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
package com.example.androiddevchallenge.features.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FmdGood
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Owner
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.ui.theme.backgroundColor
import com.example.androiddevchallenge.ui.theme.iconColor

@Composable
fun DetailScreen(puppy: Puppy) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState(0))
            .background(backgroundColor)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        PuppyCard(puppy = puppy)
        Spacer(modifier = Modifier.height(12.dp))
        OwnerCard(owner = puppy.owner)
        Spacer(modifier = Modifier.height(16.dp))
        puppy.details?.let {
            Text(
                text = stringResource(R.string.detail_text),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = it.summary,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Justify
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { }, modifier = Modifier.padding(8.dp)) {
                Text(
                    text = stringResource(R.string.adopt_puppy),
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy) {
    Surface(
        Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            PuppyPhoto(imageResource = puppy.imageResource)
            Spacer(modifier = Modifier.height(18.dp))
            PuppyInfo(puppy = puppy)
        }
    }
}

@Composable
fun PuppyPhoto(imageResource: Int) {
    Surface(
        modifier = Modifier
            .height(360.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
    }
}

@Composable
fun PuppyInfo(puppy: Puppy) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Text(text = puppy.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row {
                    Text(
                        text = stringResource(R.string.origin_text),
                        fontWeight = FontWeight.Light
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = puppy.origin, fontWeight = FontWeight.SemiBold)
                }
                Row {
                    Text(text = puppy.gender.value, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = puppy.age, fontWeight = FontWeight.SemiBold)
                }
            }
            Column {
                Row {
                    Text(
                        text = stringResource(R.string.height_text),
                        fontWeight = FontWeight.Light
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = puppy.height ?: "-", fontWeight = FontWeight.SemiBold)
                }
                Row {
                    Text(
                        text = stringResource(R.string.weight_text),
                        fontWeight = FontWeight.Light
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = puppy.weight ?: "-", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@Composable
fun OwnerCard(owner: Owner) {
    Surface(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            CircularAvatar(imageResource = owner.imageResource)
            Spacer(modifier = Modifier.width(8.dp))
            OwnerInfo(owner = owner)
            Spacer(modifier = Modifier.width(16.dp))
            OwnerInfoIcon(onClick = { })
        }
    }
}

@Composable
fun CircularAvatar(modifier: Modifier = Modifier, imageResource: Int) {
    Surface(
        modifier = modifier.size(64.dp),
        shape = CircleShape
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(imageResource),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun OwnerInfo(owner: Owner) {
    Column {
        Text(text = owner.fullName, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = stringResource(R.string.puppy_owner), fontSize = 14.sp)
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
            Text(text = owner.location, modifier = Modifier.padding(start = 4.dp))
        }
    }
}

@Composable
fun OwnerInfoIcon(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color(0xFF15D685), shape = RoundedCornerShape(6.dp))
            .clickable(onClick = onClick)
            .padding(6.dp)
            .size(18.dp)
    ) {
        Icon(imageVector = Icons.Filled.Phone, contentDescription = "", tint = Color.White)
    }
}
