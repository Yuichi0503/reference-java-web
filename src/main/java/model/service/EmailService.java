package model.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.codec.binary.Base64;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;

import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContext;
import model.entity.UsersEntity;


public class EmailService {
	private static final ResourceBundle bundle = ResourceBundle.getBundle("appConfig");
	private static final String credentialsFolderPath = bundle.getString("credentialsFolderPath");
	private static final String website = bundle.getString("website");
    
    /**
	 * GmailのAPIクライアントを取得します。
	 * @param servletContext サーブレットコンテキスト
	 * @return GmailのAPIクライアント
	 * @throws Exception 例外
	 */
    public static Gmail getGmail(ServletContext servletContext) throws Exception {
        HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        
        // OAuth2.0 クライアントIDで取得したJSONファイルのパスを指定
        String jsonFilePath = servletContext.getRealPath("/WEB-INF/client_secret.json");

        try(Reader reader = new InputStreamReader(new FileInputStream(jsonFilePath))){
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory,reader);

            //「スコープ」は、実行するAPIによって異なるので適時に変更
            //途中でスコープを変更した場合は再度のOAuth同意が必要
            //「認証情報を保存するフォルダパス」にあるファイルを削除するか、パスを変える
            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    transport, jsonFactory, clientSecrets, 
                    Arrays.asList("https://www.googleapis.com/auth/gmail.send"))
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(credentialsFolderPath)))
                .build();
            
            LocalServerReceiver receiver = new LocalServerReceiver.Builder().build();
            Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
            
            return new Gmail.Builder(transport, jsonFactory, credential)
            		.setApplicationName("認証メール自動送信APP")
            		.build();
        }
    }
    
    /**
     * MimeMessageを作成します。
     * @param to 送信先のメールアドレス
     * @param subject メールの件名
     * @param body メールの本文
     * @return 作成したMimeMessage
     * @throws Exception 例外
     */
    public static MimeMessage createMimeMessage(String to,String subject,String body) throws Exception {
        Session session = Session.getDefaultInstance(new Properties());
        MimeMessage email = new MimeMessage(session);

        email.setRecipient(jakarta.mail.Message.RecipientType.TO,new InternetAddress(to));
        email.setSubject(subject);
        email.setText(body);
        
        return email;
    

    }
    
    /**
     * Gmail API用のメッセージを作成します。
     * @param email MimeMessage
     * @return 作成したメッセージ
     * @throws IOException 入出力例外
     * @throws MessagingException メッセージング例外
     */
    public static com.google.api.services.gmail.model.Message  createMessage(MimeMessage email) throws IOException, MessagingException {
        byte[] bytes = null;
        try(ByteArrayOutputStream buffer = new ByteArrayOutputStream()){
            email.writeTo(buffer);	//メッセージをストリームへ出力
            bytes = buffer.toByteArray();
        }
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
        
        com.google.api.services.gmail.model.Message  message = new com.google.api.services.gmail.model.Message ();
        message.setRaw(encodedEmail);
        
        return message;
    }
    
    
	public static Message sendVerificationEmail(UsersEntity user, ServletContext servletContext)
			throws Exception {
		String verificationUrl = website + "/verify?token=" + user.getToken();
		String message = "以下のアドレスにアクセスして認証を完了してください\n" + verificationUrl;

		Gmail gmail = EmailService.getGmail(servletContext);
		Gmail.Users gmailUsers = gmail.users();
		Gmail.Users.Messages gmailMessages = gmailUsers.messages();

		var mimeM = EmailService.createMimeMessage(user.getEmail(), "認証メール", message);
		var content = EmailService.createMessage(mimeM);
		var send = gmailMessages.send("me", content);
		var mRes = send.execute();
		return mRes;
	}
	/**
	 * 認証メールを送信します。
	 * @param 宛先のメールアドレス
	 * @param URLに追加するtoken
	 * @param servletContext
	 * @return Gmail APIのMessageオブジェクト
	 * @throws Exception
	 */
	public static Message sendVerificationEmail(String email, String token, ServletContext servletContext)
			throws Exception {
		String verificationUrl = website + "/verify?token=" + token;
		String message = "以下のアドレスにアクセスして認証を完了してください\n" + verificationUrl;
		
		Gmail gmail = EmailService.getGmail(servletContext);
		Gmail.Users gmailUsers = gmail.users();
		Gmail.Users.Messages gmailMessages = gmailUsers.messages();
		
		var mimeM = EmailService.createMimeMessage(email, "認証メール", message);
		var content = EmailService.createMessage(mimeM);
		var send = gmailMessages.send("me", content);
		var mRes = send.execute();
		return mRes;
	}



    
}
