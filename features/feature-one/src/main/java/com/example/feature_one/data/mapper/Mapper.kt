package com.example.feature_one.data.mapper

import com.example.feature_one.data.models.ItemDto
import com.example.feature_one.domain.models.ItemTest

fun ItemDto.mapToItemTest(): ItemTest = ItemTest(text = this.text)
