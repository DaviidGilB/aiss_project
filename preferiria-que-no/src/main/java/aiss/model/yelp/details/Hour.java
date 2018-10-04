
package aiss.model.yelp.details;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hours_type",
    "open",
    "is_open_now"
})
public class Hour {

    @JsonProperty("hours_type")
    private String hoursType;
    @JsonProperty("open")
    private List<Open> open = null;
    @JsonProperty("is_open_now")
    private Boolean isOpenNow;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hours_type")
    public String getHoursType() {
        return hoursType;
    }

    @JsonProperty("hours_type")
    public void setHoursType(String hoursType) {
        this.hoursType = hoursType;
    }

    @JsonProperty("open")
    public List<Open> getOpen() {
        return open;
    }

    @JsonProperty("open")
    public void setOpen(List<Open> open) {
        this.open = open;
    }

    @JsonProperty("is_open_now")
    public Boolean getIsOpenNow() {
        return isOpenNow;
    }

    @JsonProperty("is_open_now")
    public void setIsOpenNow(Boolean isOpenNow) {
        this.isOpenNow = isOpenNow;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
