package com.example.feature_one.data.repository

import com.example.feature_one.data.mapper.mapToItemTest
import com.example.feature_one.data.models.ItemDto
import com.example.feature_one.domain.models.ItemTest
import com.example.feature_one.domain.repository.RepositoryApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiImpl : RepositoryApi {
    override fun getText(): Flow<List<ItemTest>> {
        return flow {
            val listEmmit = arrayListOf<ItemTest>()
            (0..10).forEach {
                listEmmit.add(ItemDto(text = "Item $it").mapToItemTest())
            }
            delay(1500)
            emit(listEmmit)
        }
    }

}