package ir.r3za.boilerplate

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import ir.r3za.Repository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: Repository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _testStringLiveData = MutableLiveData<String>()
    val testStringLiveData: LiveData<String>
        get() = _testStringLiveData

    init {
        _testStringLiveData.value = "Bella Ciao!"
    }

    fun onPageOpened() {
        viewModelScope.launch {
            repository.getUsers("1")
        }
    }
}