package cn.deleiguo.issue.fastexcel.issue155;

import cn.hutool.core.io.FileUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.metadata.CellExtra;
import cn.idev.excel.read.listener.ReadListener;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author deleiguo
 */
@Slf4j
public class Issue155ReadListener implements ReadListener<JilicuangOrder> {
    private final File temp;

    public Issue155ReadListener(File tempFile) {
        this.temp = tempFile;
        log.info("临时文件:{}", temp);
    }

    @Override
    public void invoke(JilicuangOrder data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        FileUtil.del(this.temp);
    }

}