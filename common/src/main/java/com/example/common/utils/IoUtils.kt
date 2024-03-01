package com.example.common.utils

import com.google.gson.Gson
import java.io.File

object IoUtils {

    private fun deleteFile(file: File): Boolean {
        return file.isFile && file.delete()
    }

    private fun deleteDir(dir: File): Boolean {
        if (!dir.isDirectory) return false
        val children = dir.list()
        if (children != null) {
            for (i in children.indices) {
                val success = deleteFile(File(dir, children[i]))
                if (!success) return false
            }
        }
        return dir.delete()
    }

    fun delete(file: File) : Boolean {
        if (!file.exists()) return false
        return if (file.isDirectory) deleteDir(file) else deleteFile(file)
    }

    /**
     * json避免服务端传null导致空指针
     */
    fun <T> fromJsonAvoidNull(json: String, classOfT: Class<T>): T {
        val gson = Gson()
        val temp = gson.fromJson(json, classOfT)
        return gson.fromJson(gson.toJson(temp), classOfT)
    }

}