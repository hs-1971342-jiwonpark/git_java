package ch20.oracle.sec09.exam01;

import java.sql.Blob;
import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwrite;
	private Date bdate;
	private String bfileName;
	private Blob bfiledata;
}
