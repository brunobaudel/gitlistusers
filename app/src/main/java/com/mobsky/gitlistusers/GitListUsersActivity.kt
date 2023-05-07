package com.mobsky.gitlistusers

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.mobsky.gitlistusers.ui.theme.GitListUsersTheme

class GitListUsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GitListUsersTheme{

            }
        }

    }


}