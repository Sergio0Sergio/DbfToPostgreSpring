package ru.habrahabr.sergiosergio.Writer;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.habrahabr.sergiosergio.Writer.WriterResourses.WriterResourses;

@Service("writer")
public class Writer extends Thread {
	
	private WriterResourses resourses;
	
	@Autowired
	public Writer(WriterResourses resourses) {
		this.resourses = resourses;
	}
	
	@Override
	public void run() {

		try {
			System.out.println("Начало записи в базу. Дождитесь окончания работы программы.");
			resourses.copyManager.copyIn("COPY \"" + tableName + "\"(" + sqlVariables + ")FROM STDIN WITH (FORMAT CSV, DELIMITER ',', HEADER FALSE, QUOTE '\"', ESCAPE '\"', ENCODING 'UTF-8');", inputStream);
		} catch (SQLException e) {
			System.err.println("Ошибка записи в базу.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Ошибка записи в базу.");
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Ошибка закрытия базы.");
			e.printStackTrace();
		}

		System.out.println("Запись завершена.");
		System.out.println("Работа программы завершена успешно.");

	}


}
