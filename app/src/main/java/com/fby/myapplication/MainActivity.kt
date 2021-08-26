package com.fby.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.fby.core.utils.CacheUtils
import com.fby.core.utils.Utils
import com.fby.lesson.LessonActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val usernameKey = "username"
    private val passwordKey = "password"
    private lateinit var et_username: EditText
    private lateinit var et_password: EditText
    private lateinit var et_code: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)
        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))
        val btn_login: Button = findViewById(R.id.btn_login)
        val img_code: CodeView = findViewById(R.id.code_view)
        btn_login.setOnClickListener(this)
        img_code.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v is CodeView) {
            v.updateCode()
        } else if (v is Button) {
            login()
        }

    }

    private fun login() {
        val username: String = et_username.text.toString()
        val password: String = et_password.text.toString()
        val code: String = et_code.text.toString()
        val user = User(username, password, code)
        fun verify(): Boolean {
            if (user.userName?.length ?: 0 < 4) {
                Utils.toast("用户名不合法")
                return false
            }
            if (user.password?.length ?: 0 < 4) {
                Utils.toast("密码不合法")
                return false
            }
            return true
        }
        if (verify()) {
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey,password)
            startActivity(Intent(this,LessonActivity::class.java))
        }
    }
}