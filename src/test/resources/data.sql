/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

--  Good entry, not initialized 00000000-0000-0000-0000-000000000000
INSERT INTO datastore_entity (id, status)
VALUES ('00000000-0000-0000-0000-000000000000', 'SETUP');
--  Good entry
INSERT INTO datastore_entity (id, status)
VALUES ('00000000-0000-0000-0000-000000000001', 'ACTIVE');
INSERT INTO vc_entity (base_id, vc_type, raw_vc, vc_payload)
VALUES ('00000000-0000-0000-0000-000000000001', 'DID_TDW',
        'eyJhbGciOiJFUzI1NiIsImtpZCI6ImRpZDp0ZHc6dHJ1c3QuYWRtaW4uY2g6R292I2tleS0wMSIsInR5cCI6InZjK3NkLWp3dCJ9.eyJ2Y3QiOiJUcnVzdFN0YXRlbWVudE1ldGFkYXRhVjEiLCJpc3MiOiJkaWQ6dGR3OnRydXN0LmFkbWluLmNoOkdvdiIsInN1YiI6ImRpZDp0cnVzdC5hZG1pbi5jaDphY3Rvci4uLiIsImlhdCI6MTcyNDEzMjY5MywibmJmIjoxNzI0MDQ2MjkzLCJleHAiOjE4MTg3NDA2OTMsInN0YXR1cyI6Ii4uLiIsImFjdGlvbiI6Ik1ldGFkYXRhVmFsaWRhdGVkIiwib3JnTmFtZSI6eyJlbiI6IkpvaG4gU21pdGgncyBTbWl0aGVyeSIsImRlLUNIIjoiSm9obiBTbWl0aCdzIFNjaG1pZGVyZWkifSwibG9nb1VyaSI6eyJlbiI6ImRhdGE6aW1hZ2UvcG5nO2Jhc2U2NCxpVkIuLi4ifSwicHJlZkxhbmciOiJlbiJ9.HvZEjbMjvP5-PsrnO6u-jeUjW46YtzQ599LOLEk1fHwWsDAyp8hp7Lb_dHVTBox5Oo7Rf2ICFr87eo4p8K3P0g',
        '{"exp": 1818740693, "iat": 1724132693, "iss": "did:tdw:trust.admin.ch:Gov", "nbf": 1724046293, "sub": "did:trust.admin.ch:actor...", "vct": "TrustStatementMetadataV1", "action": "MetadataValidated", "status": "...", "logoUri": {"en": "data:image/png;base64,iVB..."}, "orgName": {"en": "John Smith''s Smithery", "de-CH": "John Smith''s Schmiderei"}, "prefLang": "en"}');

--  Bad entry, far to old
INSERT INTO datastore_entity (id, status)
VALUES ('00000000-0000-0000-0000-000000000002', 'ACTIVE');
INSERT INTO vc_entity (base_id, vc_type, raw_vc, vc_payload)
VALUES ('00000000-0000-0000-0000-000000000002', 'DID_TDW',
        'eyJhbGciOiJFUzI1NiIsImtpZCI6ImRpZDp0ZHc6dHJ1c3QuYWRtaW4uY2g6R292I2tleS0wMSIsInR5cCI6InZjK3NkLWp3dCJ9.eyJ2Y3QiOiJUcnVzdFN0YXRlbWVudE1ldGFkYXRhVjEiLCJpc3MiOiJkaWQ6dGR3OnRydXN0LmFkbWluLmNoOkdvdiIsInN1YiI6ImRpZDp0cnVzdC5hZG1pbi5jaDphY3Rvci4uLiIsImlhdCI6MTcyNDEzMTk3MCwibmJmIjoxNzIzMjY3OTcwLCJleHAiOjE3MjQwNDU1NzAsInN0YXR1cyI6Ii4uLiIsImFjdGlvbiI6Ik1ldGFkYXRhVmFsaWRhdGVkIiwib3JnTmFtZSI6eyJlbiI6IkpvaG4gU21pdGgncyBTbWl0aGVyeSIsImRlLUNIIjoiSm9obiBTbWl0aCdzIFNjaG1pZGVyZWkifSwibG9nb1VyaSI6eyJlbiI6ImRhdGE6aW1hZ2UvcG5nO2Jhc2U2NCxpVkIuLi4ifSwicHJlZkxhbmciOiJlbiJ9.DBmlgg1IcPssv1s44yX4uRpbiNoRMKC4mBvsTG4-ehAswwLA13sixUrISS_T-kmStQ4qDZuq1S9w3oyj4tjooQ',
        '{"exp": 1724045570, "iat": 1724131970, "iss": "did:tdw:trust.admin.ch:Gov", "nbf": 1723267970, "sub": "did:trust.admin.ch:actor...", "vct": "TrustStatementMetadataV1", "action": "MetadataValidated", "status": "...", "logoUri": {"en": "data:image/png;base64,iVB..."}, "orgName": {"en": "John Smith''s Smithery", "de-CH": "John Smith''s Schmiderei"}, "prefLang": "en"}');

--  Bad entry, belongs to the future
INSERT INTO datastore_entity (id, status)
VALUES ('00000000-0000-0000-0000-000000000003', 'ACTIVE');
INSERT INTO vc_entity (base_id, vc_type, raw_vc, vc_payload)
VALUES ('00000000-0000-0000-0000-000000000003', 'DID_TDW',
        'eyJhbGciOiJFUzI1NiIsImtpZCI6ImRpZDp0ZHc6dHJ1c3QuYWRtaW4uY2g6R292I2tleS0wMSIsInR5cCI6InZjK3NkLWp3dCJ9.eyJ2Y3QiOiJUcnVzdFN0YXRlbWVudE1ldGFkYXRhVjEiLCJpc3MiOiJkaWQ6dGR3OnRydXN0LmFkbWluLmNoOkdvdiIsInN1YiI6ImRpZDp0cnVzdC5hZG1pbi5jaDphY3Rvci4uLiIsImlhdCI6MTcyNDEzMTk3MCwibmJmIjoyNTg4MTMxOTcwLCJleHAiOjI1ODg5OTU5NzAsInN0YXR1cyI6Ii4uLiIsImFjdGlvbiI6Ik1ldGFkYXRhVmFsaWRhdGVkIiwib3JnTmFtZSI6eyJlbiI6IkpvaG4gU21pdGgncyBTbWl0aGVyeSIsImRlLUNIIjoiSm9obiBTbWl0aCdzIFNjaG1pZGVyZWkifSwibG9nb1VyaSI6eyJlbiI6ImRhdGE6aW1hZ2UvcG5nO2Jhc2U2NCxpVkIuLi4ifSwicHJlZkxhbmciOiJlbiJ9.5c5ViKwnaIBkVvKqAe2DhBUbPj03KATNB654baIIU7o0LtIxMqVtO69ZFBfSuj_qKwmBhehl3QprU930fQqovw',
        '{"exp": 2588995970, "iat": 1724131970, "iss": "did:tdw:trust.admin.ch:Gov", "nbf": 2588131970, "sub": "did:trust.admin.ch:actor...", "vct": "TrustStatementMetadataV1", "action": "MetadataValidated", "status": "...", "logoUri": {"en": "data:image/png;base64,iVB..."}, "orgName": {"en": "John Smith''s Smithery", "de-CH": "John Smith''s Schmiderei"}, "prefLang": "en"}');

--  Disabled entry
INSERT INTO datastore_entity (id, status)
VALUES ('00000000-0000-0000-0000-000000000004', 'DISABLED');
INSERT INTO vc_entity (base_id, vc_type, raw_vc, vc_payload)
VALUES ('00000000-0000-0000-0000-000000000004', 'DID_TDW',
        'eyJhbGciOiJFUzI1NiIsImtpZCI6ImRpZDp0ZHc6dHJ1c3QuYWRtaW4uY2g6R292I2tleS0wMSIsInR5cCI6InZjK3NkLWp3dCJ9.eyJ2Y3QiOiJUcnVzdFN0YXRlbWVudE1ldGFkYXRhVjEiLCJpc3MiOiJkaWQ6dGR3OnRydXN0LmFkbWluLmNoOkdvdiIsInN1YiI6ImRpZDp0cnVzdC5hZG1pbi5jaDphY3Rvci4uLiIsImlhdCI6MTcyNDEzMjY5MywibmJmIjoxNzI0MDQ2MjkzLCJleHAiOjE4MTg3NDA2OTMsInN0YXR1cyI6Ii4uLiIsImFjdGlvbiI6Ik1ldGFkYXRhVmFsaWRhdGVkIiwib3JnTmFtZSI6eyJlbiI6IkpvaG4gU21pdGgncyBTbWl0aGVyeSIsImRlLUNIIjoiSm9obiBTbWl0aCdzIFNjaG1pZGVyZWkifSwibG9nb1VyaSI6eyJlbiI6ImRhdGE6aW1hZ2UvcG5nO2Jhc2U2NCxpVkIuLi4ifSwicHJlZkxhbmciOiJlbiJ9.HvZEjbMjvP5-PsrnO6u-jeUjW46YtzQ599LOLEk1fHwWsDAyp8hp7Lb_dHVTBox5Oo7Rf2ICFr87eo4p8K3P0g',
        '{"exp": 1818740693, "iat": 1724132693, "iss": "did:tdw:trust.admin.ch:Gov", "nbf": 1724046293, "sub": "did:trust.admin.ch:actor...", "vct": "TrustStatementMetadataV1", "action": "MetadataValidated", "status": "...", "logoUri": {"en": "data:image/png;base64,iVB..."}, "orgName": {"en": "John Smith''s Smithery", "de-CH": "John Smith''s Schmiderei"}, "prefLang": "en"}');

--  Deactivated entry
INSERT INTO datastore_entity (id, status)
VALUES ('00000000-0000-0000-0000-000000000005', 'DEACTIVATED');
INSERT INTO vc_entity (base_id, vc_type, raw_vc, vc_payload)
VALUES ('00000000-0000-0000-0000-000000000005', 'DID_TDW',
        'eyJhbGciOiJFUzI1NiIsImtpZCI6ImRpZDp0ZHc6dHJ1c3QuYWRtaW4uY2g6R292I2tleS0wMSIsInR5cCI6InZjK3NkLWp3dCJ9.eyJ2Y3QiOiJUcnVzdFN0YXRlbWVudE1ldGFkYXRhVjEiLCJpc3MiOiJkaWQ6dGR3OnRydXN0LmFkbWluLmNoOkdvdiIsInN1YiI6ImRpZDp0cnVzdC5hZG1pbi5jaDphY3Rvci4uLiIsImlhdCI6MTcyNDEzMjY5MywibmJmIjoxNzI0MDQ2MjkzLCJleHAiOjE4MTg3NDA2OTMsInN0YXR1cyI6Ii4uLiIsImFjdGlvbiI6Ik1ldGFkYXRhVmFsaWRhdGVkIiwib3JnTmFtZSI6eyJlbiI6IkpvaG4gU21pdGgncyBTbWl0aGVyeSIsImRlLUNIIjoiSm9obiBTbWl0aCdzIFNjaG1pZGVyZWkifSwibG9nb1VyaSI6eyJlbiI6ImRhdGE6aW1hZ2UvcG5nO2Jhc2U2NCxpVkIuLi4ifSwicHJlZkxhbmciOiJlbiJ9.HvZEjbMjvP5-PsrnO6u-jeUjW46YtzQ599LOLEk1fHwWsDAyp8hp7Lb_dHVTBox5Oo7Rf2ICFr87eo4p8K3P0g',
        '{"exp": 1818740693, "iat": 1724132693, "iss": "did:tdw:trust.admin.ch:Gov", "nbf": 1724046293, "sub": "did:trust.admin.ch:actor...", "vct": "TrustStatementMetadataV1", "action": "MetadataValidated", "status": "...", "logoUri": {"en": "data:image/png;base64,iVB..."}, "orgName": {"en": "John Smith''s Smithery", "de-CH": "John Smith''s Schmiderei"}, "prefLang": "en"}');
