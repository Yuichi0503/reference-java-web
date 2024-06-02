//
// このファイルは、Eclipse Implementation of JAXB、v3.0.2によって生成されました 
// https://eclipse-ee4j.github.io/jaxb-riを参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2024.06.02 時間 08:17:43 PM JST 
//


package model.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>biblType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="biblType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bibl-desc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bibl-isbn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="bibl-note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "biblType", propOrder = {
    "biblDesc",
    "biblIsbn",
    "biblNote"
})
public class BiblType {

    @XmlElement(name = "bibl-desc", required = true)
    protected String biblDesc;
    @XmlElement(name = "bibl-isbn")
    protected String biblIsbn;
    @XmlElement(name = "bibl-note")
    protected String biblNote;

    /**
     * biblDescプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiblDesc() {
        return biblDesc;
    }

    /**
     * biblDescプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiblDesc(String value) {
        this.biblDesc = value;
    }

    /**
     * biblIsbnプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiblIsbn() {
        return biblIsbn;
    }

    /**
     * biblIsbnプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiblIsbn(String value) {
        this.biblIsbn = value;
    }

    /**
     * biblNoteプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiblNote() {
        return biblNote;
    }

    /**
     * biblNoteプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiblNote(String value) {
        this.biblNote = value;
    }

}
