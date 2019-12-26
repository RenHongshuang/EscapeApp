package com.xiaobingdao.escape.ui

import com.xiaobingdao.escape.architecturecomponent.ui.viewmodel.MvvmDemoV2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MvvmDemoV2ViewModel() }
}