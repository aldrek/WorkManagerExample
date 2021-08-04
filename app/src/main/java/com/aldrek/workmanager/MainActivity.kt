package com.aldrek.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.aldrek.workmanager.binding.viewBinding
import com.aldrek.workmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    val uploadWorkRequest: WorkRequest =
        OneTimeWorkRequestBuilder<UploadWorker>()
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textTitle.setOnClickListener{
            WorkManager
                .getInstance(this)
                .enqueue(uploadWorkRequest)
        }
    }

}