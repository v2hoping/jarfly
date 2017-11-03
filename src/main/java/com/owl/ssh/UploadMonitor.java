package com.owl.ssh;

import com.jcraft.jsch.SftpProgressMonitor;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Created by wanghouping on 2017/11/3.
 * Sftp上传进度监控.
 * @author houping wang
 */
public class UploadMonitor implements SftpProgressMonitor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private long max = 0;

    private long size = 0;

    private String src = null;

    private String dest = null;

    private long time = 0;

    private Date beginTime;

    private Date endTime;

    public UploadMonitor(String src, String dest) {
        this.src = src;
        this.dest = dest;
        this.max = new File(src).length();
    }

    @Override
    public void init(int op, String src, String dest, long max) {
        this.beginTime = new Date();
        logger.info(String.format("The %s file max %s byte, start upload...", src, max));
    }

    @Override
    public boolean count(long count) {
        size += count;
        if(max == size) {
            logger.info(String.format("Current transfered %s byte,percent 100%%",size));
        }else{
            double percent = ((double) size / (double) max) * 100;
            DecimalFormat df = new DecimalFormat("#.##");
            logger.info(String.format("Current transfered %s byte,percent %s%%", size, df.format(percent)));
        }
        return true;
    }

    @Override
    public void end() {
        this.time = (new Date().getTime() - beginTime.getTime())/1000;
        logger.info(String.format("The %s file upload finish, the file server address is %s,upload total time is %s s,file size is %s byte", src, dest, time, max));
    }

}
