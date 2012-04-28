package com.stee.softserv.carhome.util;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageCut {
        /**
    *
    * 裁剪
    *
    * @param image
    *            原图
    * @param x
    *            起点坐标x
    * @param y
    *            起点坐标y
    * @param destWidth
    *            裁剪后宽度
    * @param destHeight
    *            裁剪后高度
    * @return
    */
   public static BufferedImage cut(BufferedImage image, int x, int y,
                   int destWidth, int destHeight) {

           // 裁剪图像
           ImageFilter cropFilter = new CropImageFilter(x, y, destWidth,
                           destHeight);
           Image destImage = Toolkit.getDefaultToolkit().createImage(
                           new FilteredImageSource(image.getSource(), cropFilter));

           // 将destImage转换为bufferedImage
           BufferedImage dstBufferedImage = new BufferedImage(destWidth,
                           destHeight, BufferedImage.TYPE_INT_RGB);
           Graphics2D biContext = dstBufferedImage.createGraphics();
           biContext.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_ON);
           biContext.drawImage(destImage, 0, 0, null);

           return dstBufferedImage;
   }
   public static void cutOne(String srcImageFile, String descDir, int destWidth,
           int destHeight, int x, int y) {

       try {
           Image img;
           ImageFilter cropFilter;
           // 读取源图像
           BufferedImage bi = ImageIO.read(new File(srcImageFile));
           int srcWidth = bi.getHeight(); // 源图宽度
           int srcHeight = bi.getWidth(); // 源图高度
           if (srcWidth > destWidth && srcHeight > destHeight) {
               Image image = bi.getScaledInstance(srcWidth, srcHeight,
                       Image.SCALE_SMOOTH);
               destWidth = 200; // 切片宽度
               destHeight = 150; // 切片高度

               // 四个参数分别为图像起点坐标和宽高
               // 即: CropImageFilter(int x,int y,int width,int height)
               cropFilter = new CropImageFilter(x, y,
                       destWidth, destHeight);
               img = Toolkit.getDefaultToolkit().createImage(
                       new FilteredImageSource(image.getSource(),
                       cropFilter));
               BufferedImage tag = new BufferedImage(destWidth,
                       destHeight, BufferedImage.TYPE_INT_RGB);
               Graphics g = tag.getGraphics();
               g.drawImage(img, 0, 0, null); // 绘制缩小后的图
               g.dispose();
               // 输出为文件
               ImageIO.write(tag, "JPEG", new File(descDir + ".jpg"));

           }
       } catch (Exception e) {
           e.printStackTrace();
       }

   }
        /**
         * 图像切割
         *
         * @param srcImageFile
         *            源图像地址
         * @param descDir
         *            切片目标文件夹
         * @param destWidth
         *            目标切片宽度
         * @param destHeight
         *            目标切片高度
         */
        public static void cut(String srcImageFile, String descDir, int destWidth, int destHeight) {
                try {
                        Image img;
                        ImageFilter cropFilter;
                        // 读取源图像
                        BufferedImage bi = ImageIO.read(new File(srcImageFile));
                        int srcWidth = bi.getHeight(); // 源图宽度
                        int srcHeight = bi.getWidth(); // 源图高度
                        if (srcWidth > destWidth && srcHeight > destHeight) {
                                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
                                destWidth = 200; // 切片宽度
                                destHeight = 150; // 切片高度
                                int cols = 0; // 切片横向数量
                                int rows = 0; // 切片纵向数量
                                // 计算切片的横向和纵向数量
                                if (srcWidth % destWidth == 0) {
                                        cols = srcWidth / destWidth;
                                } else {
                                        cols = (int) Math.floor(srcWidth / destWidth) + 1;
                                }
                                if (srcHeight % destHeight == 0) {
                                        rows = srcHeight / destHeight;
                                } else {
                                        rows = (int) Math.floor(srcHeight / destHeight) + 1;
                                }
                                // 循环建立切片
                                // 改进的想法:是否可用多线程加快切割速度
                                for (int i = 0; i < rows; i++) {
                                        for (int j = 0; j < cols; j++) {
                                                // 四个参数分别为图像起点坐标和宽高
                                                // 即: CropImageFilter(int x,int y,int width,int height)
                                                cropFilter = new CropImageFilter(j * 200, i * 150, destWidth, destHeight);
                                                img = Toolkit.getDefaultToolkit().createImage(
                                                                new FilteredImageSource(image.getSource(), cropFilter));
                                                BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
                                                Graphics g = tag.getGraphics();
                                                g.drawImage(img, 0, 0, null); // 绘制缩小后的图
                                                g.dispose();
                                                // 输出为文件
                                                ImageIO.write(tag, "JPEG", new File(descDir + "pre_map_" + i + "_" + j + ".jpg"));
                                        }
                                }
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
   public static void main(String[] args) {
	   cut("d:/1.jpg", "d:/",50,50);
   }

}