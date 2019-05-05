package com.zhangweinan.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.commons.beanutils.BeanUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Eric on 2019/5/5.
 */
public class LuceneUtils {
    private static Directory directory;
    private static Analyzer analyzer;
    private static IndexWriter.MaxFieldLength maxFieldLength;

    private LuceneUtils() {}

    static{
        try {
            analyzer = new StandardAnalyzer(Version.LUCENE_30);
            maxFieldLength = IndexWriter.MaxFieldLength.LIMITED;
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static Directory getDirectory(String realPath) {
        try {
            if (directory == null) {
                //设置项目内路径
                directory = FSDirectory.open(new File(realPath + "lucene_index_db"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return directory;
    }

    public static Analyzer getAnalyzer() {
        return analyzer;
    }

    public static IndexWriter.MaxFieldLength getMaxFieldLength() {
        return maxFieldLength;
    }

    /**
     * @param object 传入的JavaBean类型
     * @return 返回Document对象
     */
    public static Document javaBean2Document(Object object) {
        try {
            Document document = new Document();
            //得到JavaBean的字节码文件对象
            Class<?> aClass = object.getClass();

            //通过字节码文件对象得到对应的属性【全部的属性，不能仅仅调用getFields()】
            Field[] fields = aClass.getDeclaredFields();

            //得到每个属性的名字
            for (Field field : fields) {
                String name = field.getName();
                //得到属性的值【也就是调用getter方法获取对应的值】
                String method = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                //得到对应的值【就是得到具体的方法，然后调用就行了。因为是get方法，没有参数】
                Method aClassMethod = aClass.getDeclaredMethod(method, null);
                String value = aClassMethod.invoke(object).toString();


                //把数据封装到Document对象中。
                document.add(new org.apache.lucene.document.Field(name, value, org.apache.lucene.document.Field.Store.YES, org.apache.lucene.document.Field.Index.ANALYZED));
            }
            return document;
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param aClass   要解析的对象类型，要用户传入进来
     * @param document 将Document对象传入进来
     * @return 返回一个JavaBean
     */
    public static Object Document2JavaBean(Document document, Class aClass) {
        try {
            //创建该JavaBean对象
            Object obj = aClass.newInstance();
            //得到该JavaBean所有的成员变量
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {

                //设置允许暴力访问
                field.setAccessible(true);
                String name = field.getName();
                String value = document.get(name);
                //使用BeanUtils把数据封装到Bean中
                BeanUtils.setProperty(obj, name, value);
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
