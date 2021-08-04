package com.aldrek.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import android.R

import androidx.core.app.NotificationCompat

import android.app.NotificationManager

import android.app.NotificationChannel
import android.os.Build


class UploadWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {


    override fun doWork(): Result {
        displayNotification("Title" , "Task")

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }

    private fun displayNotification(title: String, task: String) {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "Notification",
                "Notification",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
        val notification: NotificationCompat.Builder =
            NotificationCompat.Builder(applicationContext, "notification")
                .setContentTitle(title)
                .setContentText(task)
                .setSmallIcon(R.drawable.ic_lock_idle_alarm)
        notificationManager.notify(1, notification.build())
    }

}