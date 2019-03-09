
package cn.gov.ynhrss.baseinfo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.gov.ynhrss.baseinfo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Bizenv_QNAME = new QName("http://www.ynhrss.gov.cn/baseinfo", "bizenv");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.gov.ynhrss.baseinfo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Bizenv }
     * 
     */
    public Bizenv createBizenv() {
        return new Bizenv();
    }

    /**
     * Create an instance of {@link Bizhead }
     * 
     */
    public Bizhead createBizhead() {
        return new Bizhead();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bizenv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ynhrss.gov.cn/baseinfo", name = "bizenv")
    public JAXBElement<Bizenv> createBizenv(Bizenv value) {
        return new JAXBElement<Bizenv>(_Bizenv_QNAME, Bizenv.class, null, value);
    }

}
