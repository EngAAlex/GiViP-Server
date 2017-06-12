package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Edge
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-02-22T11:32:19.455Z")

public class Edge   {
  @JsonProperty("source")
  private String source = null;

  @JsonProperty("target")
  private String target = null;

  @JsonProperty("messagesExchanged")
  private Integer messagesExchanged = null;

  @JsonProperty("size")
  private Integer size = null;

  public Edge source(String source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(example = "worker1", required = true, value = "")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Edge target(String target) {
    this.target = target;
    return this;
  }

   /**
   * Get target
   * @return target
  **/
  @ApiModelProperty(example = "worker2", required = true, value = "")
  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public Edge messagesExchanged(Integer messagesExchanged) {
    this.messagesExchanged = messagesExchanged;
    return this;
  }

   /**
   * number of aggregated messages
   * @return messagesExchanged
  **/
  @ApiModelProperty(example = "5", required = true, value = "number of aggregated messages")
  public Integer getMessagesExchanged() {
    return messagesExchanged;
  }

  public void setMessagesExchanged(Integer messagesExchanged) {
    this.messagesExchanged = messagesExchanged;
  }

  public Edge size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * message's bytes
   * @return size
  **/
  @ApiModelProperty(example = "4", required = true, value = "message's bytes")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Edge edge = (Edge) o;
    return Objects.equals(this.source, edge.source) &&
        Objects.equals(this.target, edge.target) &&
        Objects.equals(this.messagesExchanged, edge.messagesExchanged) &&
        Objects.equals(this.size, edge.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, target, messagesExchanged, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Edge {\n");
    
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    messagesExchanged: ").append(toIndentedString(messagesExchanged)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

