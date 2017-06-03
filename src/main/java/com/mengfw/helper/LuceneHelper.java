package com.mengfw.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by mengfw on 2017/6/3.
 */
@Component
public class LuceneHelper {
    @Value("${lucene.filePath}")
    private String filePath;
    @Value("${indexPath}")
    private String indexPath;

    
}
