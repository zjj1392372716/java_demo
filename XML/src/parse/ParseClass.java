package parse;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class ParseClass {
	
	
	
	/**
	 * 获取节点内容
	 * @param doc
	 */
	public static void test1(Document doc) {
		// 4、根据节点名称获得节点
		NodeList allStu = doc.getElementsByTagName("student");
		
		// 5、获取第一个学生
		Node n1 = allStu.item(0);
		
		System.out.println(n1.getTextContent()); // zjj21
	}
	
	/**
	 * 修改节点内容
	 * @param doc
	 * @throws TransformerFactoryConfigurationError 
	 * @throws Exception 
	 */
	public static void test2(Document doc) throws TransformerFactoryConfigurationError, Exception {
		// 4、获取所有指定节点
		NodeList ageList = doc.getElementsByTagName("age");
		
		// 5、获取指定节点 
		Node n1 = ageList.item(0);
		
		// 6、修改节点内容
		n1.setTextContent("300");
		
		// 7、从内从更新到文件中
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/parse/student.xml"));
	}
	
	/**
	 * 添加节点
	 * @param doc
	 * @throws TransformerFactoryConfigurationError
	 * @throws Exception
	 */
	static void test3(Document doc) throws Exception, TransformerFactoryConfigurationError {
		 // 创建一个元素
		 Element element = doc.createElement("address");
		 
		 // 设置内容
		 element.setTextContent("address");
		 
		 // 插入
		 Node stuNode = doc.getElementsByTagName("student").item(0);
		 stuNode.appendChild(element);
		 
		 
		 // 从内从更新到文件中
		 Transformer tf = TransformerFactory.newInstance().newTransformer();
		 tf.transform(new DOMSource(doc), new StreamResult("src/parse/student.xml"));
	}
	
	/**
	 * 删除节点
	 * @param doc
	 * @throws Exception
	 * @throws TransformerFactoryConfigurationError
	 */
	static void test4(Document doc) throws Exception, TransformerFactoryConfigurationError {
		Node addressNode = doc.getElementsByTagName("address").item(0);
		addressNode.getParentNode().removeChild(addressNode);
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/parse/student.xml"));
	}
	
	/**
	 * 设置属性
	 * @param doc
	 * @throws Exception
	 * @throws TransformerFactoryConfigurationError
	 */
	static void test5(Document doc) throws Exception, TransformerFactoryConfigurationError {
		Node stu = doc.getElementsByTagName("student").item(1);
		Element ele = (Element)stu;
		ele.setAttribute("ID", "00001");
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/parse/student.xml"));	
	}
	
	/**
	 * 主函数
	 * @param args
	 * @throws TransformerFactoryConfigurationError
	 * @throws Exception
	 */
	public static void main(String[] args) throws TransformerFactoryConfigurationError, Exception {
		// TODO Auto-generated method stub
		// 1、创建解析器工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		// 2、通过解析器工厂创建解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		// 3、通过解析器得到文档对象
		Document doc = db.parse("src/parse/student.xml");
		test1(doc);
		test2(doc);
//		test3(doc);
//		test4(doc);
		test5(doc);
		
	}

}
