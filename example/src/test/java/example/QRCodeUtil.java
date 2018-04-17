package example;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

/**
 * 
 * 二维码工具类
 * 
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class QRCodeUtil {

	private static final Logger log = LoggerFactory.getLogger(QRCodeUtil.class);

	/**
	 * 
	 * 生成二维码文件测试
	 * 
	 * @param filePath
	 *            文件路径
	 * @param fileName
	 *            文件名
	 * @param number
	 *            编号
	 * @param phone
	 *            手机号
	 * @see [类、类#方法、类#成员]
	 */
	public static void generatEncodeTest(String filePath, String fileName, String number, String phone) {

		int width = 200; // 图像宽度
		int height = 200; // 图像高度
		String format = "png";// 图像类型

		JSONObject json = new JSONObject();
		json.put("number", number);
		json.put("phone", phone);
		String content = json.toJSONString();// 内容

		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
			String path = FileSystems.getDefault().getPath(filePath, fileName).toString();
			File file = new File(path);
			MatrixToImageWriter.writeToFile(bitMatrix, format, file);// 输出图像
			System.out.println("二维码输出成功");
			System.out.println("图片地址：" + filePath + fileName);
			System.out.println("---------------------------");
		} catch (WriterException e) {
			e.printStackTrace();
			System.out.println("二维码输出异常");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("二维码输出异常");
		}
	}

	/**
	 * 
	 * 解析二维码内容测试
	 * 
	 * @param filePath
	 *            二维码绝对路径
	 * @see [类、类#方法、类#成员]
	 */
	public static void parseDecodeTest(String filePath) {
		BufferedImage image;
		try {
			image = ImageIO.read(new File(filePath));
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");

			Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
			JSONObject content = JSONObject.parseObject(result.getText());

			StringBuffer sb = new StringBuffer();
			sb.append("编号：").append(content.getString("number")).append("\r\n").append("手机号码:")
					.append(content.getString("phone"));
			String returnText = sb.toString();
			System.out.println(returnText);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 生成二维码输出流 在jsp页面中直接展示时使用 无须保存 即生成即展示
	 * 
	 * @param response
	 * @param number
	 *            编号
	 * @param phone
	 *            手机号
	 * @see [类、类#方法、类#成员]
	 */
	public static void generatEncode(HttpServletResponse response, String number, String phone) {
		JSONObject json = new JSONObject();
		json.put("number", number);
		json.put("phone", phone);
		String content = json.toJSONString();// 内容

		int width = 200; // 图像宽度
		int height = 200; // 图像高度
		String format = "png";// 图像类型

		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

		try {

			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
			MatrixToImageWriter.writeToStream(bitMatrix, format, response.getOutputStream());// 输出图像
			log.info("二维码输出成功");
		} catch (WriterException e) {
			e.printStackTrace();
			log.error("二维码输出异常");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("二维码输出异常");
		}
	}

	public static void main(String[] args) {
		generatEncodeTest("D:\\", "zxing.png", "001", "13019931996");
		parseDecodeTest("D:\\zxing.png");
	}
}
