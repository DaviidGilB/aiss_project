
package aiss.model.yelp.details;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "is_overnight",
    "end",
    "day",
    "start"
})
public class Open {

    @JsonProperty("is_overnight")
    private Boolean isOvernight;
    @JsonProperty("end")
    private String end;
    @JsonProperty("day")
    private Integer day;
    @JsonProperty("start")
    private String start;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_overnight")
    public Boolean getIsOvernight() {
        return isOvernight;
    }

    @JsonProperty("is_overnight")
    public void setIsOvernight(Boolean isOvernight) {
        this.isOvernight = isOvernight;
    }

    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
    }

    @JsonProperty("day")
    public Integer getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Integer day) {
        this.day = day;
    }

    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
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
