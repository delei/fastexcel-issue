package cn.deleiguo.issue.fastexcel.issue415;

import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.metadata.CellExtra;
import cn.idev.excel.read.listener.ReadListener;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author deleiguo
 */
@Slf4j
public class Issue415ReadListener implements ReadListener<ProductImportReqVO> {
    @Override
    public void invoke(ProductImportReqVO data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }

}