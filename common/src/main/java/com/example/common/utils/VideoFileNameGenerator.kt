package com.example.common.utils

import com.danikula.videocache.file.FileNameGenerator

class VideoFileNameGenerator : FileNameGenerator {
    override fun generate(url: String?): String {
        return  url.toString().toMd5() + ".mp4"
    }
}