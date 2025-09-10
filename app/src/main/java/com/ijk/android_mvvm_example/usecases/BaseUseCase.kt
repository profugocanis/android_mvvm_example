package com.ijk.android_mvvm_example.usecases

import com.ijk.android_mvvm_example.core.network.RemoteDataSource

abstract class BaseUseCase {

    protected val remoteDataSource = RemoteDataSource()
}