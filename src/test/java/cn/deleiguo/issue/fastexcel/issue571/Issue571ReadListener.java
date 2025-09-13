package cn.deleiguo.issue.fastexcel.issue571;

import cn.deleiguo.issue.common.DemoData;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import cn.idev.excel.metadata.Cell;
import cn.idev.excel.metadata.data.CellData;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Issue571ReadListener extends AnalysisEventListener<DemoData> {
    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        log.info("Parsed a data row:{}", JSON.toJSONString(data));
        // 有公式优先存公式
        Map<Integer, Cell> cellMap = context.readRowHolder().getCellMap();
        for (Map.Entry<Integer, Cell> entry : cellMap.entrySet()) {
            CellData cellData = (CellData) entry.getValue();
            if (cellData.getFormulaData() != null) {
                log.info("Cell:{} has a formula:{}", entry.getKey(), cellData.getFormulaData().getFormulaValue());
            }
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("All data analysed");
    }
}
