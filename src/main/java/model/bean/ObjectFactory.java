//
// このファイルは、Eclipse Implementation of JAXB、v3.0.2によって生成されました 
// https://eclipse-ee4j.github.io/jaxb-riを参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2024.06.03 時間 11:18:42 AM JST 
//


package model.bean;

import java.io.Serializable;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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
public class ObjectFactory implements Serializable{

    private final static QName _ResultSet_QNAME = new QName("", "result_set");
    private final static QName _ReferenceTypeQuestion_QNAME = new QName("", "question");
    private final static QName _ReferenceTypeRegId_QNAME = new QName("", "reg-id");
    private final static QName _ReferenceTypeAnswer_QNAME = new QName("", "answer");
    private final static QName _ReferenceTypeCrtDate_QNAME = new QName("", "crt-date");
    private final static QName _ReferenceTypeSolution_QNAME = new QName("", "solution");
    private final static QName _ReferenceTypeKeyword_QNAME = new QName("", "keyword");
    private final static QName _ReferenceTypeClass_QNAME = new QName("", "class");
    private final static QName _ReferenceTypeResType_QNAME = new QName("", "res-type");
    private final static QName _ReferenceTypeBibl_QNAME = new QName("", "bibl");
    private final static QName _ReferenceTypeAnsProc_QNAME = new QName("", "ans-proc");
    private final static QName _ReferenceTypePreRes_QNAME = new QName("", "pre-res");
    private final static QName _ReferenceTypePtnType_QNAME = new QName("", "ptn-type");
    private final static QName _ReferenceTypeNote_QNAME = new QName("", "note");
    private final static QName _ReferenceTypeSystem_QNAME = new QName("", "system");
    private final static QName _ReferenceTypeUrl_QNAME = new QName("", "url");
    private final static QName _ReferenceTypeConType_QNAME = new QName("", "con-type");
    private final static QName _ReferenceTypeReferral_QNAME = new QName("", "referral");
    private final static QName _ReferenceTypeContri_QNAME = new QName("", "contri");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResultSetType }
     * 
     */
    public ResultSetType createResultSetType() {
        return new ResultSetType();
    }

    /**
     * Create an instance of {@link SystemType }
     * 
     */
    public SystemType createSystemType() {
        return new SystemType();
    }

    /**
     * Create an instance of {@link ReferenceType }
     * 
     */
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link BiblType }
     * 
     */
    public BiblType createBiblType() {
        return new BiblType();
    }

    /**
     * Create an instance of {@link ErrListType }
     * 
     */
    public ErrListType createErrListType() {
        return new ErrListType();
    }

    /**
     * Create an instance of {@link ErrItemType }
     * 
     */
    public ErrItemType createErrItemType() {
        return new ErrItemType();
    }

    /**
     * Create an instance of {@link ResultType }
     * 
     */
    public ResultType createResultType() {
        return new ResultType();
    }

    /**
     * Create an instance of {@link ClassType }
     * 
     */
    public ClassType createClassType() {
        return new ClassType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultSetType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResultSetType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "result_set")
    public JAXBElement<ResultSetType> createResultSet(ResultSetType value) {
        return new JAXBElement<ResultSetType>(_ResultSet_QNAME, ResultSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "question", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeQuestion(String value) {
        return new JAXBElement<String>(_ReferenceTypeQuestion_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "reg-id", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeRegId(String value) {
        return new JAXBElement<String>(_ReferenceTypeRegId_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "answer", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeAnswer(String value) {
        return new JAXBElement<String>(_ReferenceTypeAnswer_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "crt-date", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeCrtDate(String value) {
        return new JAXBElement<String>(_ReferenceTypeCrtDate_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "solution", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeSolution(String value) {
        return new JAXBElement<String>(_ReferenceTypeSolution_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "keyword", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeKeyword(String value) {
        return new JAXBElement<String>(_ReferenceTypeKeyword_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClassType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "class", scope = ReferenceType.class)
    public JAXBElement<ClassType> createReferenceTypeClass(ClassType value) {
        return new JAXBElement<ClassType>(_ReferenceTypeClass_QNAME, ClassType.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "res-type", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeResType(String value) {
        return new JAXBElement<String>(_ReferenceTypeResType_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BiblType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BiblType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "bibl", scope = ReferenceType.class)
    public JAXBElement<BiblType> createReferenceTypeBibl(BiblType value) {
        return new JAXBElement<BiblType>(_ReferenceTypeBibl_QNAME, BiblType.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ans-proc", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeAnsProc(String value) {
        return new JAXBElement<String>(_ReferenceTypeAnsProc_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "pre-res", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypePreRes(String value) {
        return new JAXBElement<String>(_ReferenceTypePreRes_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ptn-type", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypePtnType(String value) {
        return new JAXBElement<String>(_ReferenceTypePtnType_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "note", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeNote(String value) {
        return new JAXBElement<String>(_ReferenceTypeNote_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SystemType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "system", scope = ReferenceType.class)
    public JAXBElement<SystemType> createReferenceTypeSystem(SystemType value) {
        return new JAXBElement<SystemType>(_ReferenceTypeSystem_QNAME, SystemType.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "url", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeUrl(String value) {
        return new JAXBElement<String>(_ReferenceTypeUrl_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "con-type", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeConType(String value) {
        return new JAXBElement<String>(_ReferenceTypeConType_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "referral", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeReferral(String value) {
        return new JAXBElement<String>(_ReferenceTypeReferral_QNAME, String.class, ReferenceType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "contri", scope = ReferenceType.class)
    public JAXBElement<String> createReferenceTypeContri(String value) {
        return new JAXBElement<String>(_ReferenceTypeContri_QNAME, String.class, ReferenceType.class, value);
    }

}
