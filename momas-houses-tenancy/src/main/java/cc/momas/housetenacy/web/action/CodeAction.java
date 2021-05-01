package cc.momas.housetenacy.web.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

public class CodeAction {
	// private String code;
	private InputStream is;

	public String code() {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 用来添加到图片里的字母们,可以自己添加字符
		String code = "";
		int width = 60;
		int height = 30;
		BufferedImage buf = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = buf.getGraphics(); // 构造画笔
		g.setColor(getColor(160, 250));// 在这里设置颜色
		g.fillRect(0, 0, width, height); // 根据颜色填充矩形
		// 写字符
		Random random = new Random();
		for (int i = 0; i < 4; i++) {// 这个4是验证码的字母个数
			int index = random.nextInt(str.length());
			// 1.设置颜色
			g.setColor(getColor(50, 120));
			g.setFont(new Font("黑体", Font.BOLD, 16));//设置字体样式
			// 2.写字符
			g.drawString(str.charAt(index) + "", 6 + 13 * i, 20);
			code += str.charAt(index);// 把验证码的字符保存起来
		}
		ServletActionContext.getContext().getSession().put("VALIDATE_CODE", code);

		// 画干扰线
		for (int i = 0; i < 80; i++) {// 干扰线条数
			// 在画布范围内随机获取数字
			int x = random.nextInt(width);// x坐标
			int y = random.nextInt(height);// y坐标
			g.setColor(getColor(160, 200));// 1.设置颜色
			g.drawLine(x, y, x + random.nextInt(6), y + random.nextInt(6));// 画直线，6为干扰线的长度
		}

		g.dispose(); // 销毁画笔
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			ImageIO.write(buf, "png", baos);
			is = new ByteArrayInputStream(baos.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			buf.flush();
		}

		return "success";
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	/**
	 * 用来获取一个颜色
	 * 
	 * @param min
	 *            RGB最小值
	 * @param max
	 *            RGB最大值
	 * @return 一个给定范围内的随机颜色
	 */
	private Color getColor(int min, int max) {
		Random random = new Random();
		// random.nextInt(int n ); --n是一个范围,从0到n
		int red = min + random.nextInt(max - min);
		int green = min + random.nextInt(max - min);
		int blue = min + random.nextInt(max - min);

		return new Color(red, green, blue);
	}

}
