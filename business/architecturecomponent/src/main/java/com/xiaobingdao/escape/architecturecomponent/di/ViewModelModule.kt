package com.xiaobingdao.escape.architecturecomponent.di

import com.xiaobingdao.escape.architecturecomponent.viewmodel.MvvmDemoV2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MvvmDemoV2ViewModel() }
}