package com.itsrobocon.studentmanager.nav

import kotlinx.serialization.Serializable

@Serializable
object SplashScreenRoute

@Serializable
object HomeScreenRoute

@Serializable
data class UpsertStudentScreenRoute(val nim: String? = null)
