/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bit.eid.datastore.vc.model.entity;

import ch.admin.bit.eid.datastore.shared.model.entity.DatastoreEntity;
import ch.admin.bit.eid.datastore.vc.model.enums.VcTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A VcEntity represents a VC of different formats and types in our data store.
 * <p>
 * VcEntity does store the actual vc (with signature and other addenda)
 * along the payload json.
 * This allows to filter and search for payload driven elements specific to the
 * type of VC handled while also providing a generalized way how to handle VCs of
 * different types and formats.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "vc_entity")
public class VcEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_id", referencedColumnName = "id")
    private DatastoreEntity base;

    @Column(name = "vc_type")
    @Enumerated(EnumType.STRING)
    private VcTypeEnum vcType;

    /**
     * The VC in its encoded form, the way it is delivered to the registry.
     * <p>
     * SD-JWT Example:
     * eyJ0eXAiOiJzZCtqd3QiLCJhbGciOiJFUzI1NiJ9.eyJpZCI6IjEyMzQiLCJfc2QiOlsiYkRUUnZtNS1Zbi1IRzdjcXBWUjVPVlJJWHNTYUJrNTdKZ2lPcV9qMVZJNCIsImV0M1VmUnlsd1ZyZlhkUEt6Zzc5aGNqRDFJdHpvUTlvQm9YUkd0TW9zRmsiLCJ6V2ZaTlMxOUF0YlJTVGJvN3NKUm4wQlpRdldSZGNob0M3VVphYkZyalk4Il0sIl9zZF9hbGciOiJzaGEtMjU2In0.n27NCtnuwytlBYtUNjgkesDP_7gN7bhaLhWNL4SWT6MaHsOjZ2ZMp987GgQRL6ZkLbJ7Cd3hlePHS84GBXPuvg~WyI1ZWI4Yzg2MjM0MDJjZjJlIiwiZmlyc3RuYW1lIiwiSm9obiJd~WyJjNWMzMWY2ZWYzNTg4MWJjIiwibGFzdG5hbWUiLCJEb2UiXQ~WyJmYTlkYTUzZWJjOTk3OThlIiwic3NuIiwiMTIzLTQ1LTY3ODkiXQ~
     */
    @Column(name = "raw_vc")
    private String rawVc;

    /**
     * The payload of the VC in its resolved form
     * SD-JWT/JWT Example:
     * {
     * "iss": "did:example:something",
     * "sub": "did:example:anything",
     * "key": "value"
     * }
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "vc_payload")
    private String vcPayload;
}
