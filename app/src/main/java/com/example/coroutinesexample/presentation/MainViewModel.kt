package com.example.coroutinesexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinesexample.domain.usecase.GetUserMessageUseCase
import com.example.coroutinesexample.presentation.model.MainState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(private val getUserMessageUseCase: GetUserMessageUseCase) : ViewModel() {

    private val _state = MutableSharedFlow<MainState>()
    val state: SharedFlow<MainState> = _state

    fun onExecuteAction() {
        viewModelScope.launch(Dispatchers.IO) {

             getUserMessageUseCase()
                 .onSuccess {
                     _state.emit(MainState(message = it))
                 }.onFailure {
                     _state.emit(MainState(message = "Error"))
                 }
        }
    }

    fun bla(){
        viewModelScope.launch {
            _state.emit(MainState(message = "boooo"))
        }
    }

}
