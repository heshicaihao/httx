package org.krysalis.barcode4j.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class Getpic{
    public Getpic(){
    }

    public static boolean saveUrlAs(String fileUrl, String savePath)/*fileUrl网络资源地址*/
    {

         try
         {
            URL url = new URL("http://localhost:8080/ht123/barcode?msg=09900014A29");/*将网络资源地址传给,即赋值给url*/
            /*此为联系获得网络资源的固定格式用法，以便后面的in变量获得url截取网络资源的输入流*/
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            /*此处也可用BufferedInputStream与BufferedOutputStream*/
            DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath));
            /*将参数savePath，即将截取的图片的存储在本地地址赋值给out输出流所指定的地址*/
            byte[] buffer = new byte[4096];
            int count = 0;
            while ((count = in.read(buffer)) > 0)/*将输入流以字节的形式读取并写入buffer中*/
            {
                out.write(buffer, 0, count);
            }
            out.close();/*后面三行为关闭输入输出流以及网络资源的固定格式*/
            in.close();
            return true;/*网络资源截取并存储本地成功返回true*/

        }
        catch (Exception e)
        {
             System.out.println(e + fileUrl + savePath);
             return false;
        }
    }

    public static void main(String[] args)
    {
         Getpic pic = new Getpic();/*创建实例*/
         String  photoUrl = "http://localhost:8080/ht123/barcode?msg=09900014A29";
         String fileName = photoUrl.substring(photoUrl.lastIndexOf("/"));
         String filePath = "D:";
         /*调用函数，并且进行传参*/
        boolean flag = pic.saveUrlAs(photoUrl, filePath + fileName);
        System.out.println("Run ok!\n Get URL file " + flag);
        System.out.println(filePath);
        System.out.println(fileName);
    }

}
