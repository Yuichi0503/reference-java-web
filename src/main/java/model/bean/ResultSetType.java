//
// このファイルは、Eclipse Implementation of JAXB、v3.0.2によって生成されました 
// https://eclipse-ee4j.github.io/jaxb-riを参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2024.06.03 時間 11:18:42 AM JST 
//


package model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>result_setType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="result_setType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="hit_num" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="results_get_position" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="results_num" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="results_cd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="err_list" type="{}err_listType" minOccurs="0"/&gt;
 *         &lt;element name="result" type="{}resultType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "result_setType", propOrder = {
    "hitNum",
    "resultsGetPosition",
    "resultsNum",
    "resultsCd",
    "errList",
    "result"
})
public class ResultSetType implements Serializable {

    @XmlElement(name = "hit_num", required = true)
    protected String hitNum;
    @XmlElement(name = "results_get_position", required = true)
    protected String resultsGetPosition;
    @XmlElement(name = "results_num", required = true)
    protected String resultsNum;
    @XmlElement(name = "results_cd", required = true)
    protected String resultsCd;
    @XmlElement(name = "err_list")
    protected ErrListType errList;
    protected List<ResultType> result;

    /**
     * hitNumプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHitNum() {
        return hitNum;
    }

    /**
     * hitNumプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHitNum(String value) {
        this.hitNum = value;
    }

    /**
     * resultsGetPositionプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultsGetPosition() {
        return resultsGetPosition;
    }

    /**
     * resultsGetPositionプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultsGetPosition(String value) {
        this.resultsGetPosition = value;
    }

    /**
     * resultsNumプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultsNum() {
        return resultsNum;
    }

    /**
     * resultsNumプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultsNum(String value) {
        this.resultsNum = value;
    }

    /**
     * resultsCdプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultsCd() {
        return resultsCd;
    }

    /**
     * resultsCdプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultsCd(String value) {
        this.resultsCd = value;
    }

    /**
     * errListプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ErrListType }
     *     
     */
    public ErrListType getErrList() {
        return errList;
    }

    /**
     * errListプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ErrListType }
     *     
     */
    public void setErrList(ErrListType value) {
        this.errList = value;
    }

    /**
     * Gets the value of the result property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the result property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResultType }
     * 
     * 
     */
    public List<ResultType> getResult() {
        if (result == null) {
            result = new ArrayList<ResultType>();
        }
        return this.result;
    }

}
