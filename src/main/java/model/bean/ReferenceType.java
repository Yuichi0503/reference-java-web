//
// このファイルは、Eclipse Implementation of JAXB、v3.0.2によって生成されました 
// https://eclipse-ee4j.github.io/jaxb-riを参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2024.06.03 時間 11:18:42 AM JST 
//


package model.bean;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>referenceType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="referenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="question" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="reg-id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="answer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="crt-date" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="solution" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="class" type="{}classType"/&gt;
 *         &lt;element name="res-type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bibl" type="{}biblType"/&gt;
 *         &lt;element name="ans-proc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pre-res" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ptn-type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="system" type="{}systemType"/&gt;
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="con-type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="referral" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="contri" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "referenceType", propOrder = {
    "questionOrRegIdOrAnswer"
})
public class ReferenceType {

    @XmlElementRefs({
        @XmlElementRef(name = "question", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "reg-id", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "answer", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "crt-date", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "solution", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "keyword", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "class", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "res-type", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bibl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ans-proc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "pre-res", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ptn-type", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "note", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "system", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "url", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "con-type", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "referral", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "contri", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> questionOrRegIdOrAnswer;

    /**
     * Gets the value of the questionOrRegIdOrAnswer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the questionOrRegIdOrAnswer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuestionOrRegIdOrAnswer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BiblType }{@code >}
     * {@link JAXBElement }{@code <}{@link ClassType }{@code >}
     * {@link JAXBElement }{@code <}{@link SystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getQuestionOrRegIdOrAnswer() {
        if (questionOrRegIdOrAnswer == null) {
            questionOrRegIdOrAnswer = new ArrayList<JAXBElement<?>>();
        }
        return this.questionOrRegIdOrAnswer;
    }
    //追記
    public Object refTypeObject(String refTypeName) {
    	for (JAXBElement<?> element : questionOrRegIdOrAnswer) {
	        // "elementName"という名前の要素を探す
	        if (refTypeName.equals(element.getName().getLocalPart())) {
	            // answerの値を取得
	            return element.getValue();
	        }
	    }
		return null;
		
	}

}
