package com.lyh.jchardet;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mozilla.intl.chardet.nsDetector;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;

/**
* 借助JCharDet获取文件字符集
* 
* @author icer PS: JCharDet 是mozilla自动字符集探测算法代码的java移植，其官方主页为：
*         http://jchardet.sourceforge.net/
* @date 2008/11/13
*/
public class FileCharsetDetector {

	private static boolean found = false;

	/**
	 * 如果完全匹配某个字符集检测算法, 则该属性保存该字符集的名称. 否则(如二进制文件)其值就为默认值 null, 这时应当查询属性
	 */
	private static String encoding = null;

	public static String guestFileEncoding(File file) throws FileNotFoundException,
			IOException {
		return guestFileEncoding(file, new nsDetector());
	}

	public String guestFileEncoding(File file, int languageHint)
			throws FileNotFoundException, IOException {
		return guestFileEncoding(file, new nsDetector(languageHint));
	}

	public String guestFileEncoding(String path) throws FileNotFoundException,
			IOException {
		return guestFileEncoding(new File(path));
	}

	public String guestFileEncoding(String path, int languageHint)
			throws FileNotFoundException, IOException {
		return guestFileEncoding(new File(path), languageHint);
	}

	private static String guestFileEncoding(File file, nsDetector det)
			throws FileNotFoundException, IOException {
		det.Init(new nsICharsetDetectionObserver() {
			public void Notify(String charset) {
				found = true;
				encoding = charset;
			}
		});

		BufferedInputStream imp = new BufferedInputStream(new FileInputStream(
				file));

		byte[] buf = new byte[1024];
		int len;
		boolean done = false;
		boolean isAscii = true;

		while ((len = imp.read(buf, 0, buf.length)) != -1) {
			// Check if the stream is only ascii.
			if (isAscii)
				isAscii = det.isAscii(buf, len);

			// DoIt if non-ascii and not done yet.
			if (!isAscii && !done)
				done = det.DoIt(buf, len, false);
		}
		det.DataEnd();

		if (isAscii) {
			encoding = "ASCII";
			found = true;
		}

		if (!found) {
			String prob[] = det.getProbableCharsets();
			if (prob.length > 0) {
				// 在没有发现情况下，则取第一个可能的编码
				encoding = prob[0];
			} else {
				return null;
			}
		}
		return encoding;
	}
}
