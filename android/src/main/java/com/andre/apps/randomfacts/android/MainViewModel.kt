package com.andre.apps.randomfacts.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andre.apps.randomfacts.common.model.Fact
import com.andre.apps.randomfacts.common.model.Result
import com.andre.apps.randomfacts.common.usecase.GetRandomFactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(private val getRandomFact: GetRandomFactUseCase) : ViewModel() {

    fun getIsLoading(): StateFlow<Boolean> = _state
        .map { it.status == Result.Status.LOADING }
        .distinctUntilChanged { old, new ->
            old == new
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, false)

    fun getText(): StateFlow<String> = _state
        .map { it.data?.text ?: "" }
        .distinctUntilChanged { old, new ->
            old == new
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, "")

    private val _state: MutableStateFlow<Result<Fact>> by lazy {
        val flow = MutableStateFlow<Result<Fact>>(Result.loading())
        viewModelScope.launch {
            getRandomFact.execute()
                .collect {
                    flow.value = it
                }
        }
        return@lazy flow
    }
}