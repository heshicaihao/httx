package com.ht.util;


public interface Const {

	static final String WEB_USER="loginUser";
	static final String WEB_ACCOUNT="loginAccount";
	
	static final int LOGIN_VERIFY = 3;
	static final int LOGIN_UP=2;
	static final int LOGIN_PASS = 1;
	static final int LOGIN_INACTIVE=4;
	
	static final int EXIST = 1;
	static final int UI_SUCCESS = 0;
	static final int UI_ERROR = 2;
	
	static final short USERTYPE_CUSTOMER=3;
	static final int USERTYPE_EMP=2;
	static final int USERTYPE_ADMIN=1;
	
	static final short USERSTATUS_ACTIVE=1;
	
	/** Parameter name for the message */
	public static final String BARCODE_MSG = "msg";
	/** Parameter name for the barcode type */
	public static final String BARCODE_TYPE = "type";
	/** Parameter name for the barcode height */
	public static final String BARCODE_HEIGHT = "height";
	/** Parameter name for the module width */
	public static final String BARCODE_MODULE_WIDTH = "mw";
	/** Parameter name for the wide factor */
	public static final String BARCODE_WIDE_FACTOR = "wf";
	/** Parameter name for the quiet zone */
	public static final String BARCODE_QUIET_ZONE = "qz";
	/** Parameter name for the human-readable placement */
	public static final String BARCODE_HUMAN_READABLE_POS = "hrp";
	/** Parameter name for the output format */
	public static final String BARCODE_FORMAT = "fmt";
	/** Parameter name for the image resolution (for bitmaps) */
	public static final String BARCODE_IMAGE_RESOLUTION = "res";
	/** Parameter name for the grayscale or b/w image (for bitmaps) */
	public static final String BARCODE_IMAGE_GRAYSCALE = "gray";
	/** Parameter name for the font size of the human readable display */
	public static final String BARCODE_HUMAN_READABLE_SIZE = "hrsize";
	/** Parameter name for the font name of the human readable display */
	public static final String BARCODE_HUMAN_READABLE_FONT = "hrfont";
	/** Parameter name for the pattern to format the human readable message */
	public static final String BARCODE_HUMAN_READABLE_PATTERN = "hrpattern";
}
