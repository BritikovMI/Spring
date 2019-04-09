package ru.rbt.jetski.xls;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by misha on 14.08.2018.
 */
public abstract class PoiHandler {

    private static final Logger logger = Logger.getLogger(PoiHandler.class.getName());

    public abstract Workbook createWorkbook();

    public void saveBook(Workbook book, long dealId, String agreementNum, String dir) {
        try {
            FileOutputStream fos = new FileOutputStream(dir + File.separator + dealId + "-" + agreementNum + ".xls");
            book.write(fos);
            book.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Book write error: " + e.getMessage(), e);
        }
    }

    public void makeSheet(Workbook book, String name, List<Object[]> data) {
        Sheet sheet = book.createSheet(name);
        makeDataSheet(data, sheet);
    }

    private void makeDataSheet(List<Object[]> data, Sheet sheet) {
        Row row;
        Cell cell;
        int rowNum = 0;
        int colNum;
        for (Object[] objRow : data) {
            row = sheet.createRow(rowNum);
            colNum = 0;
            for (Object obj : objRow) {
                cell = row.createCell(colNum);
                cell.setCellValue(obj == null ? "" : obj.toString());
                colNum++;
            }
            rowNum++;
        }
    }
}
