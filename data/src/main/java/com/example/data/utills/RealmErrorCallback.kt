package com.example.data.utills

import android.util.Log
import com.example.domain.utills.RealmState
import io.realm.Realm

class RealmErrorCallback(private val realm: Realm, private val function:(state : RealmState) -> Unit) : Realm.Transaction.OnError {
    override fun onError(error: Throwable) {
        realm.close()
        Log.e(GET_USER_REALM_TAG, error.message.toString())
        function(RealmState.ERROR)
    }
}