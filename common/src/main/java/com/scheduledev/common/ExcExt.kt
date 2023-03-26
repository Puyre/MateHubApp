package com.scheduledev.common

import com.sheduledev.domain.model.exceptions.ConnectionExc
import com.sheduledev.domain.model.exceptions.InvalidCredentialsExc

fun Exception.handle(): String {
    return when (this) {
        is ConnectionExc -> "Connection error"
        is InvalidCredentialsExc -> "Credentials error"
        else -> "Unexpected error"
    }
}