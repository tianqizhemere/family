package utils;

/**
 * @Author: wukh
 * @Date: 2020/6/28 18:00
 */
public enum ResultStatusCode {
    Success("0", "Success"),
    UserNotExist("1", "User not exist"),
    InValidParameter("2", "Invalid parameter"),
    DataFormatException("4", "数据格式不正确"),
    DataNotExistException("5", "DataNotExistException"),
    TimeFormatException("6", "TimeFormat Exception"),
    PictureFormatException("7", "PictureFormat Exception"),
    IllegalArgumentException("8", "数据格式不正确"),
    TokenInvalidOrOverdueException("9", "Token invalid or overdue exception"),
    AuthorizationCodeError("10", "authorization code error"),
    WrongSignatureException("11", "Wrong Signature Exception"),
    SystemException("50", "系统错误"),
    MissingServletRequestParameter("400", "请求参数不全"),
    TypeMismatchException("401", "请求参数类型不正确"),
    RequestMethodNotAllowed("405", "http请求的方法不正确"),
    ;

    private String code;
    private String msg;

    private ResultStatusCode(String code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
    public String getCode(){
        return this.code;
    }
}

