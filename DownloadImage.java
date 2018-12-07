package com.ajiu.shuoshuo;
/* 
 * 该类将获取的图片链接下载 保存到存储路径  命名为当天日期
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
//下载图片
public class DownloadImage {
	OutputStream os;
	InputStream is;
	String urlString;
	public String reDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}
	
	public String reTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(d);
	}
	
	public String getPhotoUrl(String savepath) {
		String dateyMd = reDate();
		System.out.println(dateyMd);
		String filename = savepath + dateyMd + ".jpg";
		System.out.println(filename);
		return filename;
	}
	public boolean init(String savepath) throws InterruptedException {
		boolean sign = true;//判断当天有没有下载过图片
		File f = new File(getPhotoUrl(savepath));
		System.out.println(f.getName());
		if(f.exists())
			sign = false;
		return sign;
	}
	public void download(String photo_url, String savepath) {//下载图片
		try {
			urlString = photo_url;//得到链接
			URL url = new URL(urlString);//建立网络连接
			URLConnection con = url.openConnection();
			con.setConnectTimeout(5000);
			is = con.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			os = new FileOutputStream(getPhotoUrl(savepath));
			while((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			os.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		DownloadImage d = new DownloadImage();
//		d.getPhotoUrl("D:/log/ceshi/");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(d));
	}
}
