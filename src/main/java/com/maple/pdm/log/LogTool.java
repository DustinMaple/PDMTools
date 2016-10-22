package com.maple.pdm.log;

import com.maple.pdm.constants.StringConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by gjf on 2016/10/22.
 */
public class LogTool extends Thread{
    public static final Logger logger = LoggerFactory.getLogger(LogTool.class);

    private static JTextArea logPanel;
    private boolean status = true;
    private static final BlockingQueue<String>  logQueue = new ArrayBlockingQueue(10);

    public static void writeToPanelLine(String log){
        if(logQueue != null){
            try {
                logQueue.put(log + StringConstant.NEWLINE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeToPanel(String log){
        if(logQueue != null){
            try {
                logQueue.put(log);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while(status){
            if(logQueue.size() > 0){
                String log = logQueue.poll();
                logger.debug("The log content is {}.", log);
                if(logPanel != null){
                    logPanel.append(log);
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setLogPanel(JTextArea logPanel) {
        LogTool.logPanel = logPanel;
    }
}
