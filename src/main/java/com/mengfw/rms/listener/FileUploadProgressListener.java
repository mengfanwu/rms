package com.mengfw.rms.listener;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

/**
 * Created by MFW on 2017/5/24.
 */
@Component
public class FileUploadProgressListener implements ProgressListener {
    @Override
    public void update(long l, long l1, int i) {

    }
}
