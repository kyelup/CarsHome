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
    * �ü�
    *
    * @param image
    *            ԭͼ
    * @param x
    *            �������x
    * @param y
    *            �������y
    * @param destWidth
    *            �ü�����
    * @param destHeight
    *            �ü���߶�
    * @return
    */
   public static BufferedImage cut(BufferedImage image, int x, int y,
                   int destWidth, int destHeight) {

           // �ü�ͼ��
           ImageFilter cropFilter = new CropImageFilter(x, y, destWidth,
                           destHeight);
           Image destImage = Toolkit.getDefaultToolkit().createImage(
                           new FilteredImageSource(image.getSource(), cropFilter));

           // ��destImageת��ΪbufferedImage
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
           // ��ȡԴͼ��
           BufferedImage bi = ImageIO.read(new File(srcImageFile));
           int srcWidth = bi.getHeight(); // Դͼ���
           int srcHeight = bi.getWidth(); // Դͼ�߶�
           if (srcWidth > destWidth && srcHeight > destHeight) {
               Image image = bi.getScaledInstance(srcWidth, srcHeight,
                       Image.SCALE_SMOOTH);
               destWidth = 200; // ��Ƭ���
               destHeight = 150; // ��Ƭ�߶�

               // �ĸ������ֱ�Ϊͼ���������Ϳ��
               // ��: CropImageFilter(int x,int y,int width,int height)
               cropFilter = new CropImageFilter(x, y,
                       destWidth, destHeight);
               img = Toolkit.getDefaultToolkit().createImage(
                       new FilteredImageSource(image.getSource(),
                       cropFilter));
               BufferedImage tag = new BufferedImage(destWidth,
                       destHeight, BufferedImage.TYPE_INT_RGB);
               Graphics g = tag.getGraphics();
               g.drawImage(img, 0, 0, null); // ������С���ͼ
               g.dispose();
               // ���Ϊ�ļ�
               ImageIO.write(tag, "JPEG", new File(descDir + ".jpg"));

           }
       } catch (Exception e) {
           e.printStackTrace();
       }

   }
        /**
         * ͼ���и�
         *
         * @param srcImageFile
         *            Դͼ���ַ
         * @param descDir
         *            ��ƬĿ���ļ���
         * @param destWidth
         *            Ŀ����Ƭ���
         * @param destHeight
         *            Ŀ����Ƭ�߶�
         */
        public static void cut(String srcImageFile, String descDir, int destWidth, int destHeight) {
                try {
                        Image img;
                        ImageFilter cropFilter;
                        // ��ȡԴͼ��
                        BufferedImage bi = ImageIO.read(new File(srcImageFile));
                        int srcWidth = bi.getHeight(); // Դͼ���
                        int srcHeight = bi.getWidth(); // Դͼ�߶�
                        if (srcWidth > destWidth && srcHeight > destHeight) {
                                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
                                destWidth = 200; // ��Ƭ���
                                destHeight = 150; // ��Ƭ�߶�
                                int cols = 0; // ��Ƭ��������
                                int rows = 0; // ��Ƭ��������
                                // ������Ƭ�ĺ������������
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
                                // ѭ��������Ƭ
                                // �Ľ����뷨:�Ƿ���ö��̼߳ӿ��и��ٶ�
                                for (int i = 0; i < rows; i++) {
                                        for (int j = 0; j < cols; j++) {
                                                // �ĸ������ֱ�Ϊͼ���������Ϳ��
                                                // ��: CropImageFilter(int x,int y,int width,int height)
                                                cropFilter = new CropImageFilter(j * 200, i * 150, destWidth, destHeight);
                                                img = Toolkit.getDefaultToolkit().createImage(
                                                                new FilteredImageSource(image.getSource(), cropFilter));
                                                BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
                                                Graphics g = tag.getGraphics();
                                                g.drawImage(img, 0, 0, null); // ������С���ͼ
                                                g.dispose();
                                                // ���Ϊ�ļ�
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