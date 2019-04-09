package ru.rbt.jetski.xls;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by misha on 14.08.2018.
 */
public class XlsHandler extends PoiHandler {
    @Override
    public Workbook createWorkbook() {
        return new HSSFWorkbook();
    }
}
