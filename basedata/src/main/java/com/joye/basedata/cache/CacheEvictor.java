package com.joye.basedata.cache;

import java.io.File;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */

public class CacheEvictor implements Runnable {
    private final FileManager fileManager;
    private final File file;

    public CacheEvictor(FileManager fileManager, File file) {
        this.fileManager = fileManager;
        this.file = file;
    }

    @Override
    public void run() {
        if(file.isDirectory()) {
            fileManager.clearDirectory(file);
        }else{
            file.delete();
        }
    }
}
