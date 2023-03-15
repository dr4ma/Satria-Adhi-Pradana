package com.example.domain.utills

import com.example.domain.models.UserModel
import com.example.domain.models.realmModels.UserModelRealm

fun UserModel.mapToRealmModel(): UserModelRealm {
    return UserModelRealm(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email,
        password = this.password,
        photoUri = this.photoUri
    )
}

fun UserModelRealm.mapToRegularModel(): UserModel {
    return UserModel(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email,
        password = this.password,
        photoUri = this.photoUri
    )
}