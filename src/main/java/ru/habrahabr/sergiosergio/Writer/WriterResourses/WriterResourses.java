package ru.habrahabr.sergiosergio.Writer.WriterResourses;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.habrahabr.sergiosergio.Buffer;

@Service("writeresourses")
public class WriterResourses {
	
	@Autowired
	Buffer buffer;
	Connection connection;
	CopyManager copyManager = null;
	
	public WriterResourses() {
		
		try {
			copyManager = new CopyManager((BaseConnection)connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public CopyManager getCopyManager() {
		return copyManager;
	}

	public void setCopyManager(CopyManager copyManager) {
		this.copyManager = copyManager;
	}
	
	  
	
}	
