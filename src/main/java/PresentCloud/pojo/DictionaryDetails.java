package PresentCloud.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Entity
@Table(name = "dictionary_details")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class DictionaryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;
    private String dictDetailCode;
    private int dict_id;
    private String keywordName;
    private int typeCode;
    private int defaultValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDictDetailCode() {
        return dictDetailCode;
    }

    public void setDictDetailCode(String dictDetailCode) {
        this.dictDetailCode = dictDetailCode;
    }

    public int getDict_id() {
        return dict_id;
    }

    public void setDict_id(int dict_id) {
        this.dict_id = dict_id;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }
}

