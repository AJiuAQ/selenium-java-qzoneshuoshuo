package com.ajiu.shuoshuo;
/* 
 * 该类为整个流程中各个步骤的日志写入 保存在图片保存路径下的log文件夹中  文件命名为当天日期
 */
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//写日志
public class LogWrite {
//	String savepath = "D:/log/ceshi/log/";
	FileWriter fos;
	public void init(String savepath) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateyMd = sdf.format(d);
		savepath += dateyMd + ".txt";
		try {
			fos = new FileWriter(savepath, true);//文件写入方式为追加
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void logWrite(String text) {//将参数写入文件中
		try {
			System.out.println("输出日志，内容：" + text);
			fos.write((text + "\r\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void logClose() {
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
	}

}
