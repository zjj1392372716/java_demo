package dom4j;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Test {
	/**
	 * 写入信息
	 * @throws Exception
	 * @throws FileNotFoundException
	 */
	static void test() throws Exception, FileNotFoundException {
		// 创建解析器
		SAXReader reader = new SAXReader();
        Document doc = reader.read("src//dom4j//student.xml");
		// 获取根元素
        Element rootElement = doc.getRootElement();
		// 创建元素，设置属性并添加进去
        Element stuEle = rootElement.addElement("student").addAttribute("number", "a0003");
        
        // 设置文本信息
		stuEle.addElement("name").setText("zjjjj");	 
		stuEle.addElement("age").setText("30");	 
		stuEle.addElement("sex").setText("男");	 
		
		// 格式化输出到xml文件中去
        OutputFormat format = OutputFormat.createPrettyPrint();
        Writer wr = new OutputStreamWriter(new FileOutputStream("src//dom4j//student.xml"),"UTF-8");
        XMLWriter writer = new XMLWriter(wr, format);
        writer.write( doc );
        wr.close();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-----");
		// 创建SAXReader解析器
		SAXReader reader = new SAXReader();
        Document document = reader.read("src//dom4j//student.xml");
        
        // 获取根元素
        Element root = document.getRootElement();
        
        // 获取指定元素，返回集合
        List <Element> list = root.elements("student");
        // 遍历
        for (Element element : list) {
			String name = element.elementText("name");
			String age = element.elementText("age");
			String num = element.attributeValue("number");
			System.out.println(name);
			System.out.println(age);
			System.out.println(num);
		}
        
        test();
	}

}
