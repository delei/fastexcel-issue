package cn.deleiguo.issue.fastexcel.issue237;

import cn.idev.excel.metadata.data.WriteCellData;
import cn.idev.excel.util.BooleanUtils;
import cn.idev.excel.write.handler.CellWriteHandler;
import cn.idev.excel.write.handler.context.CellWriteHandlerContext;
import cn.idev.excel.write.metadata.style.WriteCellStyle;
import cn.idev.excel.write.metadata.style.WriteFont;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * @author deleiguo
 */
@Slf4j
public class Issue237WriteHandler implements CellWriteHandler {
    @Override
    public void afterCellDispose(CellWriteHandlerContext context) {
        if (BooleanUtils.isNotTrue(context.getHead())) {
            // 1. 当前单元格数据
            Object originalValue = context.getOriginalValue();
            log.info("正在处理: 行 {}, 列 {}, 值 {}", context.getRowIndex(), context.getColumnIndex(),
                    originalValue.toString());


            // 2. 当前单元格对象
            WriteCellData<?> cellData = context.getFirstCellData();
            WriteCellStyle writeCellStyle = cellData.getOrCreateStyle();

            // 3. 设置
            WriteFont writeFont = new WriteFont();
            // 根据条件设置字体颜色
            boolean flag = true;
            if (originalValue instanceof Double) {
                Double doubleValue = (Double) originalValue;
                flag = doubleValue >= 0.0D;
            }
            writeFont.setColor(flag ? IndexedColors.BLACK.getIndex() : IndexedColors.BRIGHT_GREEN.getIndex());
            writeCellStyle.setWriteFont(writeFont);
        }
    }
}
