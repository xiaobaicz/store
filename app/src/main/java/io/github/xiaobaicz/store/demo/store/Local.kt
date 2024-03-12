package io.github.xiaobaicz.store.demo.store

import io.github.xiaobaicz.store.demo.entity.Account
import io.github.xiaobaicz.store.mmkv.annotation.MMKVStore
import io.github.xiaobaicz.store.serialize.gson.annotation.GsonSerialize

@MMKVStore
@GsonSerialize
interface Local {
    var account: Account?
    var version: String?
}