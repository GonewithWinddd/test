package document;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class TestDocuments {
    public static void createDocument(File file){

        try {
            /*初始化xml解析工厂*/
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            /*创建DocumentBuilder*/
            DocumentBuilder builder = factory.newDocumentBuilder();

            /*创建document*/
            Document doc = builder.newDocument();

            /*standalone 表示该文件是否呼叫其他外部文件， yes则没有*/
            doc.setXmlStandalone(true);

            //创建root节点
            //doc.createElement("元素名")、element.setAttribute("属性名","属性值")、element.setTextContent("标签间内容")
            Element element = doc.createElement("root");
            element.setAttribute("attr","root");


            Element elementChild1 = doc.createElement("name1");
            elementChild1.setAttribute("attr","nameOne");
            //说明elementChild1是element的子节点
            element.appendChild(elementChild1);

            Element elementChild1Child = doc.createElement("name2");
            elementChild1Child.setAttribute("value","nameTwo");
            elementChild1Child.setTextContent("namenamenamenamenamename");
            elementChild1.appendChild(elementChild1Child);
           // element.appendChild(elementChild1);


            Element elementChild2 = doc.createElement("pass1");
            elementChild2.setAttribute("attr","passOne");
            element.appendChild(elementChild2);




            doc.appendChild(element);

            // 把xml内容输出到具体的文件中
            TransformerFactory formerFactory=TransformerFactory.newInstance();
            Transformer transformer=formerFactory.newTransformer();
            // 换行
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");
            // 文档字符编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

            // 可随意指定文件的后缀,效果一样,但xml比较好解析,比如: E:\\person.txt等
            transformer.transform(new DOMSource(doc),new StreamResult(file));

            System.out.println("xml CreateDocument success!");


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        createDocument(new File("E:\\go\\a.xml"));
    }
}
