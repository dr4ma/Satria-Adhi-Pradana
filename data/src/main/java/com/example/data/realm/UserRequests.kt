package com.example.data.realm

import com.example.data.utills.RealmErrorCallback
import com.example.domain.models.realmModels.UserModelRealm
import com.example.domain.repository.UserRepository
import com.example.domain.utills.RealmState
import io.realm.Realm

class UserRequests(private val realm: Realm) : UserRepository {

    override fun insertOrUpdateUserModel(model: UserModelRealm, function: (state : RealmState) -> Unit) {
        realm.executeTransactionAsync({ transition ->
            transition.insertOrUpdate(model)
        }, { function(RealmState.SUCCESS) }, RealmErrorCallback(realm) { function(RealmState.ERROR) })
    }

    override fun getUserModel(function: (UserModelRealm) -> Unit) {
        realm.executeTransactionAsync({ transition ->
            function(transition.where(UserModelRealm::class.java).findFirst() ?: UserModelRealm())
        }, RealmErrorCallback(realm){})
    }
}