package app.naratech.com.rxjavamvpretrofit.activity.login;

/**
 * Created by demo on 2017/4/1.
 */

public class LoginEntity {

    /**
     * status : 2000
     * messsage : 成功
     * result : null
     */

    private int status;
    private String message;
    private String result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String messsage) {
        this.message = messsage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
