package dy.Configuration;

import java.io.IOException;
import java.io.InputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;





public class Configuration {
	private String dbDriverName=null;
	private String dbUserName=null;
	private String dbPassword=null;
	private String dbUri=null;
	
	
	public Configuration(String configFileName) {
		SAXBuilder builder = new SAXBuilder();
        InputStream is = this.getClass().getResourceAsStream(configFileName);
        Document doc;
        try {
            doc = builder.build(is);
            Element root = doc.getRootElement();
            /* Database properties */
            dbDriverName = root.getChild("DatabaseConfig1").getChildTextTrim("dbDriverName");
            dbUserName = root.getChild("DatabaseConfig1").getChildTextTrim("dbUser");
            dbPassword = root.getChild("DatabaseConfig1").getChildTextTrim("dbPassword");
            dbUri = root.getChild("DatabaseConfig1").getChildTextTrim("dbURI");
            
        } catch (JDOMException eJDom) {
            
        } catch (IOException e) {
            
        }
	}
	public String getDbDriverName() {
		return dbDriverName;
	}
	public void setDbDriverName(String dbDriverName) {
		this.dbDriverName = dbDriverName;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getDbUri() {
		return dbUri;
	}
	public void setDbUri(String dbUri) {
		this.dbUri = dbUri;
	}
	
	

}
