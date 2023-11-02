package com.ijk.android_mvvm_example.usecases

import com.ijk.android_mvvm_example.network.RemoteDataSource

abstract class BaseUseCase {

    protected val remoteDataSource = RemoteDataSource()
}