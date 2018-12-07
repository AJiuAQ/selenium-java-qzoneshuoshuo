package com.ajiu.shuoshuo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Shuoshuo{
	/**
	 * 冰上的“棋子”
新西兰，内斯比
慢悠悠的比赛却哪儿都是戏
看！在新西兰南部城市内斯比，寒冷的冬天为冰壶运动提供了绝佳的条件，这项运动被参赛选手们称之为“冰上国际象棋”。今年，第一届冰壶世界杯正式举办，开幕地点正是在中国。就在今天，美国奥马哈市举办的第二站比赛也开始了，如果你还不熟悉这项运动，赶紧来学习学习吧！
文/时尚旅游
此“壶”非彼“壶”
虽说是“壶”，但是冰壶可不是容器，冰壶中的“壶”称为“石壶”，主要材料是一种不含云母的花岗岩。有一种说法称，现代制作冰壶的石料仅在苏格兰开采，这种材质硬度高，吸水性弱，经撞击，不易碎，适合制作冰壶，所以冰壶贵就贵在这，而这也间接成为了冰壶运动起源于英格兰的证据。
冰壶比赛为啥要拼命“擦地板”？
冰壶比赛中印象最深的就是在“推”出去的冰壶前方会有两名运动员拿“扫把”一样的冰壶刷一直刷刷刷……搞不懂他们在干嘛。其实，”刷冰“是为了使冰面温度升高，造成冰面熔化，减小摩擦力。擦冰的作用有两个，一为让冰壶滑行的更远，二为微调冰壶的前行轨迹。
冰壶强国
在中国，冰壶运动尚在普及阶段，但是在欧洲或者美洲国家，人们对于冰壶运动的热爱不亚于足球。据统计，加拿大的冰壶俱乐部数量约为697个，苏格兰则多达651个，再次的是美国，约为220个……这些都是传统的冰壶强国。韩国、中国等国家则后来居上。
冰壶世界锦标赛
冰壶世界锦标赛始于1959年，最初称为苏格兰杯赛，1968年改为加拿大银扫帚锦标赛，1986年正式定名为世界掷冰壶锦标赛，是冰壶界一年一度的重要赛事，除奥运会外最高水平的冰壶比赛。今年的女子冰壶世界锦标赛在加拿大举行，中国女队一分惜败苏格兰。

	 * @param all
	 * @param date
	 * @return
	 */
	public String[] createShuoshuo(String[] all, String start, String end, String date) {
		String[] shuoshuo = {"", "", "", "", "", "", "", ""};
//		String head = "[/玫瑰]脚本测试，时间:" + date;
		shuoshuo[0] += start;
		for(int i = 1; i < all.length; i++) {
			switch(i) {
				case 1: shuoshuo[1] += all[i] + "——"; break;
				case 2: shuoshuo[1] += all[i] + "\r\n\r\n"; break;
				case 3: shuoshuo[1] += all[i] + "\r\n"; break;
				case 4: shuoshuo[2] += all[i] + "\r\n\r\n"; break;
				case 5: shuoshuo[2] += all[i] + "\r\n（"; break;
				case 6: shuoshuo[2] += all[i] + "）\r\n\r\n\r\n"; break;
				case 7: shuoshuo[3] += all[i] + "\r\n\r\n"; break;
				case 8: shuoshuo[3] += all[i] + "\r\n\r\n\r\n"; break;
				case 9: shuoshuo[4] += all[i] + "\r\n\r\n"; break;
				case 10: shuoshuo[4] += all[i] + "\r\n\r\n\r\n"; break;
				case 11: shuoshuo[5] += all[i] + "\r\n\r\n"; break;
				case 12: shuoshuo[5] += all[i] + "\r\n\r\n\r\n"; break;
				case 13: shuoshuo[6] += all[i] + "\r\n\r\n"; break;
				case 14: shuoshuo[6] += all[i] + "\r\n\r\n"; break;
				default: break;
			}
		}
		shuoshuo[7] += end + "\r\n时间：" + date;
//		System.out.println(shuoshuo);
		return shuoshuo;
	}
	
	public void sendShuoshuo(String[] all, String start, String end, String date, String photo_url, WebDriver driver,String savepath) throws InterruptedException {
		LogWrite lr = new LogWrite();
		lr.init(savepath + "log/");
		boolean flag = false;
		int time = 1;
//        WebDriver driver = null;
		while(!flag) {
		try {
			lr.logWrite(time + "次开始发表！");
			time++;
		
	        driver.get("https://ui.ptlogin2.qq.com/cgi-bin/login?pt_hide_ad=1&style=9&pt_ttype=1&appid=549000929&pt_no_auth=1&pt_wxtest=1&daid=5&s_url=https%3A%2F%2Fh5.qzone.qq.com%2Fmqzone%2Findex"); 
	        driver.manage().window().maximize();
	        lr.logWrite("载入网页");
//System.out.println(driver.getPageSource());
//	        Thread.sleep(3000);
//	        driver.findElement(By.cssSelector("#feed_list_cot_all > div:nth-child(1) > div.feed-bd > div > button.item.js-like.like")).click();
	        Thread.sleep(3000 );
	        lr.logWrite("输入账号");
	        driver.findElement(By.id("u")).click();
	        driver.findElement(By.id("u")).sendKeys("2014848963@qq.com");
	        Thread.sleep(1000);
	        lr.logWrite("输入密码");
	        driver.findElement(By.id("p")).click();
	        driver.findElement(By.id("p")).sendKeys("hang0511");
	        Thread.sleep(1000);
	        lr.logWrite("登录");
	        driver.findElement(By.id("go")).click();
	        
		    Thread.sleep(2000);
		    try {
		    	lr.logWrite("点击新建说说");
		        driver.findElement(By.cssSelector("#page-feed > div.tweet-box > div.tweet-txt > button")).click();
		        
		    } catch(NoSuchElementException m) {
		    	lr.logWrite("无法新建说说，尝试验证码");
	    		
		    	lr.logWrite("切换frame");
		        driver.switchTo().frame(1);
		        Thread.sleep(2000);
		        Actions ac = new Actions(driver);
		        lr.logWrite("点击滑块");
		        lr.logWrite(driver.findElement(By.id("title")).getText());
//		        if(!driver.findElement(By.id("title")).getText().equals("安全验证")) {
//		        	robot = true;
//		        }
			    ac.clickAndHold(driver.findElement(By.id("tcaptcha_drag_thumb"))).perform();
			    Thread.sleep(300);
			    Random rand = new Random();
//			    int max = rand.nextInt(10) + 170;
//			    int one = rand.nextInt();
			    for(int i = 0; i < 11; i++) {
			    	ac.moveByOffset(rand.nextInt(3) + 9, 1).perform();
			    }
			    for(int i = 0; i < 9; i++) {
			    	ac.moveByOffset(rand.nextInt(3) + 3, 1).perform();
			    }
			    for(int i = 0; i < 16; i++) {
			    	ac.moveByOffset(rand.nextInt(3) + 2, -1).perform();
			    }
			    for(int i = 0; i < 6; i++) {
			    	ac.moveByOffset(rand.nextInt(3) - 4, -1).perform();
			    }
			    ac.moveByOffset(-2, 0).perform();
			    ac.release().perform();
			    Thread.sleep(3000);
			    lr.logWrite("切换frame");
			    lr.logWrite("1");
		    	driver.switchTo().defaultContent();
		    	lr.logWrite("2");
		    	Thread.sleep(3000);
		    	lr.logWrite("3");
		    	lr.logWrite("点击新建说说");
		        driver.findElement(By.cssSelector("#page-feed > div.tweet-box > div.tweet-txt > button")).click();
		    } finally {
		    	Thread.sleep(3000);
		    	lr.logWrite("添加文字内容");
		        String[] shuo = createShuoshuo(all, start, end, date);
		        for(int i = 0; i < shuo.length; i++) {
		            driver.findElement(By.cssSelector("#form-0 > div.form-wrap > div.write-form.j-write > div.write-text.J_textareaWrapper > textarea")).sendKeys(shuo[i]);
		            Thread.sleep(5000);
		            lr.logWrite(shuo[i]);
		        }
		        
		        Thread.sleep(3000);
		        lr.logWrite("————");
		        driver.findElement(By.cssSelector("#form-0 > div.form-wrap > div.write-option > div > span.ui-switch")).click();
		        
		        Thread.sleep(3000);
		        lr.logWrite("添加图片：" + photo_url);
		        driver.findElement(By.id("addphoto")).sendKeys(photo_url);
		        lr.logWrite(photo_url);
		        Thread.sleep(20000);
		        lr.logWrite("点击发表");
		        driver.findElement(By.cssSelector("#form-0-submit > span")).click();
		        lr.logWrite("成功");
		        System.out.println("成功");
				Thread.sleep(20000);
		        flag = true;
		        driver.quit();
				lr.logClose();
		    }
	        
	        
		} catch(NoSuchElementException n) {
//			n.printStackTrace();
			lr.logWrite("失败，重试！");
			System.out.println("失败，重试！");
//			driver.close();
		} finally {
			Thread.sleep(10000);
		}
		}
	}
	
    public static void main(String[]args) throws InterruptedException{
//    	Shuoshuo s = new Shuoshuo();
//    	DownloadImage di = new DownloadImage();
//    	GetText g = new GetText();
//    	String[] all = g.getAll();
//    	Date d = new Date();
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////    	System.out.println(s.createShuoshuo(all, sdf.format(d)));
//    	s.sendShuoshuo(all, "", "", sdf.format(d), di.getPhotoUrl("/root/java/jar/shuoshuo/"));
    }
}