package com.example.newspaper.presentation.homeScreen

import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newspaper.data.NewsRepository.NewsRepoImpl
import com.example.newspaper.data.dclass.distributor.Distributor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val newsRepoImpl: NewsRepoImpl) : ViewModel() {

    val distributro = MutableLiveData<Distributor>()

    fun getDistributors() = viewModelScope.launch {
        distributro.value = newsRepoImpl.getDistributor()
    }

}