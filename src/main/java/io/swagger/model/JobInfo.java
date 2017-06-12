package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * JobInfo
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-05-10T09:50:51.068Z")

public class JobInfo   {
	@JsonProperty("computationDuration")
	private Double computationDuration = null;

	@JsonProperty("nworkers")
	private Integer nworkers = null;

	@JsonProperty("nhosts")
	private Integer nhosts = null;

	@JsonProperty("nracks")
	private Integer nracks = null;

	@JsonProperty("nsupersteps")
	private Integer nsupersteps = null;
	
	@JsonProperty("nmessages")
	private Long nmessages = null;

	@JsonProperty("bytes")
	private Long bytes = null;

	@JsonProperty("racklist")
	private List<Rack> racklist = new ArrayList<Rack>();

	public JobInfo computationDuration(Double computationDuration) {
		this.computationDuration = computationDuration;
		return this;
	}

	/**
	 * Get computationDuration
	 * @return computationDuration
	 **/
	@ApiModelProperty(required = true, value = "")
	public Double getComputationDuration() {
		return computationDuration;
	}

	public void setComputationDuration(Double computationDuration) {
		this.computationDuration = computationDuration;
	}

	public JobInfo racklist(List<Rack> racklist) {
		this.racklist = racklist;
		return this;
	}

	public JobInfo addRacklistItem(Rack racklistItem) {
		this.racklist.add(racklistItem);
		return this;
	}

	/**
	 * Get racklist
	 * @return racklist
	 **/
	@ApiModelProperty(required = true, value = "")
	public List<Rack> getRacklist() {
		return racklist;
	}

	public void setRacklist(List<Rack> racklist) {
		this.racklist = racklist;
	}

	/**
	 * Get nworkers
	 * @return nworkers
	 **/
	@ApiModelProperty(required = true, value = "")
	public Integer getNworkers() {
		return nworkers;
	}

	public void setNworkers(Integer nworkers) {
		this.nworkers = nworkers;
	}

	/**
	 * Get nhosts
	 * @return nhosts
	 **/
	@ApiModelProperty(required = true, value = "")
	public Integer getNhosts() {
		return nhosts;
	}

	public void setNhosts(Integer nhosts) {
		this.nhosts = nhosts;
	}
	
	/**
	 * Get nhosts
	 * @return nhosts
	 **/
	@ApiModelProperty(required = true, value = "")
	public Long getNMessages() {
		return nmessages;
	}

	public void setNMessages(Long nmessages) {
		this.nmessages = nmessages;
	}
	
	/**
	 * Get nhosts
	 * @return nhosts
	 **/
	@ApiModelProperty(required = true, value = "")
	public Long getBytes() {
		return bytes;
	}

	public void setBytes(Long bytes) {
		this.bytes = bytes;
	}	

	/**
	 * Get nracks
	 * @return nracks
	 **/
	@ApiModelProperty(required = true, value = "")
	public Integer getNracks() {
		return nracks;
	}

	public void setNracks(Integer nracks) {
		this.nracks = nracks;
	}

	/**
	 * Get nsupersteps
	 * @return nsupersteps
	 **/
	@ApiModelProperty(required = true, value = "")
	public Integer getNsupersteps() {
		return nsupersteps;
	}

	public void setNsupersteps(Integer nsupersteps) {
		this.nsupersteps = nsupersteps;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		JobInfo jobInfo = (JobInfo) o;
		return Objects.equals(this.computationDuration, jobInfo.computationDuration) &&
				Objects.equals(this.racklist, jobInfo.racklist); //&&
				//Objects.equals(this.supersteps, jobInfo.supersteps);
	}

	@Override
	public int hashCode() {
		return Objects.hash(computationDuration, racklist/*, supersteps*/);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class JobInfo {\n");

		sb.append("    computationDuration: ").append(toIndentedString(computationDuration)).append("\n");
		sb.append("    racklist: ").append(toIndentedString(racklist)).append("\n");
//		sb.append("    supersteps: ").append(toIndentedString(supersteps)).append("\n");
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
