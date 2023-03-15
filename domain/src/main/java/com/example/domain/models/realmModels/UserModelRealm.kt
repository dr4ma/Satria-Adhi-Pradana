package com.example.domain.models.realmModels

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserModelRealm(
    @PrimaryKey
    var id: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",
    var photoUri: String = ""
) : RealmObject()