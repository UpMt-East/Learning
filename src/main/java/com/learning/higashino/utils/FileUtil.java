package com.learning.higashino.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Fileユーティリティ
 */
public class FileUtil {

    /**
     * Fileオブジェクトのバイナリーコードを取得する
     *
     * @param file MultipartFileオブジェクト
     * @return Fileバイナリーコード
     * @throws IOException 変換エラー
     */
    public static String getBinaryCode(MultipartFile file) throws IOException {
        StringBuffer binaryItemImage = new StringBuffer();
        String base64 = new String(Base64.encodeBase64(file.getBytes()), StandardCharsets.US_ASCII);
        binaryItemImage.append("data:image/jpeg;base64,");
        binaryItemImage.append(base64);
        return String.valueOf(binaryItemImage);
    }
}
