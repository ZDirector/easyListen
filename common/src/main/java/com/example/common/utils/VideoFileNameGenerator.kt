package com.example.common.utils

import com.danikula.videocache.file.FileNameGenerator

class VideoFileNameGenerator : FileNameGenerator {
    override fun generate(url: String?): String {
        val location = url.toString().indexOf("/mv/") + 4
        val songId = StringBuilder()
        for (i in location until url.toString().length){
            if (url.toString()[i] != '/') songId.append(url.toString()[i])
            else break
        }
        return  songId.toString().toMd5() + ".mp4"
    }
}