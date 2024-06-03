//
// このファイルは、Eclipse Implementation of JAXB、v3.0.2によって生成されました 
// https://eclipse-ee4j.github.io/jaxb-riを参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2024.06.03 時間 11:18:42 AM JST 
//


package model.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>err_itemType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="err_itemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="err_code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="err_fld" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="err_msg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "err_itemType", propOrder = {
    "errCode",
    "errFld",
    "errMsg"
})
public class ErrItemType {

    @XmlElement(name = "err_code", required = true)
    protected String errCode;
    @XmlElement(name = "err_fld", required = true)
    protected String errFld;
    @XmlElement(name = "err_msg", required = true)
    protected String errMsg;

    /**
     * errCodeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * errCodeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrCode(String value) {
        this.errCode = value;
    }

    /**
     * errFldプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrFld() {
        return errFld;
    }

    /**
     * errFldプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrFld(String value) {
        this.errFld = value;
    }

    /**
     * errMsgプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * errMsgプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrMsg(String value) {
        this.errMsg = value;
    }

}
