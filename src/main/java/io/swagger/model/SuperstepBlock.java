package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Edge;
import java.util.ArrayList;
import java.util.List;

/**
 * SuperstepBlock
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-02-22T11:32:19.455Z")

public class SuperstepBlock   {
	@JsonProperty("scale")
	private String scale = null;

	@JsonProperty("nstep")
	private Integer nstep = null;

	@JsonProperty("numberOfBlock")
	private Integer numberOfBlock = null;

	@JsonProperty("duration")
	private Double duration = null;

	@JsonProperty("edges")
	private List<Edge> edges = new ArrayList<Edge>();

	@JsonProperty("blockElementDetails")
	private List<BlockDetailsPerElement> blockDetails = new ArrayList<BlockDetailsPerElement>();

	@JsonProperty("timeIndex")
	private Double timeIndex = null;

	@JsonProperty("computations")
	 private List<Computation> computations = new ArrayList<Computation>();

	@JsonProperty("latencies")
	private List<Latency> latencies = new ArrayList<Latency>();

	public SuperstepBlock scale(String scale) {
		this.scale = scale;
		return this;
	}

	/**
	 * scale of the hierarchy
	 * @return scale
	 **/
	@ApiModelProperty(required = true, value = "scale of the hierarchy")
	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public SuperstepBlock nstep(Integer nstep) {
		this.nstep = nstep;
		return this;
	}

	/**
	 * number of aggregated superstep
	 * @return nstep
	 **/
	@ApiModelProperty(required = true, value = "number of aggregated superstep")
	public Integer getNstep() {
		return nstep;
	}

	public void setNstep(Integer nstep) {
		this.nstep = nstep;
	}

	public SuperstepBlock numberOfBlock(Integer number) {
		this.numberOfBlock = number;
		return this;
	}

	public SuperstepBlock addSuperstepsItem(BlockDetailsPerElement superstepsItem) {
		this.blockDetails.add(superstepsItem);
		return this;
	}

	/**
	 * Get supersteps
	 * @return supersteps
	 **/
	@ApiModelProperty(required = true, value = "")
	public List<BlockDetailsPerElement> getBlockDetails() {
		return blockDetails;
	}

	public void setBlockDetails(List<BlockDetailsPerElement> supersteps) {
		this.blockDetails = supersteps;
	}

	/**
	 * Get number
	 * @return number
	 **/
	@ApiModelProperty(required = true, value = "")
	public Integer getNumberOfBlock() {
		return numberOfBlock;
	}

	public void setNumberOfBlock(Integer number) {
		this.numberOfBlock = number;
	}

	public SuperstepBlock duration(Double length) {
		this.duration = length;
		return this;
	}

	/**
	 * Get length
	 * @return length
	 **/
	@ApiModelProperty(example = "2000 (ms)", required = true, value = "")
	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double length) {
		this.duration = length;
	}

	public SuperstepBlock timeIndex(Double length) {
		this.duration = length;
		return this;
	}

	/**
	 * Get timeIndex
	 * @return timeIndex
	 **/
	@ApiModelProperty(example = "2000 (ms)", required = true, value = "")
	public Double getTimeIndex() {
		return timeIndex;
	}

	public void setTimeIndex(Double timeIndex) {
		this.timeIndex = timeIndex;
	}

	public SuperstepBlock edges(List<Edge> edges) {
		this.edges = edges;
		return this;
	}

	public SuperstepBlock addEdgesItem(Edge edgesItem) {
		this.edges.add(edgesItem);
		return this;
	}

	/**
	 * Get edges
	 * @return edges
	 **/
	@ApiModelProperty(required = true, value = "")
	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	public SuperstepBlock computations(List<Computation> computations) {
	    this.computations = computations;
	    return this;
	}

	public SuperstepBlock addComputationsItem(Computation computationsItem) {
	    this.computations.add(computationsItem);
	    return this;
	}

    /**
    * Get computations
	* @return computations
	**/
	@ApiModelProperty(required = true, value = "")
	 public List<Computation> getComputations() {
	    return computations;
	 }

	 public void setComputations(List<Computation> computations) {
		this.computations = computations;
	 }

	public SuperstepBlock latencies(List<Latency> latencies) {
		this.latencies = latencies;
		return this;
	}

	public SuperstepBlock addLatenciesItem(Latency latenciesItem) {
		this.latencies.add(latenciesItem);
		return this;
	}

	/**
	 * Get latencies
	 * @return latencies
	 **/
	@ApiModelProperty(required = true, value = "")
	public List<Latency> getLatencies() {
		return latencies;
	}

	public void setLatencies(List<Latency> latencies) {
		this.latencies = latencies;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SuperstepBlock superstepBlock = (SuperstepBlock) o;
		return Objects.equals(this.scale, superstepBlock.scale) &&
				Objects.equals(this.nstep, superstepBlock.nstep) &&
				Objects.equals(this.numberOfBlock, superstepBlock.numberOfBlock) &&
				Objects.equals(this.duration, superstepBlock.duration) &&
				Objects.equals(this.edges, superstepBlock.edges) &&
		        Objects.equals(this.computations, superstepBlock.computations) &&
				Objects.equals(this.latencies, superstepBlock.latencies);								
	}

	@Override
	public int hashCode() {
		return Objects.hash(scale, nstep, numberOfBlock, duration, edges);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SuperstepBlock {\n");

		sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
		sb.append("    nstep: ").append(toIndentedString(nstep)).append("\n");
		sb.append("    number: ").append(toIndentedString(numberOfBlock)).append("\n");
		sb.append("    length: ").append(toIndentedString(duration)).append("\n");
		sb.append("    edges: ").append(toIndentedString(edges)).append("\n");
	    sb.append("    computations: ").append(toIndentedString(computations)).append("\n");
		sb.append("    latencies: ").append(toIndentedString(latencies)).append("\n");		
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

