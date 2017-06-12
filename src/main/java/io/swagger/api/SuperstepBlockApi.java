package io.swagger.api;

import io.swagger.model.SuperstepBlock;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-02-22T11:32:19.455Z")

@Api(value = "SuperstepBlock", description = "the SuperstepBlock API")
public interface SuperstepBlockApi {

    @ApiOperation(value = "get superstepblock's data", notes = "Get the superstepblock's data ", response = SuperstepBlock.class, responseContainer = "List", tags={ "developers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "SuperstepBlock's data", response = SuperstepBlock.class),
        @ApiResponse(code = 400, message = "bad input parameter", response = SuperstepBlock.class) })
    @RequestMapping(value = "/SuperstepBlock",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<SuperstepBlock>> superstep(@ApiParam(value = "jobId", required = true) @RequestParam(value = "job", required = true) String job,
        @ApiParam(value = "start index of superstep", required = true) @RequestParam(value = "startIndex", required = true) Integer startIndex,
        @ApiParam(value = "end index of superstep", required = true) @RequestParam(value = "endIndex", required = true) Integer endIndex,
        @ApiParam(value = "size of superstep to aggregate", required = true) @RequestParam(value = "blockSize", required = true) Integer blockSize,
        @ApiParam(value = "desired hierarchy scale", required = true) @RequestParam(value = "scale", required = true) String scale);

}
