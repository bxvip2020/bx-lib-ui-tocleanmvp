package co.bxvip.ui.tocleanmvp.base

import co.bxvip.android.commonlib.utils.CommonInit
import java.io.File

object CacheFile {

    /*加密*/
    fun String.encode2(key: Int = 100): String {
        val array = this.toCharArray()
        for (i in array.indices) {
            array[i] = (array[i].toInt() + key).toChar()
        }
        return String(array)
    }

    // 获取缓存的文件夹路径 /cache + xxxx
    fun getCacheRoot(path: String) = CommonInit.ctx.externalCacheDir.absolutePath + path

    // 获取文件路径  /cache+ xxx/ + fileName
    fun f(key: String, path: String = "sp_dir", cut: Boolean = true): File = File(getCacheRoot(path), cutFileName(key, cut))

    /*读取数据*/
    fun readSpitValue(key: String, def: String, path: String = "sp_dir/sp_bak", cut: Boolean = true): String {
        return try {
            val f = f(key, path, cut)
            return if (!f.exists()) {
                def
            } else {
                f.readText()
            }
        } catch (e: Exception) {
            def
        }
    }

    /**
     * @param String key name
     * @param model 文件名称
     */
    private fun cutFileName(key: String, cut: Boolean = true): String {
        return when {
            key.startsWith("User-") -> place("User-", key)
            key.startsWith("System-") -> place("System-", key)
            key.startsWith("Url-") -> place("Url-", key)
            key.startsWith("Other-") -> place("Other-", key)
            else -> if (cut) "Other-" + key.encode2() else key
        }
    }

    private fun place(key: String, v: String): String = key + v.replace(key, "").encode2()
}