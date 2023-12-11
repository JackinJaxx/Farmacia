package com.klmj.ridi_api.pdf;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {

    public static InputStream openImage(String imagePath) throws IOException {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(imagePath);
    }

    public static void closeImage(InputStream inputStream) {
        close(inputStream);
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
                // Manejar la excepción según tus necesidades
            }
        }
    }
}
