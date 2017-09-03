package ru.habrahabr.sergiosergio.Writer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.habrahabr.sergiosergio.Buffer;
@Component
public class StringsInputStream extends InputStream{

	private Buffer buf;
	private byte[] bytearray;

	public String string;
	private int i;
	private int k;
	private boolean emptyBuf = false;
	
	@Autowired
	public StringsInputStream(Buffer buf) {

		this.buf = buf;

	}

	@Override
	public int read() {

		if (bytearray == null) {

			emptyBuf = getNextString();

		}
		if (emptyBuf) {
			return -1;
		}

		if (i == bytearray.length) {

			while (emptyBuf && !buf.endingFlag) {

			}
			emptyBuf = getNextString();

		}

		if (emptyBuf) {
			return -1;
		}
		i++;
		return bytearray[i - 1];

	}

	@Override
	public int read(byte[] b) throws IOException {

		if (bytearray == null) {

			emptyBuf = getNextString();

		}
		if (emptyBuf) {
			return -1;
		}
		k = 0;
		if (b.length >= bytearray.length - i) {
			while (i < bytearray.length) {

				b[k] = bytearray[i];
				i++;
				k++;
			}

			emptyBuf = getNextString();
			if (emptyBuf) {
				bytearray = null;
			}

			return k;
		}

		int j = 0;

		while (j < b.length) {

			b[j] = bytearray[i];
			i++;
			j++;
		}
		return j;

	}

	public int aviable() {
		if (bytearray == null) {

			emptyBuf = getNextString();

		}

		return bytearray.length - i;
	}

	private boolean getNextString() {

		bytearray = null;
		while (buf.buf.isEmpty() && !buf.endingFlag) {

		}
		if (buf.buf.isEmpty() && buf.endingFlag) {

			return true;
		} else {

			try {
				bytearray = buf.buf.take().getBytes(StandardCharsets.UTF_8);
			} catch (InterruptedException e) {
				System.err.println("Не удалось прочитать данные из буфера.");
				e.printStackTrace();

			}
			i = 0;
			return false;
		}

	}

}
