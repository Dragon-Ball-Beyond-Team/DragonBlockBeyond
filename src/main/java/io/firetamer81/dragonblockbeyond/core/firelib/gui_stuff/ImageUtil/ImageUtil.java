package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.ImageUtil;

import com.mojang.blaze3d.platform.NativeImage;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class ImageUtil {
    public ImageUtil() {
    }

    public static BufferedImage scaleImage(BufferedImage img, int width, int height) {
        int w = img.getWidth();
        int h = img.getHeight();

        return w == width && h == height ?
                img :
                ImageScalr.resize(
                        img,
                        ImageScalr.Method.AUTOMATIC,
                        ImageScalr.Mode.FIT_EXACT,
                        width,
                        height,
                        new BufferedImageOp[0]
                );
    }

    public static BufferedImage scaleImageKeepAspectRatio(BufferedImage img, int width, int height) {
        int w = img.getWidth();
        int h = img.getHeight();
        if (w == width && h == height) {
            return img;
        } else {
            Dimension scaled = getScaledDimension(new Dimension(w, h), new Dimension(width, height));
            int newWidth = (int)scaled.getWidth();
            int newHeight = (int)scaled.getHeight();
            return ImageScalr.resize(img, ImageScalr.Method.AUTOMATIC, ImageScalr.Mode.AUTOMATIC, newWidth, newHeight, new BufferedImageOp[0]);
        }
    }

    private static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {
        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        if (original_width > bound_width) {
            new_width = bound_width;
            new_height = bound_width * original_height / original_width;
        }

        if (new_height > bound_height) {
            new_height = bound_height;
            new_width = bound_height * original_width / original_height;
        }

        return new Dimension(new_width, new_height);
    }

    private static byte[] toByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];

        int len;
        while((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        byte[] out = os.toByteArray();
        os.close();
        is.close();
        return out;
    }

    public static ByteArrayInputStream getInputStreamFromImageURL(String url) throws IOException {
        HttpURLConnection httpcon = (HttpURLConnection)(new URL(url)).openConnection();
        httpcon.addRequestProperty("User-Agent", "Minecraft");
        ByteArrayInputStream is = convertToByteArrayIS(httpcon.getInputStream());
        httpcon.disconnect();
        return is;
    }

    public static ByteArrayInputStream convertToByteArrayIS(InputStream is) throws IOException {
        return new ByteArrayInputStream(toByteArray(is));
    }

    public static NativeImage getImageFromIS(ByteArrayInputStream is, boolean keepAspectRatio, int width, int height, boolean resizingImage) throws IOException {
        BufferedImage img = ImageIO.read(is);
        is.reset();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if (img.getWidth() <= width && img.getHeight() <= height && !resizingImage) {
            ImageIO.write(img, "png", os);
        } else if (keepAspectRatio) {
            ImageIO.write(scaleImageKeepAspectRatio(img, width, height), "png", os);
        } else {
            ImageIO.write(scaleImage(img, width, height), "png", os);
        }

        ByteArrayInputStream is2 = new ByteArrayInputStream(os.toByteArray());
        NativeImage imgo = NativeImage.read(is2);
        is2.close();
        is.reset();
        return imgo;
    }

    public static boolean isISGif(ByteArrayInputStream is) throws IOException {
        ImageInputStream iis = ImageIO.createImageInputStream(is);
        Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);

        while(imageReaders.hasNext()) {
            ImageReader reader = (ImageReader)imageReaders.next();
            if (reader.getFormatName().endsWith("gif")) {
                iis.close();
                reader.dispose();
                return true;
            }

            reader.dispose();
        }

        iis.close();
        is.reset();
        return false;
    }
}
