package com.mobsky.navigation

object RootGraph {
    const val ROOT = "root_graph"
}

object HomeGraph {
    const val ROOT = "home_graph"
    const val HOME = "home_screen"
}

object AppGraph {
    val initial = RootGraph
    val homeGraph = HomeGraph
}