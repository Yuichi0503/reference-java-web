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
 * <p>err_listType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="err_listType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="err_item" type="{}err_itemType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "err_listType", propOrder = {
    "errItem"
})
public class ErrListType implements Serializable{

    @XmlElement(name = "err_item", required = true)
    protected ErrItemType errItem;

    /**
     * errItemプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ErrItemType }
     *     
     */
    public ErrItemType getErrItem() {
        return errItem;
    }

    /**
     * errItemプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ErrItemType }
     *     
     */
    public void setErrItem(ErrItemType value) {
        this.errItem = value;
    }

}
