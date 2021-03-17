package org.cph.vhr.utils;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.cph.vhr.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


/**
 * @author cph
 * @create 2020-12-13 18:48
 */
public class POIUtils {

    /**
     * 员工集合解析成excel
     *
     * @param list
     * @return
     */
    public static ResponseEntity<byte[]> employee2Excel(List<Employee> list) {
        // 1. 创建一个Excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 2. 创建文档摘要
        workbook.createInformationProperties();
        // 3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        // 文档类别
        docInfo.setCategory("员工信息");
        // 文档管理员
        docInfo.setManager("cph");
        // 设置公司信息
        docInfo.setCompany("凝结集团");
        // 4. 获取文档摘要信息
        SummaryInformation summaryInfo = workbook.getSummaryInformation();
        // 文档标题
        summaryInfo.setTitle("员工信息表");
        // 文档作者
        summaryInfo.setAuthor("cph");
        // 文档备注
        summaryInfo.setComments("本文档由cph提供");
        // 5. 创建样式
        // 创建标题行的样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 创建日期样式
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

        HSSFSheet sheet = workbook.createSheet("员工信息表");
        // 设置列的宽度
        sheet.setColumnWidth(0, 5 * 256);   // 大概5个字符
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 5 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 10 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 16 * 256);
        sheet.setColumnWidth(9, 12 * 256);
        sheet.setColumnWidth(10, 25 * 256);
        sheet.setColumnWidth(11, 20 * 256);
        sheet.setColumnWidth(12, 16 * 256);
        sheet.setColumnWidth(13, 14 * 256);
        sheet.setColumnWidth(14, 14 * 256);
        sheet.setColumnWidth(15, 12 * 256);
        sheet.setColumnWidth(16, 10 * 256);
        sheet.setColumnWidth(17, 10 * 256);
        sheet.setColumnWidth(18, 20 * 256);
        sheet.setColumnWidth(19, 20 * 256);
        sheet.setColumnWidth(20, 10 * 256);
        sheet.setColumnWidth(21, 15 * 256);
        sheet.setColumnWidth(22, 15 * 256);
        sheet.setColumnWidth(23, 15 * 256);
        sheet.setColumnWidth(24, 15 * 256);
        sheet.setColumnWidth(25, 15 * 256);
        // 6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        // 创建列
        HSSFCell c0 = r0.createCell(0);
        // 加背景颜色
        c0.setCellStyle(headerStyle);
        // 设置列名
        c0.setCellValue("编号");

        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("姓名");

        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("工号");

        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("性别");

        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("出生日期");

        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("身份证号码");

        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("婚姻状况");

        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("民族");

        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("籍贯");

        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("政治面貌");

        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("电子邮件");

        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("电话号码");

        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(headerStyle);
        c12.setCellValue("联系地址");

        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(headerStyle);
        c13.setCellValue("所属部门");

        HSSFCell c14 = r0.createCell(14);
        c14.setCellStyle(headerStyle);
        c14.setCellValue("职位");

        HSSFCell c15 = r0.createCell(15);
        c15.setCellStyle(headerStyle);
        c15.setCellValue("职称");

        HSSFCell c16 = r0.createCell(16);
        c16.setCellStyle(headerStyle);
        c16.setCellValue("聘用形式");

        HSSFCell c17 = r0.createCell(17);
        c17.setCellStyle(headerStyle);
        c17.setCellValue("最高学历");

        HSSFCell c18 = r0.createCell(18);
        c18.setCellStyle(headerStyle);
        c18.setCellValue("专业");

        HSSFCell c19 = r0.createCell(19);
        c19.setCellStyle(headerStyle);
        c19.setCellValue("毕业院校");

        HSSFCell c20 = r0.createCell(20);
        c20.setCellStyle(headerStyle);
        c20.setCellValue("在职状态");

        HSSFCell c21 = r0.createCell(21);
        c21.setCellStyle(headerStyle);
        c21.setCellValue("入职日期");

        HSSFCell c22 = r0.createCell(22);
        c22.setCellStyle(headerStyle);
        c22.setCellValue("转正日期");

        HSSFCell c23 = r0.createCell(23);
        c23.setCellStyle(headerStyle);
        c23.setCellValue("合同起始日期");

        HSSFCell c24 = r0.createCell(24);
        c24.setCellStyle(headerStyle);
        c24.setCellValue("合同终止日期");

        HSSFCell c25 = r0.createCell(25);
        c25.setCellStyle(headerStyle);
        c25.setCellValue("合同期限(年)");

        for (int i = 0; i < list.size(); i++) {
            Employee emp = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getName());
            row.createCell(2).setCellValue(emp.getWorkID());
            row.createCell(3).setCellValue(emp.getGender());

            HSSFCell cell4 = row.createCell(4);
            cell4.setCellStyle(dateCellStyle);
            cell4.setCellValue(emp.getBirthday());

            row.createCell(5).setCellValue(emp.getIdCard());
            row.createCell(6).setCellValue(emp.getWedlock());
            row.createCell(7).setCellValue(emp.getNation().getName());
            row.createCell(8).setCellValue(emp.getNativePlace());
            row.createCell(9).setCellValue(emp.getPoliticsstatus().getName());
            row.createCell(10).setCellValue(emp.getEmail());
            row.createCell(11).setCellValue(emp.getPhone());
            row.createCell(12).setCellValue(emp.getAddress());
            row.createCell(13).setCellValue(emp.getDepartment().getName());
            row.createCell(14).setCellValue(emp.getPosition().getName());
            row.createCell(15).setCellValue(emp.getJobLevel().getName());
            row.createCell(16).setCellValue(emp.getEngageForm());
            row.createCell(17).setCellValue(emp.getTiptopDegree());
            row.createCell(18).setCellValue(emp.getSpecialty());
            row.createCell(19).setCellValue(emp.getSchool());
            row.createCell(20).setCellValue(emp.getWorkState());

            HSSFCell cell19 = row.createCell(21);
            cell19.setCellStyle(dateCellStyle);
            cell19.setCellValue(emp.getBeginDate());

            HSSFCell cell25 = row.createCell(22);
            cell25.setCellStyle(dateCellStyle);
            cell25.setCellValue(emp.getConversionTime());

            HSSFCell cell23 = row.createCell(23);
            cell23.setCellStyle(dateCellStyle);
            cell23.setCellValue(emp.getBeginContract());

            HSSFCell cell24 = row.createCell(24);
            cell24.setCellStyle(dateCellStyle);
            cell24.setCellValue(emp.getEndContract());

            row.createCell(25).setCellValue(emp.getContractTerm());
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            // 设置消息头
            // 通知浏览器以attachment（下载方式）打开文件
            headers.setContentDispositionFormData("attachment", new String("员工表.xls".getBytes(StandardCharsets.UTF_8), "ISO-8859-1"));
            // 设置MediaType，即Internet Media Type（互联网媒体类型），MIME类型
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            // 将workBook写到输出流里
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    /**
     * Excel解析成员工数据集合
     *
     * @param file
     * @param allNations
     * @param allPoliticsStatus
     * @param allDepartments
     * @param allJobLevels
     * @param allPositions
     * @return
     */
    public static List<Employee> excel2Employee(MultipartFile file, List<Nation> allNations, List<PoliticsStatus> allPoliticsStatus,
												List<Department> allDepartments, List<JobLevel> allJobLevels, List<Position> allPositions) {
        List<Employee> list = new ArrayList<>();
        Employee employee;
        try {
            // 1.创建workbook对象，里面存放的是excel表单
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            // 2.获取表单数量
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                // 3.获取表单
                HSSFSheet sheetAt = workbook.getSheetAt(i);
                // 4.获取表单中的行数
                int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    // 5.跳过标题行
                    if (j == 0) {
                        continue;   // 跳过标题行，标题行不解析
                    }
                    // 6.获取行
                    HSSFRow row = sheetAt.getRow(j);
                    if (row == null) {
                        continue;   // 跳过空行
                    }
                    // 7.获取列数
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    employee = new Employee();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellType()) {
                            case STRING:
                                String stringCellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 1:
                                        employee.setName(stringCellValue);
                                        break;
                                    case 2:
                                        employee.setWorkID(stringCellValue);
                                        break;
                                    case 3:
                                        employee.setGender(stringCellValue);
                                        break;
                                    case 5:
                                        employee.setIdCard(stringCellValue);
                                        break;
                                    case 6:
                                        employee.setWedlock(stringCellValue);
                                        break;
                                    case 7:
                                        int nationIndex = allNations.indexOf(new Nation(stringCellValue));
                                        employee.setNationId(allNations.get(nationIndex).getId());
                                        break;
                                    case 8:
                                        employee.setNativePlace(stringCellValue);
                                        break;
                                    case 9:
                                        int politicsStatusIndex = allPoliticsStatus.indexOf(new PoliticsStatus(stringCellValue));
                                        employee.setPoliticId(allPoliticsStatus.get(politicsStatusIndex).getId());
                                        break;
                                    case 10:
                                        employee.setEmail(stringCellValue);
                                        break;
                                    case 11:
                                        employee.setPhone(stringCellValue);
                                        break;
                                    case 12:
                                        employee.setAddress(stringCellValue);
                                        break;
                                    case 13:
                                        int departmentIndex = allDepartments.indexOf(new Department(stringCellValue));
                                        employee.setDepartmentId(allDepartments.get(departmentIndex).getId());
                                        break;
                                    case 14:
                                        int positionIndex = allPositions.indexOf(new Position(stringCellValue));
                                        employee.setPosId(allPositions.get(positionIndex).getId());
                                        break;
                                    case 15:
                                        int jobLevelIndex = allJobLevels.indexOf(new JobLevel(stringCellValue));
                                        employee.setJobLevelId(allJobLevels.get(jobLevelIndex).getId());
                                        break;
                                    case 16:
                                        employee.setEngageForm(stringCellValue);
                                        break;
                                    case 17:
                                        employee.setTiptopDegree(stringCellValue);
                                        break;
                                    case 18:
                                        employee.setSpecialty(stringCellValue);
                                        break;
                                    case 19:
                                        employee.setSchool(stringCellValue);
                                        break;
                                    case 20:
                                        employee.setWorkState(stringCellValue);
                                        break;
                                }
                                break;
                            default: {
                                switch (k) {
                                    case 4:
                                        employee.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 21:
                                        employee.setBeginDate(cell.getDateCellValue());
                                        break;
                                    case 22:
                                        employee.setConversionTime(cell.getDateCellValue());
                                        break;
                                    case 23:
                                        employee.setBeginContract(cell.getDateCellValue());
                                        break;
                                    case 24:
                                        employee.setEndContract(cell.getDateCellValue());
                                        break;
                                    case 25:
                                        employee.setContractTerm(cell.getNumericCellValue());
                                        break;
                                }
                            }
                        }
                    }
                    list.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

