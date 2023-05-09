package com.mobsky.navigation

object RootGraph {
    const val ROOT = "root_graph"
}

object HomeGraph {
    const val ROOT = "home_graph"
    const val HOME = "home_screen"
    const val USER_REPOSITORIES = "user_repositories"
}

object HomeGraphArgs {
    const val USER_REPOSITORIES_NAME_PARAM = "username"
}

object AppGraph {
    val initial = RootGraph
    val homeGraph = HomeGraph
}

fun String.getRouteWithParameters(parameterName: String) = "$this\\{$parameterName}"
fun String.getRouteWithParametersValue(parameterName: String) = "$this\\$parameterName"