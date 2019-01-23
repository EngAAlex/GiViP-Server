package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Latency
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-04T16:51:06.704Z")

public class Latency   {
  @JsonProperty("source")
  private String source = null;

  @JsonProperty("target")
  private String target = null;

  @JsonProperty("latency")
  private Integer latency = null;

  public Latency source(String source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(example = "hostname 1", required = true, value = "")
  @NotNull


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Latency target(String target) {
    this.target = target;
    return this;
  }

   /**
   * Get target
   * @return target
  **/
  @ApiModelProperty(example = "hostname 2", required = true, value = "")
  @NotNull


  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public Latency latency(Integer latency) {
    this.latency = latency;
    return this;
  }

   /**
   * source - target ping latency (ms)
   * @return latency
  **/
  @ApiModelProperty(example = "1200", required = true, value = "source - target ping latency (ms)")
  @NotNull


  public Integer getLatency() {
    return latency;
  }

  public void setLatency(Integer latency) {
    this.latency = latency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Latency latency = (Latency) o;
    return Objects.equals(this.source, latency.source) &&
        Objects.equals(this.target, latency.target) &&
        Objects.equals(this.latency, latency.latency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, target, latency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Latency {\n");
    
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    latency: ").append(toIndentedString(latency)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

