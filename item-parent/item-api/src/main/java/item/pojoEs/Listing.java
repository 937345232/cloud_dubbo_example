package item.pojoEs;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author jzx
 * @email:
 * @Date: 2019-09-03 11:46
 */
@Document(indexName = "item", type = "Listing")
@Data
public class Listing implements Serializable {


    private static final long serialVersionUID = -5769217896044453552L;
    @Id
    private Long listingId;
    @Field(analyzer = "ik", store = true, searchAnalyzer = "ik")
    private String listingName;
    @Field(analyzer = "ik", store = true, searchAnalyzer = "ik")
    private String listingDesc;

    private String author;

    private Double amount;

}
