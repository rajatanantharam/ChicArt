package io.chicago.art.viewstate

sealed class DefaultViewState<T> {

    class Loading<T> : DefaultViewState<T>()

    class Error<T> : DefaultViewState<T>()

    class Success<T>(val result: T) : DefaultViewState<T>()
}