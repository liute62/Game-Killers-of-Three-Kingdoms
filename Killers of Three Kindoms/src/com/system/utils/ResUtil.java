package com.system.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResUtil {

	/**
	 * 
	 * @param name the name of img
	 * @param  type the type of img 0:jpg 1:png
	 * @return
	 */
	public static BufferedImage getImgByName(String name,int type){
		BufferedImage img = null;
		try {
			switch (type) {
				case 0:
					img = ImageIO.read(ClassLoader.getSystemResourceAsStream("res"+"/"+name+".jpg"));		
				    break;
				case 1:
					img = ImageIO.read(ClassLoader.getSystemResourceAsStream("res"+"/"+name+".png"));
					break;
				default:
					System.err.println("ResUtil getImgByName input type error!");
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
