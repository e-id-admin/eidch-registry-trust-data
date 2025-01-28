/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bit.eid.trust_registry.data_service.it;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class VcControllerTest {

    private static final String ENTRY_TS_URL = "/api/v1/truststatements/";

    @Autowired
    protected MockMvc mvc;

    // @Test() Disabled due to postres features used which are not h2 compatible
    void testCheckVc_noDataKnown_response() throws Exception {
        mvc
                .perform(get(ENTRY_TS_URL + "did:tdw:trust.admin.ch:Unknown"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.arrayWithSize(0)));
    }

    // @Test() Disabled due to postres features used which are not h2 compatible
    void testCheckVc_noExplicitFilter_response() throws Exception {
        mvc
                .perform(get(ENTRY_TS_URL + "did:trust.admin.ch:actor..."))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.arrayWithSize(1)))
                .andExpect(
                        jsonPath(
                                "$",
                                Matchers.arrayContaining(
                                        "eyJhbGciOiJFUzI1NiIsImtpZCI6ImRpZDp0ZHc6dHJ1c3QuYWRtaW4uY2g6R292I2tleS0wMSIsInR5cCI6InZjK3NkLWp3dCJ9.eyJ2Y3QiOiJUcnVzdFN0YXRlbWVudE1ldGFkYXRhVjEiLCJpc3MiOiJkaWQ6dGR3OnRydXN0LmFkbWluLmNoOkdvdiIsInN1YiI6ImRpZDp0cnVzdC5hZG1pbi5jaDphY3Rvci4uLiIsImlhdCI6MTcyNDEzMjY5MywibmJmIjoxNzI0MDQ2MjkzLCJleHAiOjE4MTg3NDA2OTMsInN0YXR1cyI6Ii4uLiIsImFjdGlvbiI6Ik1ldGFkYXRhVmFsaWRhdGVkIiwib3JnTmFtZSI6eyJlbiI6IkpvaG4gU21pdGgncyBTbWl0aGVyeSIsImRlLUNIIjoiSm9obiBTbWl0aCdzIFNjaG1pZGVyZWkifSwibG9nb1VyaSI6eyJlbiI6ImRhdGE6aW1hZ2UvcG5nO2Jhc2U2NCxpVkIuLi4ifSwicHJlZkxhbmciOiJlbiJ9.HvZEjbMjvP5-PsrnO6u-jeUjW46YtzQ599LOLEk1fHwWsDAyp8hp7Lb_dHVTBox5Oo7Rf2ICFr87eo4p8K3P0g"
                                )
                        )
                );
    }

    // @Test() Disabled due to postres features used which are not h2 compatible
    void testCheckVc_explicitActiveFilterTrue_response() throws Exception {
        mvc
                .perform(get(ENTRY_TS_URL + "did:trust.admin.ch:actor...?filterActive=true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.arrayWithSize(1)))
                .andExpect(
                        jsonPath(
                                "$",
                                Matchers.arrayContaining(
                                        "eyJhbGciOiJFUzI1NiIsImtpZCI6ImRpZDp0ZHc6dHJ1c3QuYWRtaW4uY2g6R292I2tleS0wMSIsInR5cCI6InZjK3NkLWp3dCJ9.eyJ2Y3QiOiJUcnVzdFN0YXRlbWVudE1ldGFkYXRhVjEiLCJpc3MiOiJkaWQ6dGR3OnRydXN0LmFkbWluLmNoOkdvdiIsInN1YiI6ImRpZDp0cnVzdC5hZG1pbi5jaDphY3Rvci4uLiIsImlhdCI6MTcyNDEzMjY5MywibmJmIjoxNzI0MDQ2MjkzLCJleHAiOjE4MTg3NDA2OTMsInN0YXR1cyI6Ii4uLiIsImFjdGlvbiI6Ik1ldGFkYXRhVmFsaWRhdGVkIiwib3JnTmFtZSI6eyJlbiI6IkpvaG4gU21pdGgncyBTbWl0aGVyeSIsImRlLUNIIjoiSm9obiBTbWl0aCdzIFNjaG1pZGVyZWkifSwibG9nb1VyaSI6eyJlbiI6ImRhdGE6aW1hZ2UvcG5nO2Jhc2U2NCxpVkIuLi4ifSwicHJlZkxhbmciOiJlbiJ9.HvZEjbMjvP5-PsrnO6u-jeUjW46YtzQ599LOLEk1fHwWsDAyp8hp7Lb_dHVTBox5Oo7Rf2ICFr87eo4p8K3P0g"
                                )
                        )
                );
    }

    // @Test() Disabled due to postres features used which are not h2 compatible
    void testCheckVc_explicitActiveFilterFalse_response() throws Exception {
        mvc
                .perform(get(ENTRY_TS_URL + "did:trust.admin.ch:actor...?filterActive=false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.arrayWithSize(3)));
    }
}
