package com.ht.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageUtils {
	public static void pressText(String targetImg) {
		try {
			File img = new File(targetImg);
			Image src = ImageIO.read(img);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			int fontSize = width / 15;
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(Color.blue);
			g.setFont(new Font("黑体", Font.BOLD, fontSize));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.4f));
			g.rotate(25 * Math.PI / 180);
			String pressText1 = "仅用于中国海关";
			String pressText2 = "个人物品入境清关使用";
			int x = (int) ((width - (getLength(pressText1) * fontSize * (25 * Math.PI / 180))) / 2) + fontSize / 2;
			int y = -30;
			int x2 = (int) ((width - (getLength(pressText2) * fontSize * (25 * Math.PI / 180))) / 2 - fontSize / 2);
			g.drawString(pressText1, x, y);
			g.drawString(pressText2, x2, y + fontSize);
			g.dispose();
			ImageIO.write((BufferedImage) image, "jpg", img);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getLength(String text) {
		int length = 0;
		for (int i = 0; i < text.length(); i++) {
			if (new String(text.charAt(i) + "").getBytes().length > 1) {
				length += 2;
			} else {
				length += 1;
			}
		}
		return length / 2;
	}
}
