/**************************************************************************
 * Copyright (c) 2002, 2010 ComActivity AB, Sweden.  All rights reserved.
 * COMACTIVITY PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 * Redistribution in source and binary forms, with or without modification,
 * are not permitted unless explicit written permission is obtained.
 **************************************************************************/
package Feeders;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.comactivity.core.repository.RepositoryUtil;
import net.comactivity.core.repository.Table;
import net.comactivity.core.rule.AbstractRule;
import net.comactivity.core.sql.SelectStatement;
import net.comactivity.core.sql.SqlResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class JJGetTableDef extends AbstractRule {

	@Override
	public boolean execute(String arg0) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document m3TableDef = builder.newDocument();
			Element root = m3TableDef.createElement("Tables");
			ArrayList<cfiffdModel> cfiffds = getCFIFFDs();
			String savedWHFILE = "";
			Element savedTableElement = null;
			for(cfiffdModel cfiddf : cfiffds)
			{
				if(!savedWHFILE.equals(cfiddf.getFile()))
				{
					if(savedTableElement != null)
					{
						root.appendChild(savedTableElement);
					}
					savedTableElement = m3TableDef.createElement("Table");
					savedTableElement.setAttribute("Name", cfiddf.getFile());
				}
				Element columnElement = m3TableDef.createElement("Column");
				columnElement.setAttribute("Name", cfiddf.getFldi());
				columnElement.setAttribute("Description", cfiddf.getPm15());
				savedTableElement.appendChild(columnElement);
//				m3TableDef.appendChild(savedTableElement);
				savedWHFILE = cfiddf.getFile();
			}
			
			m3TableDef.appendChild(root);

			//			File file = new File("C:\\Comactivity\\JJColumnDef.xml");
			//			FileOutputStream outputStream = new FileOutputStream(file);
			//			OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
			//			BufferedWriter bufferedWriter = new BufferedWriter(streamWriter);
			//			
			//			
			//			bufferedWriter.close();
			//			streamWriter.close();
			//			outputStream.close();

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(m3TableDef);
			StreamResult result = new StreamResult(new File("C:\\Comactivity\\JJColumnDef.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return true;
	}

	public ArrayList<cfiffdModel> getCFIFFDs() {
		Table table = RepositoryUtil.getTable("MOVEX", "CFIFFD");
		ArrayList<cfiffdModel> cfiffds = new ArrayList<cfiffdModel>();
		cfiffdModel cfiffd;
		SelectStatement select = new SelectStatement(table, processData.getSessionWorkspace().getSessionValues(), processData.getSessionWorkspace().getDataTypeHandler());
		select.addSelectColumn("WHFILE");
		select.addSelectColumn("WHFLDI");
		select.addSelectColumn("WHPM15");
		select.addOrderBy("WHFILE");
		SqlResult result = select.execute();
		try {
			while (result.next()) {
				cfiffd = new cfiffdModel();
				cfiffd.setFile(result.getString("WHFILE"));
				cfiffd.setFldi(result.getString("WHFLDI"));
				cfiffd.setPm15(result.getString("WHPM15"));
				cfiffds.add(cfiffd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null)
				result.close();
		}
		return cfiffds;
	}

}
