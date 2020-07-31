package exception;

import java.io.Serializable;

/**
 * 自定义异常
 * <p>导入Excel错误异常</p>
 * @Author wkh
 * @Date 2020/7/30 14:37
 */
public class InputExcelException extends Exception implements Serializable {

    private static final long serialVersionUID = -4920988739438735540L;

    private String message;

    public InputExcelException(){
        super();
    }

    public InputExcelException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
