package cn.deleiguo.issue.fastexcel.issue155;

import cn.deleiguo.issue.util.TestFileUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.idev.excel.FastExcel;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.read.listener.ReadListener;
import cn.idev.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson2.JSON;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Issue155ReadListenerTest implements ReadListener<JilicuangOrder> {
    private final File temp = FileUtil.createTempFile();

    public static void main(String[] args) throws IOException {
        Issue155ReadListenerTest listener = new Issue155ReadListenerTest();
        File sourceFile = TestFileUtil.readFile("issue/fastexcel/issue155/test-155.xls");

        // 创建临时文件---------------------------------------------------------
        try (OutputStream outputStream = FileUtil.getOutputStream(listener.temp)) {
            try (InputStream inputStream = FileUtil.getInputStream(sourceFile)) {
                IoUtil.copy(inputStream, outputStream);
            }
        }

        // 准备回调接口---------------------------------------------------------
        FastExcel.read(listener.temp, JilicuangOrder.class, listener)
                .excelType(ExcelTypeEnum.XLS)
                .sheet()
                .useScientificFormat(false)
                .autoTrim(true)
                .doRead();

        // TODO 如果是在这里删除文件就正常
        // 但是业务情况是采用异步的，所以没这条件
//        FileUtil.del(listener.temp);
    }

    @Override
    public void invoke(JilicuangOrder data, AnalysisContext context) {
        System.out.println(JSON.toJSONString(data));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 业务情况是需要在数据读取完成后删除临时文件
        // TODO 如果是在这里删除文件就会报错
        FileUtil.del(temp);
    }
}
