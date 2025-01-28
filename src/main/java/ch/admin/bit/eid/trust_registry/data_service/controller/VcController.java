/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bit.eid.trust_registry.data_service.controller;

import ch.admin.bit.eid.datastore.vc.service.VcEntityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/truststatements")
@AllArgsConstructor
@Tag(name = "Trust Statement Controller", description = "Returns Trust Statement VC entries from the datastore.")
public class VcController {

    private final VcEntityService vcEntityService;

    @GetMapping(value = "/{urlEncodedDIDofSubject}")
    @Operation(summary = "Get a vc entry from the datastore.", description = "Get a vc entry from the datastore.")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Returns a list of encoded trust statement VCs",
                            useReturnTypeSchema = true
                    ),
            }
    )
    public List<String> getVCEntries(
            @PathVariable(name = "urlEncodedDIDofSubject") String decodedDID, // swagger is handling the path encoding
            @RequestParam(defaultValue = "true") Boolean filterActive
    ) {
        return this.vcEntityService.getTrustStatementsForDid(decodedDID, filterActive);
    }
}
