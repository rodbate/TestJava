package mail;

3 import java.util.Properties;
 4 import javax.mail.Message;
 5 import javax.mail.Session;
 6 import javax.mail.Transport;
 7 import javax.mail.internet.InternetAddress;
 8 import javax.mail.internet.MimeMessage;
 9 
10 /**
11 * @ClassName: Sendmail
12 * @Description: 发送Email
13 * @author: 孤傲苍狼
14 * @date: 2015-1-12 下午9:42:56
15 *
16 */ 
17 public class Sendmail {
18 
19     /**
20      * @param args
21      * @throws Exception 
22      */
23     public static void main(String[] args) throws Exception {
24         
25         Properties prop = new Properties();
26         prop.setProperty("mail.host", "smtp.sohu.com");
27         prop.setProperty("mail.transport.protocol", "smtp");
28         prop.setProperty("mail.smtp.auth", "true");
29         //使用JavaMail发送邮件的5个步骤
30         //1、创建session
31         Session session = Session.getInstance(prop);
32         //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
33         session.setDebug(true);
34         //2、通过session得到transport对象
35         Transport ts = session.getTransport();
36         //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
37         ts.connect("smtp.sohu.com", "gacl", "邮箱密码");
38         //4、创建邮件
39         Message message = createSimpleMail(session);
40         //5、发送邮件
41         ts.sendMessage(message, message.getAllRecipients());
42         ts.close();
43     }
44     
45     /**
46     * @Method: createSimpleMail
47     * @Description: 创建一封只包含文本的邮件
48     * @Anthor:孤傲苍狼
49     *
50     * @param session
51     * @return
52     * @throws Exception
53     */ 
54     public static MimeMessage createSimpleMail(Session session)
55             throws Exception {
56         //创建邮件对象
57         MimeMessage message = new MimeMessage(session);
58         //指明邮件的发件人
59         message.setFrom(new InternetAddress("gacl@sohu.com"));
60         //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
61         message.setRecipient(Message.RecipientType.TO, new InternetAddress("gacl@sohu.com"));
62         //邮件的标题
63         message.setSubject("只包含文本的简单邮件");
64         //邮件的文本内容
65         message.setContent("你好啊！", "text/html;charset=UTF-8");
66         //返回创建好的邮件对象
67         return message;
68     }
69 }