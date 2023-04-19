package com.hyundaiautoever.haeproduct.config.auth

object UserContextHolder {
    private val userContextHolder = ThreadLocal<User>()

    fun getUserContext(): User? {
        return userContextHolder.get()
    }

    fun setUserContext(context: User?) {
        this.userContextHolder.set(context)
    }

    fun clearUserContext() {
        userContextHolder.remove()
    }
}
