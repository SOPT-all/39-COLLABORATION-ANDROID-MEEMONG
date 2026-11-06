package com.sopt.meemong.core.common.extensions

import android.content.Context
import android.widget.Toast

/**
 * Toast를 표시합니다.
 *
 * @param message 토스트로 띄울 메시지
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
