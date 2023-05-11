package com.mobsky.navigation

abstract class Navigate

sealed class RootGraph : Navigate() {
    class Root(val rote: String = "rootGraph") : Navigate()
}

sealed class HomeGraph : Navigate() {
    class Root(val rote: String = "homeGraph") : Navigate()
    class Home(val rote: String = "home") : Navigate()
    class UserRepositories(
        val rote: String = "userRepositories",
        val routeParameters: String = "userRepositories\\{userName}",
        val parameterName: String = "userName"
    ) : Navigate()

    class UserProfile(
        val rote: String = "userProfile",
        val routeParameters: String = "userProfile\\{userName}",
        val parameterName: String = "userName",
        val parameterValue: String = ""
    ) : Navigate()

    class UserSearch(val rote: String = "userSearch") : Navigate()
}

fun String.getRouteWithParametersValue(value: String) = "$this\\$value"