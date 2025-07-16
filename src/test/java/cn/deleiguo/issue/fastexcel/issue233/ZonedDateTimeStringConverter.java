package cn.deleiguo.issue.fastexcel.issue233;

import cn.idev.excel.converters.Converter;
import cn.idev.excel.enums.CellDataTypeEnum;
import cn.idev.excel.metadata.GlobalConfiguration;
import cn.idev.excel.metadata.data.WriteCellData;
import cn.idev.excel.metadata.property.ExcelContentProperty;

import java.time.ZonedDateTime;

/**
 * @author deleiguo
 */
public class ZonedDateTimeStringConverter implements Converter<ZonedDateTime> {

    @Override
    public Class<ZonedDateTime> supportJavaTypeKey() {
        return ZonedDateTime.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public WriteCellData<?> convertToExcelData(ZonedDateTime value, ExcelContentProperty contentProperty,
                                               GlobalConfiguration globalConfiguration) throws Exception {
        return new WriteCellData<>(value.toLocalDateTime());
    }
}
