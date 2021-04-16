package makeXML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class makeCollection {
	public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException {
		File dir = new File("C:\\Users\\이재현\\Desktop\\2021 1학기\\오픈소스\\2주차 실습 html");
		File files[] = dir.listFiles();
		
		Document[] arrDoc = new Document[5];
		
		for (int i = 0; i < files.length; i++) {
			arrDoc[i] = Jsoup.parse(files[i], "UTF-8");
		}
		
		System.out.println(arrDoc[0]);
		
		Elements text5 = arrDoc[0].select("p");
		System.out.println(text5);
		
		Elements text0 = arrDoc[0].select("#content");
		String content0 = text0.text();
		System.out.println(content0);
		
		Elements text1 = arrDoc[1].select("#content");
		String content1 = text1.text();
		Elements text2 = arrDoc[2].select("#content");
		String content2 = text2.text();
		Elements text3 = arrDoc[3].select("#content");
		String content3 = text3.text();
		Elements text4 = arrDoc[4].select("#content");
		String content4 = text4.text();
		
		
		
		
		
		//xml파일 편집하기
		DocumentBuilderFactory L0 = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = L0.newDocumentBuilder();
		org.w3c.dom.Document d0 = docBuilder.newDocument();
			
		// book element
		org.w3c.dom.Element docs = d0.createElement("docs");
		d0.appendChild(docs);
		for(int j=0; j<5;j++) {
			//code element
			org.w3c.dom.Element doc = d0.createElement("doc");
			docs.appendChild(doc);
			
			doc.setAttribute("id", ""+j);
				
			// title element
			org.w3c.dom.Element title = d0.createElement("title");
			if(j==0) {
				title.appendChild(d0.createTextNode("떡"));
				doc.appendChild(title);
				
				// body element
				org.w3c.dom.Element body = d0.createElement("body");
				body.appendChild(d0.createTextNode(content0));
				doc.appendChild(body);
			} else if(j==1) {
				title.appendChild(d0.createTextNode("라면"));
				doc.appendChild(title);
				
				// body element
				org.w3c.dom.Element body = d0.createElement("body");
				body.appendChild(d0.createTextNode(content1));
				doc.appendChild(body);
			} else if(j==2) {
				title.appendChild(d0.createTextNode("아이스크림"));
				doc.appendChild(title);
				
				// body element
				org.w3c.dom.Element body = d0.createElement("body");
				body.appendChild(d0.createTextNode(content2));
				doc.appendChild(body);
			} else if(j==3) {
				title.appendChild(d0.createTextNode("초밥"));
				doc.appendChild(title);
				
				// body element
				org.w3c.dom.Element body = d0.createElement("body");
				body.appendChild(d0.createTextNode(content3));
				doc.appendChild(body);
			} else if(j==4) {
				title.appendChild(d0.createTextNode("파스타"));
				doc.appendChild(title);
				
				// body element
				org.w3c.dom.Element body = d0.createElement("body");
				body.appendChild(d0.createTextNode(content4));
				doc.appendChild(body);
			}
			
		}
		
			
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			
		DOMSource source = new DOMSource(d0);
		StreamResult result = new StreamResult(new FileOutputStream(new File("collection.xml")));
			
		transformer.transform(source, result);

		
		
	}
}

