package cn.deleiguo.issue.easyexcel.issu3745;

import cn.deleiguo.issue.common.DemoData;
import cn.deleiguo.issue.util.TestFileUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.idev.excel.FastExcel;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import cn.idev.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Issue3745Test {
    @Test
    void testUse1904windowing() throws Exception {
        File testFile = TestFileUtil.createNewFile("issue/easyexcel/test.xlsx");

        // write file
        FastExcel.write(testFile, DemoData.class).excelType(ExcelTypeEnum.XLSX)
                .use1904windowing(Boolean.TRUE)  // set use1904windowing to TRUE
                .sheet()
                .doWrite(demoData(1));

        FastExcel.read(testFile, new AnalysisEventListener<DemoData>() {
                    @Override
                    public void invoke(DemoData data, AnalysisContext context) {
                        log.info("Parsed a data row:{}", JSON.toJSONString(data));
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext context) {
                        boolean isUse1904windowing = context.readSheetHolder().globalConfiguration().getUse1904windowing();
                        log.info("isUse1904windowing: {}", isUse1904windowing);
                    }
                })
                .excelType(ExcelTypeEnum.XLSX)
                .head(DemoData.class)
                .sheet()
                .doReadSync();
    }

    private List<DemoData> demoData(int size) {
        List<DemoData> dataList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            DemoData demoData = new DemoData();
            demoData.setString("String" + i);
            demoData.setDate(DateUtil.date());
            demoData.setDoubleData(RandomUtil.randomDouble());
            dataList.add(demoData);
        }
        return dataList;
    }
}
