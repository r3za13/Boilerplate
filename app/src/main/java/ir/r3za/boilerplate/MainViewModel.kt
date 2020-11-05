package ir.r3za.boilerplate

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import ir.r3za.ApiResponse
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
            val result = repository.getUsers("1")
            if (result is ApiResponse.Success) {
                Log.d("taggg", result.data.toString())
                _testStringLiveData.value = result.data!!.string()
            } else if (result is ApiResponse.Error) {
                Log.d("taggg", result.error.message!!)
                _testStringLiveData.value = result.error.message
            }
        }
    }
}