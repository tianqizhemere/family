package utils;

/**
 * @Author: wukh
 * @Date: 2020/6/28 18:00
 */
public enum ResultStatusCode {
    Success("0", "操作成功"),
    UserNotExist("1", "用户名不存在"),
    InValidParameter("2", "Invalid parameter"),
    DataFormatException("4", "数据格式不正确"),
    DataNotExistException("5", "数据不存在"),
    TimeFormatException("6", "时间格式不正确"),
    PictureFormatException("7", "PictureFormat Exception"),
    IllegalArgumentException("8", "不合法的参数"),
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

