package com.abc.dao;

import com.abc.domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


/**
 * @author hujtb
 * @create on 2018-08-20-10:48
 */
public class UserDaoImpl implements UserDao {
    String path = "E:/user.xml";

    /**
     * �����û������в���
     * @param name
     * @return
     */
    public User findByUsername(String name){
        SAXReader reader = new SAXReader();
        try{
            Document doc = reader.read(path);
            //����name���Ի�ȡ��Ӧ��Ԫ��
            Element ele = (Element) doc.selectSingleNode("//user[@name='" + name + "']");
            if(ele == null) return null;

            //����user�������������name��password
            User user = new User();
            String username = ele.attributeValue("name");
            String password = ele.attributeValue("password");
            user.setName(username);
            user.setPassword(password);
            return user;
        }catch(DocumentException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * ����û�
     * @param user
     */
    public void addUser(User user){
        SAXReader reader = new SAXReader();
        try{
            //����xml·����ȡ�ĵ�����
            Document doc = reader.read(path);
            //��ȡ��Ԫ��
            Element root = doc.getRootElement();
            //���ݸ�Ԫ�ش�����Ԫ��
            Element userEle = root.addElement("user");
            //ΪuserEle��������
            userEle.addAttribute("name", user.getName());
            userEle.addAttribute("password", user.getPassword());

            /*
             * �����ĵ�
             */
            //���������ʽ����
            OutputFormat format = new OutputFormat("\t", true);
            format.setTrimText(true);

            //����xmlWriter
            try{
                XMLWriter writer = new XMLWriter(
                        new OutputStreamWriter(new FileOutputStream(path), "UTF-8"), format);
                writer.write(doc);
                writer.close();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }catch(DocumentException e){
            throw new RuntimeException();
        }
    }
}
