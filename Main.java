package com.ajiu.shuoshuo;

import org.openqa.selenium.NoSuchElementException;

import com.ajiu.shuoshuo.Shuoshuo;

public class Main {
//	public static String savepath = "/root/java/jar/shuoshuo/";//保存路径
//	public static String chromedriver = "/root/java/jar/chromedriver/chromedriver";
	public static String savepath = "C:\\java\\shuoshuo\\";//保存路径
	public static String chromedriver = "C:\\chromedriver\\chromedriver.exe";
	public static String start = "";
	public static String end = "本说说由服务器生成发表！[/玫瑰]";
	public static void main(String[] args){
		DownloadImage di = new DownloadImage();//下载图片类
		GetText gt = new GetText();
		LogWrite lr = new LogWrite();//日志写入类
		Shuoshuo ss = new Shuoshuo();
		boolean flag = false;
		while(!flag) {
		try {
			lr.init(savepath + "log/");
			di.init(savepath);
			lr.logWrite("开始匹配！");
			String[] all = gt.getAll(new Driver().getDriver(chromedriver));
			di.download(all[0], savepath);
			for(int i = 0; i < all.length; i ++) {
				lr.logWrite(all[i]);
			}
			lr.logClose();
			ss.sendShuoshuo(all, start, end, di.reTime(), di.getPhotoUrl(savepath), new Driver().getDriver(chromedriver), savepath);
			flag = true;
		} catch (InterruptedException e) {
			
		} catch (NoSuchElementException n) {
			
		}
		}
	}
}
