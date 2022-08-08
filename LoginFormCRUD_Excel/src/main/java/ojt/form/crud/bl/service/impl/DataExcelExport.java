 package ojt.form.crud.bl.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import ojt.form.crud.persistance.entity.User;

/**
 * <h2> DataExcelExport Class</h2>
 * <p>
 * Process for Displaying DataExcelExport
 * </p>
 * 
 * @author User
 *
 */
public class DataExcelExport extends AbstractXlsxView {

    /**
     * <h2> buildExcelDocument </h2>
     * <p>
     * 
     * </p>
     * 
     * @param model
     * @param workbook
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        response.addHeader("Content-Disposition", "attachment;fileName=LoginList.xlsx");
        @SuppressWarnings("unchecked")               
        List<User> list = (List<User>) model.get("userList");
        Sheet sheet = workbook.createSheet("User");
        // create row0 as a header
        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("ID");
        row0.createCell(1).setCellValue("NAME");
        row0.createCell(2).setCellValue("PHONE");
        row0.createCell(3).setCellValue("EMAIL");
        row0.createCell(4).setCellValue("PASSWORD");

        // create row1 onwards from List<T>
        int rowNum = 1;
        for (User user : list) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getPhone());
            row.createCell(3).setCellValue(user.getEmail());
            row.createCell(4).setCellValue(user.getPassword());
        }
    }

}
