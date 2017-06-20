package com.shonlee.emailTest;

import com.shonlee.Utils.EmailUUIDUtile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ShonLee on 2017/6/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 简单的text邮件测试
     *
     * @throws Exception
     */
    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("xiao_7061@163.com");
        simpleMailMessage.setTo("xiao_7061@163.com");
        simpleMailMessage.setSubject("主题：简单邮件");
        simpleMailMessage.setText("测试邮件内容");

        javaMailSender.send(simpleMailMessage);
    }

    /**
     * 有附件的邮箱测试
     *
     * @throws Exception
     */
    @Test
    public void sendAttachmentsMail() throws Exception {
        //创建邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("xiao_7061@163.com");
        helper.setTo("xiao_7061@163.com");
        //设置邮件的主题
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(
                new File("src/main/resources/static/images/index.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        javaMailSender.send(mimeMessage);
    }

    /**
     * 嵌入静态资源的邮箱测试
     */
    @Test
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("xiao_7061@163.com");
        helper.setTo("xiao_7061@163.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:wechat\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(
                new File("src/main/resources/static/images/index.jpg"));

        //这里需要注意的是addInline函数中资源名称wechat需要与正文中cid:wechat对应起来
        helper.addInline("wechat", file);

        javaMailSender.send(mimeMessage);
    }

    /**
     * 模板邮件测试
     */
    @Test
    public void sendTemplateMail() throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("xiao_7061@163.com");
        helper.setTo("xiao_7061@163.com");
        helper.setSubject("主题：模板邮件");

        Map<String, Object> model = new HashMap();
        model.put("username", "didi");
/*        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "/template.vm", "UTF-8", model);
        helper.setText(text, true);*/
        javaMailSender.send(mimeMessage);
    }

    /**
     * 邮箱验证测试方法
     */
    @Test
    public void sendCodeMail() throws Exception {
        String code=EmailUUIDUtile.getUUID();
        String code1=EmailUUIDUtile.getUUID();
        System.out.println("code="+code);
        System.out.println("code1="+code1);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("xiao_7061@163.com");
        helper.setTo("xiao_7061@163.com");
        helper.setSubject("主题：邮箱测试");
        helper.setText("<h1>来自xx网站的激活邮件，激活请点击下面的连接</h1>" +
                "<h3><about href='http://192.168.0.107:8080/Active?code="+ code+"'>请点击此处激活！</about></h3>", true);

 /*       FileSystemResource file = new FileSystemResource(
                new File("src/main/resources/static/images/index.jpg"));

        //这里需要注意的是addInline函数中资源名称wechat需要与正文中cid:wechat对应起来
        helper.addInline("wechat", file);*/

        javaMailSender.send(mimeMessage);
    }
}
