package com.stee.softserv.carhome.util;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtils {
        public static final int IMAGE_UNKNOWN = -1;
        public static final int IMAGE_JPEG = 0;
        public static final int IMAGE_PNG = 1;
        public static final int IMAGE_GIF = 2;

      
        /**
         * Resizes an image
         * 
         * @param imgName The image name to resize. Must be the complet path to the file
         * @param type int
         * @param maxWidth The image's max width
         * @param maxHeight The image's max height
         * @return A resized <code>BufferedImage</code>
         */
        public static BufferedImage resizeImage(String imgName, int type, int maxWidth, int maxHeight) throws IOException {
                try {
                        return resizeImage(ImageIO.read(new File(imgName)), type, maxWidth, maxHeight);
                } catch (IOException e) {
                        throw new IOException(e);
                }
        }

        /**
         * Resizes an image.
         * 
         * @param image
         *            The image to resize
         * @param maxWidth
         *            The image's max width
         * @param maxHeight
         *            The image's max height
         * @return A resized <code>BufferedImage</code>
         * @param type
         *            int
         */
        public static BufferedImage resizeImage(BufferedImage image, int type, int maxWidth, int maxHeight) {
                Dimension largestDimension = new Dimension(maxWidth, maxHeight);

                // Original size
                int imageWidth = image.getWidth(null);
                int imageHeight = image.getHeight(null);

                float aspectRation = (float) imageWidth / imageHeight;

                if (imageWidth > maxWidth || imageHeight > maxHeight) {
                        if ((float) largestDimension.width / largestDimension.height > aspectRation) {
                                largestDimension.width = (int) Math.ceil(largestDimension.height * aspectRation);
                        } else {
                                largestDimension.height = (int) Math.ceil(largestDimension.width / aspectRation);
                        }

                        imageWidth = largestDimension.width;
                        imageHeight = largestDimension.height;
                }

                return createHeadlessSmoothBufferedImage(image, type, imageWidth, imageHeight);
        }

        /**
         * Saves an image to the disk.
         * 
         * @param image  The image to save
         * @param toFileName The filename to use
         * @param type The image type. Use <code>ImageUtils.IMAGE_JPEG</code> to save as JPEG images,
         *  or <code>ImageUtils.IMAGE_PNG</code> to save as PNG.
         * @return <code>false</code> if no appropriate writer is found
         * @throws IOException 
         */
        public static boolean saveImage(BufferedImage image, String toFileName, int type) throws IOException {
                try {
                        return ImageIO.write(image, type == IMAGE_JPEG ? "jpg" : "png", new File(toFileName));
                } catch (IOException e) {
                        throw new IOException(e);
                }
        }

        /**
         * Compress and save an image to the disk. Currently this method only supports JPEG images.
         * 
         * @param image The image to save
         * @param toFileName The filename to use
         * @param type The image type. Use <code>ImageUtils.IMAGE_JPEG</code> to save as JPEG images,
         * or <code>ImageUtils.IMAGE_PNG</code> to save as PNG.
         * @throws IOException 
         */
        public static void saveCompressedImage(BufferedImage image, String toFileName, int type) throws IOException {
                try {
                        if (type == IMAGE_PNG)
                                throw new UnsupportedOperationException("PNG compression not implemented");

                        Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");
                        ImageWriter writer;
                        writer = iter.next();

                        ImageOutputStream ios = ImageIO.createImageOutputStream(new File(toFileName));
                        writer.setOutput(ios);

                        ImageWriteParam iwparam = new JPEGImageWriteParam(Locale.getDefault());

                        iwparam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                        iwparam.setCompressionQuality(0.7F);

                        writer.write(null, new IIOImage(image, null, null), iwparam);

                        ios.flush();
                        writer.dispose();
                        ios.close();
                } catch (IOException e) {
                        throw new IOException(e);
                }
        }

        /**
         * Creates a <code>BufferedImage</code> from an <code>Image</code>. This method can
         * function on a completely headless system. This especially includes Linux and Unix systems
         * that do not have the X11 libraries installed, which are required for the AWT subsystem to
         * operate. This method uses nearest neighbor approximation, so it's quite fast. Unfortunately,
         * the result is nowhere near as nice looking as the createHeadlessSmoothBufferedImage method.
         * 
         * @param image  The image to convert
         * @param w The desired image width
         * @param h The desired image height
         * @return The converted image
         * @param type int
         */
        public static BufferedImage createHeadlessBufferedImage(BufferedImage image, int type, int width, int height) {
                if (type == ImageUtils.IMAGE_PNG && hasAlpha(image)) {
                        type = BufferedImage.TYPE_INT_ARGB;
                } else {
                        type = BufferedImage.TYPE_INT_RGB;
                }

                BufferedImage bi = new BufferedImage(width, height, type);

                for (int y = 0; y < height; y++) {
                        for (int x = 0; x < width; x++) {
                                bi.setRGB(x, y, image.getRGB(x * image.getWidth() / width, y * image.getHeight() / height));
                        }
                }

                return bi;
        }

        /**
         * Creates a <code>BufferedImage</code> from an <code>Image</code>. This method can
         * function on a completely headless system. This especially includes Linux and Unix systems
         * that do not have the X11 libraries installed, which are required for the AWT subsystem to
         * operate. The resulting image will be smoothly scaled using bilinear filtering.
         * 
         * @param source The image to convert
         * @param w The desired image width
         * @param h The desired image height
         * @return The converted image
         * @param type  int
         */
        public static BufferedImage createHeadlessSmoothBufferedImage(BufferedImage source, int type, int width, int height) {
                if (type == ImageUtils.IMAGE_PNG && hasAlpha(source)) {
                        type = BufferedImage.TYPE_INT_ARGB;
                } else {
                        type = BufferedImage.TYPE_INT_RGB;
                }

                BufferedImage dest = new BufferedImage(width, height, type);

                int sourcex;
                int sourcey;

                double scalex = (double) width / source.getWidth();
                double scaley = (double) height / source.getHeight();

                int x1;
                int y1;

                double xdiff;
                double ydiff;

                int rgb;
                int rgb1;
                int rgb2;

                for (int y = 0; y < height; y++) {
                        sourcey = y * source.getHeight() / dest.getHeight();
                        ydiff = scale(y, scaley) - sourcey;

                        for (int x = 0; x < width; x++) {
                                sourcex = x * source.getWidth() / dest.getWidth();
                                xdiff = scale(x, scalex) - sourcex;

                                x1 = Math.min(source.getWidth() - 1, sourcex + 1);
                                y1 = Math.min(source.getHeight() - 1, sourcey + 1);

                                rgb1 = getRGBInterpolation(source.getRGB(sourcex, sourcey), source.getRGB(x1, sourcey), xdiff);
                                rgb2 = getRGBInterpolation(source.getRGB(sourcex, y1), source.getRGB(x1, y1), xdiff);

                                rgb = getRGBInterpolation(rgb1, rgb2, ydiff);

                                dest.setRGB(x, y, rgb);
                        }
                }

                return dest;
        }

        private static double scale(int point, double scale) {
                return point / scale;
        }

        private static int getRGBInterpolation(int value1, int value2, double distance) {
                int alpha1 = (value1 & 0xFF000000) >>> 24;
                int red1 = (value1 & 0x00FF0000) >> 16;
                int green1 = (value1 & 0x0000FF00) >> 8;
                int blue1 = (value1 & 0x000000FF);

                int alpha2 = (value2 & 0xFF000000) >>> 24;
                int red2 = (value2 & 0x00FF0000) >> 16;
                int green2 = (value2 & 0x0000FF00) >> 8;
                int blue2 = (value2 & 0x000000FF);

                int rgb = ((int) (alpha1 * (1.0 - distance) + alpha2 * distance) << 24)
                                | ((int) (red1 * (1.0 - distance) + red2 * distance) << 16)
                                | ((int) (green1 * (1.0 - distance) + green2 * distance) << 8)
                                | (int) (blue1 * (1.0 - distance) + blue2 * distance);

                return rgb;
        }

        /**
         * Determines if the image has transparent pixels.
         * 
         * @param image The image to check for transparent pixel.s
         * @return <code>true</code> of <code>false</code>, according to the result
         */
        public static boolean hasAlpha(Image image) {
                try {
                        PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
                        pg.grabPixels();

                        return pg.getColorModel().hasAlpha();
                } catch (InterruptedException e) {
                        return false;
                }
        }
 
        public static void convert(String source, String result) {
                try {
                        File f = new File(source);
                        f.canRead();
                        f.canWrite();
                        BufferedImage src = ImageIO.read(f);
                        ImageIO.write(src, "JPG", new File(result));
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
 
        public static void gray(String source, String result) {
                try {
                        BufferedImage src = ImageIO.read(new File(source));
                        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
                        ColorConvertOp op = new ColorConvertOp(cs, null);
                        src = op.filter(src, null);
                        ImageIO.write(src, "JPEG", new File(result));
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }//gray("c:/cc.jpg", "c:/cc2.jpg");

        /**
         * Reads an image from the disk as a BufferedImage - can be case as an Image
         *
         *@param filename the image to be read
         *@return the image object
         */
        public static BufferedImage readImage(String fileName) throws IOException {
                return readImage(new File(fileName));
        }

        public static BufferedImage readImage1(String filePath) {
                try {
                        File source = new File(filePath);
                        String formatName = FileUtils.getExtension(filePath);
                        ImageInputStream iis = ImageIO.createImageInputStream(source);
                        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(formatName);
                        final ImageReader reader = readers.next();
                        reader.setInput(iis, true);
                        final ImageReadParam param = reader.getDefaultReadParam();
                        param.setDestinationOffset(new Point(-200, -140));
                        BufferedImage bi = reader.read(0, param);
                        reader.dispose();
                        return bi;
                } catch (IOException ex) {
                        System.err.println("Failed to load image " + filePath);
                        return null;
                }
        }

        /**
  
         *        <pre>
         * BufferedImage image;
         * image = ImageUtils.readImage(new File(&quot;myImage.jpg&quot;));
         * image = ImageUtils.readImage(new File(&quot;myImage.gif&quot;));
         * image = ImageUtils.readImage(new File(&quot;myImage.bmp&quot;));
         * image = ImageUtils.readImage(new File(&quot;myImage.png&quot;));
         * </pre>
         */
        public static BufferedImage readImage(File file) {
                //image
                BufferedImage image = null;
                if (file != null && file.isFile() && file.exists()) {
                        try {
                                image = ImageIO.read(file);
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                // e.printStackTrace();
                        }
                }
                return image;
        }
 
        public static BufferedImage readImage(InputStream input) {
                BufferedImage image = null;
                if (input != null) {
                        try {
                                image = ImageIO.read(input);
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                // e.printStackTrace();
                        }
                }
                return image;
        }
 
        public static BufferedImage readImage(URL url) {
                BufferedImage image = null;
                if (url != null) {
                        try {
                                image = ImageIO.read(url);
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                // e.printStackTrace();
                        }
                }
                return image;
        }
 
        public static int getWidth(BufferedImage image) {
                return image.getWidth();
        }
 
        public static int getHeight(BufferedImage image) {
                return image.getHeight();
        }

     
        public static void writeImage(BufferedImage image, String formatName, File out) throws IOException {
                if (image != null && formatName != null && !"".equals(formatName) && out != null) {
                        ImageIO.write(image, formatName, out);
                }
        }

     
        public static void writeImage(BufferedImage image, String formatName, OutputStream out) throws IOException {
                if (image != null && formatName != null && !"".equals(formatName) && out != null) {
                        ImageIO.write(image, formatName, out);
                }
        }

        public static void reduceImg(String imgsrc, String imgdist, int widthdist, int heightdist) {
                try {
                        File srcfile = new File(imgsrc);
                        if (!srcfile.exists()) {
                                return;
                        }
                        Image src = javax.imageio.ImageIO.read(srcfile);

                        BufferedImage tag = new BufferedImage((int) widthdist, (int) heightdist, BufferedImage.TYPE_INT_RGB);

                        tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0, 0, null);
                        ///         tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist,  Image.SCALE_AREA_AVERAGING), 0, 0,  null);   

                        FileOutputStream out = new FileOutputStream(imgdist);
                        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                        encoder.encode(tag);
                        out.close();

                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }

        
        public static BufferedImage resize(BufferedImage source, int targetW, int targetH) {
                
                int type = source.getType();
                BufferedImage target = null;
                double sx = (double) targetW / source.getWidth();
                double sy = (double) targetH / source.getHeight();
               
                if (sx < sy) {
                        sx = sy;
                        targetW = (int) (sx * source.getWidth());
                } else {
                        sy = sx;
                        targetH = (int) (sy * source.getHeight());
                }
                if (type == BufferedImage.TYPE_CUSTOM) { // handmade    
                        ColorModel cm = source.getColorModel();
                        WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
                        boolean alphaPremultiplied = cm.isAlphaPremultiplied();
                        target = new BufferedImage(cm, raster, alphaPremultiplied, null);
                } else
                        target = new BufferedImage(targetW, targetH, type);
                Graphics2D g = target.createGraphics();
                // smoother than exlax:    
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
                g.dispose();
                return target;
        }
 
    public static void saveImageAsJpg(String inFilePath, String outFilePath,    
            int width, int hight, boolean proportion)throws Exception {    
         File file = new File(inFilePath);    
         InputStream in = new FileInputStream(file);    
         File saveFile = new File(outFilePath);    
   
        BufferedImage srcImage = ImageIO.read(in);    
        if (width > 0 || hight > 0) {    
        
            int sw = srcImage.getWidth();    
            int sh = srcImage.getHeight();    
          
            if (sw > width && sh > hight) {    
                srcImage = resize(srcImage, width, hight);    
            } else {    
                String fileName = saveFile.getName();    
                String formatName = fileName.substring(fileName    
                        .lastIndexOf('.') + 1);    
                ImageIO.write(srcImage, formatName, saveFile);    
                return;    
            }    
        }    
 
        int w = srcImage.getWidth();    
        int h = srcImage.getHeight();    
      
        if (w == width) {    
           
            int x = 0;    
            int y = h / 2 - hight / 2;    
            saveSubImage(srcImage, new Rectangle(x, y, width, hight), saveFile);    
        }    
        
        else if (h == hight) {    
 
            int x = w / 2 - width / 2;    
            int y = 0;    
            saveSubImage(srcImage, new Rectangle(x, y, width, hight), saveFile);    
        }    
        in.close();    
    }    
    
    private static void saveSubImage(BufferedImage image,    
            Rectangle subImageBounds, File subImageFile) throws IOException {    
        if (subImageBounds.x < 0 || subImageBounds.y < 0   
                || subImageBounds.width - subImageBounds.x > image.getWidth()    
                || subImageBounds.height - subImageBounds.y > image.getHeight()) {    
            System.out.println("Bad   subimage   bounds");    
            return;    
        }    
        BufferedImage subImage = image.getSubimage(subImageBounds.x,subImageBounds.y, subImageBounds.width, subImageBounds.height);    
        String fileName = subImageFile.getName();    
        String formatName = fileName.substring(fileName.lastIndexOf('.') + 1);    
        ImageIO.write(subImage, formatName, subImageFile);    
    }    

        public static void main(String[] args) throws IOException {
                reduceImg("d:/1.jpg", "d:/1.jpg", 65, 65);
               // writeImage(readImage1("c:/bb.jpg"), "jpeg", new File("c:/sf.jpg"));
        }
}