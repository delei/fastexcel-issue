package cn.deleiguo.issue.fastexcel.issue564;

import cn.idev.excel.write.handler.SheetWriteHandler;
import cn.idev.excel.write.handler.context.SheetWriteHandlerContext;
import cn.idev.excel.write.metadata.WriteSheet;
import cn.idev.excel.write.metadata.holder.WriteSheetHolder;
import org.apache.poi.ss.usermodel.Sheet;

public class CustomSheetNoWriteHandler implements SheetWriteHandler {
    @Override
    public void afterSheetCreate(SheetWriteHandlerContext context) {
        WriteSheetHolder writeSheetHolder = context.getWriteSheetHolder();
        Sheet sheet = writeSheetHolder.getSheet();
        WriteSheet writeSheet = writeSheetHolder.getWriteSheet();
        if (sheet != null && writeSheetHolder.getSheetNo() == null) {
            // set sheet no to write sheet
            int sheetIndex = context.getWriteWorkbookHolder().getWorkbook().getSheetIndex(sheet);
            if (sheetIndex > -1) {
                writeSheetHolder.setSheetNo(sheetIndex);
                writeSheet.setSheetNo(sheetIndex);
            }
        }
    }
}
