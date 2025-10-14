package com.example.duolingo.ui.lesson.listen

import android.annotation.SuppressLint
import android.content.ContentUris
import android.content.Context
import android.media.MediaPlayer
import android.media.PlaybackParams
import android.net.Uri
import android.provider.MediaStore

data class Audio(
    val id: Long,
    val name: String,
    val path: String
)

@SuppressLint("Range")
fun loadAllMp3Files(context: Context): List<Audio> {
    val list = mutableListOf<Audio>()
    val projection = arrayOf(
        MediaStore.Audio.Media._ID,
        MediaStore.Audio.Media.DISPLAY_NAME,
        MediaStore.Audio.Media.DATA
    )
    val selection = "${MediaStore.Audio.Media.DATA} LIKE ?"
    val selectionArgs = arrayOf("%/audio/%")

    val cursor = context.contentResolver.query(
        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
        projection,
        selection,
        selectionArgs,
        null
    )

    cursor?.use {
        val idColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
        val nameColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)
        val dataColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)

        while (it.moveToNext()) {
            val id = it.getLong(idColumn)
            val name = it.getString(nameColumn)
            val path = it.getString(dataColumn)

            list.add(Audio(id, name, path))
        }
    }
    return list
}

fun playAudio(context: Context, uri: Uri) {
    val mediaPlayer = MediaPlayer()
    mediaPlayer.setDataSource(context, uri)
    mediaPlayer.prepare()
    mediaPlayer.start()
}

fun playAudioSlow(context: Context, uri: Uri) {
    val mediaPlayer = MediaPlayer()
    mediaPlayer.setDataSource(context, uri)
    mediaPlayer.prepare()
    mediaPlayer.playbackParams = PlaybackParams().setSpeed(0.5f)
    mediaPlayer.start()
}