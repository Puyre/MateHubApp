package com.sheduledev.data.auth.common.local

import android.content.SharedPreferences
import androidx.core.content.edit
import com.sheduledev.domain.model.TokenPair
import javax.inject.Inject

class TokenLocalDataSource @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val ACCESS_TOKEN_KEY = "ACCESS_TOKEN_KEY"
        const val REFRESH_TOKEN_KEY = "REFRESH_TOKEN_KEY"
    }

    fun setTokens(tokenPair: TokenPair) {
        prefs.edit {
            putString(ACCESS_TOKEN_KEY, tokenPair.accessToken)
            putString(REFRESH_TOKEN_KEY, tokenPair.refreshToken)
        }
    }

    fun getAccessToken(): String {
        return prefs.getString(ACCESS_TOKEN_KEY, "") ?: ""
    }

    fun getRefreshToken(): String {
        return prefs.getString(REFRESH_TOKEN_KEY, "") ?: ""
    }
}