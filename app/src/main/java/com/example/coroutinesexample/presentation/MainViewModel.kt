package com.example.coroutinesexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinesexample.domain.repository.BreedsRepository
import com.example.coroutinesexample.presentation.model.MainState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val breedsRepository: BreedsRepository
) : ViewModel() {

    private val _state = MutableSharedFlow<MainState>()
    val state: SharedFlow<MainState> = _state

    fun onExecuteAction() {
        viewModelScope.launch(Dispatchers.IO) {
            breedsRepository.getBreeds()
        }
    }

    fun bla(){
        viewModelScope.launch {
            _state.emit(MainState(message = "boooo"))
        }
    }

}
