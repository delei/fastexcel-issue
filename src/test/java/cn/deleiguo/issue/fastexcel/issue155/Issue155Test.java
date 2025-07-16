package cn.deleiguo.issue.fastexcel.issue155;

import cn.deleiguo.issue.util.TestFileUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.idev.excel.FastExcel;
import cn.idev.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class Issue155Test {

    @Test
    void testRead() throws Exception {
        File tempFile = FileUtil.createTempFile(TestFileUtil.createNewFile("issue/fastexcel/issue155/temp/"));

        File sourceFile = TestFileUtil.readFile("issue/fastexcel/issue155/test-155.xls");

        // 创建临时文件---------------------------------------------------------
        try (OutputStream outputStream = FileUtil.getOutputStream(tempFile)) {
            try (InputStream inputStream = FileUtil.getInputStream(sourceFile)) {
                IoUtil.copy(inputStream, outputStream);
            }
        }

        Issue155ReadListener listener = new Issue155ReadListener(tempFile);
        // 准备回调接口---------------------------------------------------------
        FastExcel.read(tempFile, JilicuangOrder.class, listener)
                .excelType(ExcelTypeEnum.XLS)
                .sheet()
                .useScientificFormat(false)
                .autoTrim(true)
                .doRead();

        // TODO 如果是在这里删除文件就正常
        // 但是业务情况是采用异步的，所以没这条件
//        FileUtil.del(listener.temp);
    }
}
