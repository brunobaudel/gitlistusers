package com.mobsky.navigation

object RootGraph {
    const val ROOT = "root_graph"
}

object HomeGraph {
    const val ROOT = "homeGraph"
    const val HOME = "homeScreen"
    const val USER_REPOSITORIES = "userRepositories"
    const val USER_PROFILE = "userProfile"
}

object HomeGraphArgs {
    const val USER_REPOSITORIES_NAME_PARAM = "username"
    const val USER_PROFILE_NAME_PARAM = "username"
}

object AppGraph {
    val initial = RootGraph
    val homeGraph = HomeGraph
}

fun String.getRouteWithParameters(parameterName: String) = "$this\\{$parameterName}"
fun String.getRouteWithParametersValue(parameterName: String) = "$this\\$parameterName"