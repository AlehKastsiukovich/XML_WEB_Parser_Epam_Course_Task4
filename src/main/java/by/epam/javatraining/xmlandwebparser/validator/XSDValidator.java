package by.epam.javatraining.xmlandwebparser.validator;

import by.epam.javatraining.xmlandwebparser.command.CommandType;
import org.xml.sax.SAXException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

public class XSDValidator {
    private static final String TEMPORARY_XML_FILE = "tempXmlFile.xml";
    private static final String XSD_VALIDATION_FILE = "touristVouchers.xsd";

    private static class XSDValidatorHolder {
        private static final XSDValidator INSTANCE = new XSDValidator();
    }

    public static XSDValidator getInstance() {
        return XSDValidatorHolder.INSTANCE;
    }

    public void validateXMLSchema(HttpServletRequest request) {
        try {
            File targetFile = writeTemporaryFile(request);
            File xsdFile = new File(getTouristVoucherXsdPath());
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(targetFile));
        } catch (IOException | ServletException | SAXException e) {

        }
    }

    private String getTouristVoucherXsdPath() {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource(XSD_VALIDATION_FILE).getPath();
    }

    private File writeTemporaryFile(HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart(CommandType.FILE.getValue());
        InputStream fileContent = filePart.getInputStream();
        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);
        File tempFile = new File(TEMPORARY_XML_FILE);
        OutputStream outputStream = new FileOutputStream(tempFile);
        outputStream.write(buffer);

        return tempFile;
    }
}
