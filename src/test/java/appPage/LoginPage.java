package appPage;

public interface LoginPage {

    boolean isLoginTitleVisible();
    void performLogin(String email, String pass);
    void performLoginWithFacebook();
	 	
}
