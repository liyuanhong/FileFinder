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
* ����JCharDet��ȡ�ļ��ַ���
* 
* @author icer PS: JCharDet ��mozilla�Զ��ַ���̽���㷨�����java��ֲ����ٷ���ҳΪ��
*         http://jchardet.sourceforge.net/
* @date 2008/11/13
*/
public class FileCharsetDetector {

	private static boolean found = false;

	/**
	 * �����ȫƥ��ĳ���ַ�������㷨, ������Ա�����ַ���������. ����(��������ļ�)��ֵ��ΪĬ��ֵ null, ��ʱӦ����ѯ����
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
				// ��û�з�������£���ȡ��һ�����ܵı���
				encoding = prob[0];
			} else {
				return null;
			}
		}
		return encoding;
	}
}
