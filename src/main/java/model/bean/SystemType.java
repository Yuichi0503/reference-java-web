//
// このファイルは、Eclipse Implementation of JAXB、v3.0.2によって生成されました 
// https://eclipse-ee4j.github.io/jaxb-riを参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2024.06.03 時間 11:18:42 AM JST 
//


package model.bean;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>systemType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="systemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reg-date" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lst-date" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sys-id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lib-id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lib-name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="file-num" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "systemType", propOrder = {
    "regDate",
    "lstDate",
    "sysId",
    "libId",
    "libName",
    "fileNum"
})
public class SystemType implements Serializable {

    @XmlElement(name = "reg-date", required = true)
    protected String regDate;
    @XmlElement(name = "lst-date", required = true)
    protected String lstDate;
    @XmlElement(name = "sys-id", required = true)
    protected String sysId;
    @XmlElement(name = "lib-id", required = true)
    protected String libId;
    @XmlElement(name = "lib-name", required = true)
    protected String libName;
    @XmlElement(name = "file-num", required = true)
    protected String fileNum;

    /**
     * regDateプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * regDateプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegDate(String value) {
        this.regDate = value;
    }

    /**
     * lstDateプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLstDate() {
        return lstDate;
    }

    /**
     * lstDateプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLstDate(String value) {
        this.lstDate = value;
    }

    /**
     * sysIdプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysId() {
        return sysId;
    }

    /**
     * sysIdプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysId(String value) {
        this.sysId = value;
    }

    /**
     * libIdプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibId() {
        return libId;
    }

    /**
     * libIdプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibId(String value) {
        this.libId = value;
    }

    /**
     * libNameプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibName() {
        return libName;
    }

    /**
     * libNameプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibName(String value) {
        this.libName = value;
    }

    /**
     * fileNumプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileNum() {
        return fileNum;
    }

    /**
     * fileNumプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileNum(String value) {
        this.fileNum = value;
    }

}
