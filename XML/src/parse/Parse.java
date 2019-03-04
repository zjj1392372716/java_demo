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

public class Parse {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
		/**
		 * 
		1.��������������
		2.ͨ�������������õ�������
		3.ͨ���������õ�document����
		4.��ȡ����Ľڵ�����
		 * */
		// 1.��������������
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 2.ͨ�������������õ�������
		DocumentBuilder db = dbf.newDocumentBuilder();
		// 3.ͨ���������õ�document����
		Document doc = db.parse("src/parse/student.xml");
		// ��ȡ����Ľڵ�����
//		test1(doc);
//		test2(doc);
		test3(doc);
		/*test4(doc);*/
		test5(doc);
	}

	static void test5(Document doc) throws Exception, TransformerFactoryConfigurationError {
		//1.��ȡҪ������ԵĽڵ�
		Node stu = doc.getElementsByTagName("student").item(1);
		//2.�ѻ�ȡ�Ľڵ�ǿ��ת����element
		Element ele = (Element)stu;
		//3.��������
		ele.setAttribute("ID", "00001");
		//4.���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/parse/student.xml"));	
	}
	
	// ɾ���ڵ�
	static void test4(Document doc) throws Exception, TransformerFactoryConfigurationError {
		// 1.��ȡһ���ڵ�
		Node addressNode = doc.getElementsByTagName("address").item(0);
		// 2.��ȡ�ýڵ�ĸ��ڵ㣬�Ӹ��ڵ㵱���Ƴ�
		addressNode.getParentNode().removeChild(addressNode);
		// 3.���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/parse/student.xml"));
	}

	// ��ӽڵ�
	static void test3(Document doc) throws Exception, TransformerFactoryConfigurationError {
		// 1.����һ���ڵ�
		Element addressEle = doc.createElement("address");
		// 2.����Ԫ������
		addressEle.setTextContent("��ַ1");
		// 3.��ȡҪ���Ԫ�صĸ����
		Node stuNode = doc.getElementsByTagName("student").item(0);
		// 4.��ӽڵ�
		stuNode.appendChild(addressEle);
		// 5.���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/parse/student.xml"));
	}

	// �޸�Ԫ�ص�����
	static void test2(Document doc) throws TransformerFactoryConfigurationError, Exception {

		// 1.��ȡ����ָ���ڵ�
		NodeList ageList = doc.getElementsByTagName("age");
		// 2.��ȡҪ�޸ĵĽڵ�
		Node ageNode = ageList.item(1);
		// 3.�޸�Ԫ������
		ageNode.setTextContent("300");
		// 4.���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/parse/student.xml"));
	}

	// ��ȡ����Ľڵ�����
	static void test1(Document doc) {
		// 4.��ȡ����Ľڵ�����
		NodeList list = doc.getElementsByTagName("name");
		Node name = list.item(1);
		System.out.println(name.getTextContent());
	}

}
