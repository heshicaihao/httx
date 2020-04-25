package com.ht.util;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JavaReadExcel
{
    public static void main(String[] args)
    {
        try
        {
            String fileName = "C:\\Documents and Settings\\907692\\桌面\\服务器列表.xls"; // Excel文件所在路径
            File file = new File(fileName); // 创建文件对象
            Workbook wb = Workbook.getWorkbook(file); // 从文件流中获取Excel工作区对象（WorkBook）
            Sheet sheet = wb.getSheet(0); // 从工作区中取得页（Sheet）

            for (int i = 0; i < sheet.getRows(); i++)
            { // 循环打印Excel表中的内容
                for (int j = 0; j < sheet.getColumns(); j++)
                {
                    Cell cell = sheet.getCell(j, i);
                    System.out.println(cell.getContents());
                }
                System.out.println();
            }
        }
        catch (BiffException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}