package com.dingchuan.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import java.io.File;
import java.io.OutputStream;
import java.util.List;

/**
 * 自定义EasyExcel写工厂
 * @author lijin
 */
public class EasyExcelWriterFactory
{
    private int sheetNo = 0;
    private ExcelWriter excelWriter = null;

    public EasyExcelWriterFactory(OutputStream outputStream) {
        excelWriter = EasyExcelFactory.write(outputStream).build();
    }

    public EasyExcelWriterFactory(File file) {
        excelWriter = EasyExcelFactory.write(file).build();
    }

    public EasyExcelWriterFactory(String filePath) {
        excelWriter = EasyExcelFactory.write(filePath).build();
    }

    /**
     * 链式模板表头写入
     * @param headClazz 表头格式
     * @param data 数据 List<ExcelModel> 或者List<List<Object>>
     * @return
     */
    public EasyExcelWriterFactory writeModel(Class headClazz, List data, String sheetName){
        excelWriter.write(data, EasyExcelFactory.writerSheet(this.sheetNo++, sheetName).head(headClazz).build());
        return this;
    }

    /**
     * 链式自定义表头写入
     * @param head
     * @param data 数据 List<ExcelModel> 或者List<List<Object>>
     * @param sheetName
     * @return
     */
    public EasyExcelWriterFactory write(List<List<String>> head, List data, String sheetName){
        excelWriter.write(data, EasyExcelFactory.writerSheet(this.sheetNo++, sheetName).head(head).build());
        return this;
    }

    public void finish() {
        excelWriter.finish();
    }
}


