package bean;

public class User {
    private Integer uId;

    private String uUsername;

    private String uPassword;

    private String uSex;

    private Integer uCid;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername == null ? null : uUsername.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex == null ? null : uSex.trim();
    }

    public Integer getuCid() {
        return uCid;
    }

    public void setuCid(Integer uCid) {
        this.uCid = uCid;
    }

	public String toString()
	{
		return "User [uId=" + uId + ", uUsername=" + uUsername + ", uPassword="
				+ uPassword + ", uSex=" + uSex + ", uCid=" + uCid + "]";
	}
    
}