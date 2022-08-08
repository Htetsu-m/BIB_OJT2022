package ojt.form.crud.bl.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ojt.form.crud.bl.service.UserService;
import ojt.form.crud.persistance.dao.UserDao;
import ojt.form.crud.persistance.entity.User;
import ojt.form.crud.web.form.UserForm;

/**
 * <h2> UserServiceImpl Class</h2>
 * <p>
 * Process for Displaying UserServiceImpl
 * </p>
 * 
 * @author User
 *
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    /**
     * <h2>userDao</h2>
     * <p>
     * userDao
     * </p>
     */
    @Autowired
    private UserDao userDao;

    /**
     * <h2>getUserList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    @Transactional
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    /**
     * <h2>addUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userForm
     */
    @Override
    @Transactional
    public void addUser(UserForm userForm) {
        Date currentDate = new Date();
        User user = new User(userForm);
        this.userDao.addUser(user, currentDate);

    }

    /**
     * <h2>deleteUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userId
     */
    @Override
    @Transactional
    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }

    /**
     * <h2>getUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userID
     * @return
     */
    @Override
    public UserForm getUser(int userID) {
        User resultPost = this.userDao.getUser(userID);
        UserForm resultPostform = resultPost != null ? new UserForm(resultPost) : null;
        return resultPostform;
    }

    /**
     * <h2>updateUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userForm
     */
    @Override
    public void updateUser(UserForm userForm) {
        User updateUser = this.userDao.getUser(userForm.getId());
        updateUser.setName(userForm.getName());
        updateUser.setPhone(userForm.getPhone());
        updateUser.setEmail(userForm.getEmail());
        updateUser.setPassword(userForm.getPassword());
        updateUser.setUpdatedAt(new Date());
        this.userDao.updateUser(updateUser);
    }

    /**
     * <h2> readFromExcel </h2>
     * <p>
     * 
     * </p>
     * 
     * @param file
     * @return
     */
    @Override
    public String readFromExcel(MultipartFile file) {
        try {
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<User> userList = new ArrayList<User>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                User u = new User();
                int cellIndex = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIndex) {
                    case 0:
                        u.setId(currentCell.getCellType());
                        
                        break;
                    case 1:
                        u.setName(currentCell.getStringCellValue());
                        break;

                    case 2:
                        u.setPhone(currentCell.getCellType());
                        break;

                    case 3:
                        u.setEmail(currentCell.getStringCellValue());
                        break;
                    case 4:
                        u.setPassword(currentCell.getStringCellValue());
                        break;
                    default:
                        break;
                    }
                    cellIndex++;
                }
                userList.add(u);
            }
            workbook.close();
            for (User userData : userList) {
                this.userDao.addUser(userData, new Date());
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file :" + e.getMessage());
        } catch (EncryptedDocumentException e) {
            
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            
            e.printStackTrace();
        }
        return null;

    }
}