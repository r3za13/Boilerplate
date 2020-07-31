package ir.r3za.boilerplate

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel @ViewModelInject constructor() : ViewModel() {

    private val _testStringLiveData = MutableLiveData<String>()
    val testStringLiveData: LiveData<String>
        get() = _testStringLiveData

    init {
        _testStringLiveData.value = "Bella Ciao!"
    }
}