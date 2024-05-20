package com.example.feature_one.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_one.domain.models.ItemTest
import com.example.feature_one.domain.repository.RepositoryApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ApiTest(repositoryApi: RepositoryApi) : ViewModel() {

    private val _data = MutableStateFlow<List<ItemTest>>(emptyList())
    val data: StateFlow<List<ItemTest>> get() = _data.asStateFlow()

    private val _state = MutableStateFlow(true)
    val state get() = _state.asStateFlow()


    init {
        viewModelScope.launch {
            repositoryApi.getText().onStart {
                _state.value = true
            }.collect {
                _state.value = false
                _data.value = it
            }
        }
    }

}