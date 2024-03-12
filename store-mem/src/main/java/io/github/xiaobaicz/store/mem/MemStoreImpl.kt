@file:Suppress("unused")
package io.github.xiaobaicz.store.mem

import com.google.auto.service.AutoService
import io.github.xiaobaicz.store.Store
import io.github.xiaobaicz.store.mem.annotation.MemStore

@AutoService(Store::class)
class MemStoreImpl : Store {
    private val map: MutableMap<String, MutableMap<String, String>> = HashMap()
    private fun findTable(table: String): MutableMap<String, String> {
        if (map[table] == null)
            map[table] = HashMap()
        return map[table]!!
    }
    override fun set(table: String, key: String, value: String?) {
        val t = findTable(table)
        if (value == null) {
            t.remove(key)
            return
        }
        t[key] = value
    }

    override fun get(table: String, key: String): String? {
        val t = findTable(table)
        return t[key]
    }

    override fun clear(table: String) {
        map[table]?.clear()
    }

    override fun filter(clazz: Class<*>): Boolean {
        return clazz.getAnnotation(MemStore::class.java) != null
    }
}