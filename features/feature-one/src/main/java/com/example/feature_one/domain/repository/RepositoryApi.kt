package com.example.feature_one.domain.repository

import com.example.feature_one.domain.models.ItemTest
import kotlinx.coroutines.flow.Flow

interface RepositoryApi {

    fun getText(): Flow<List<ItemTest>>
}