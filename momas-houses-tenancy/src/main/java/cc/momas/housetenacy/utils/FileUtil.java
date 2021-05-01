package cc.momas.housetenacy.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.io.FileUtils;

public class FileUtil {
	private static final int SMALL_WIDTH = 100;
	private static final int SMALL_HEIGHT = 75;

	public static String uploadFile(File srcFile, String extName, String dir){
		String filename = System.currentTimeMillis() + extName;
		File descFile = new File(dir, filename);
		try {
			FileUtils.copyFile(srcFile, descFile);
			copySmallPic(descFile, SMALL_WIDTH, SMALL_HEIGHT, "small_" + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filename;
	}

	private static void copySmallPic(File descFile, int width, int height, String smallFileName) {
		ImageIcon ii = new ImageIcon(descFile.getAbsolutePath());
		Image image = ii.getImage();
		
		BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = buf.getGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		
		File targetSmallFile = new File(descFile.getParent(),smallFileName);
		try {
			ImageIO.write(buf, "png", targetSmallFile);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			buf.flush();
		}
		
		
	}
}
