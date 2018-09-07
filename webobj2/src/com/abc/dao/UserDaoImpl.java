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
     * 根据用户名进行查找
     * @param name
     * @return
     */
    public User findByUsername(String name){
        SAXReader reader = new SAXReader();
        try{
            Document doc = reader.read(path);
            //根据name属性获取对应的元素
            Element ele = (Element) doc.selectSingleNode("//user[@name='" + name + "']");
            if(ele == null) return null;

            //创建user对象并向其中添加name和password
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
     * 添加用户
     * @param user
     */
    public void addUser(User user){
        SAXReader reader = new SAXReader();
        try{
            //根据xml路径获取文档对象
            Document doc = reader.read(path);
            //获取根元素
            Element root = doc.getRootElement();
            //根据根元素创建新元素
            Element userEle = root.addElement("user");
            //为userEle设置属性
            userEle.addAttribute("name", user.getName());
            userEle.addAttribute("password", user.getPassword());

            /*
             * 保存文档
             */
            //创建输出格式化器
            OutputFormat format = new OutputFormat("\t", true);
            format.setTrimText(true);

            //创建xmlWriter
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
